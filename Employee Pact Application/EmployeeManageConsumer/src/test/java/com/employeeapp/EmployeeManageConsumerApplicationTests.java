package com.employeeapp;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.employeeapp.entities.Employee;
import com.employeeapp.service.EmployeeService;
import com.employeeapp.service.ProviderConnector;
import com.fasterxml.jackson.databind.ObjectMapper;
import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class EmployeeManageConsumerApplicationTests {

	@Autowired
	EmployeeService employeeconsumerService;
	@Rule
	public PactProviderRuleMk2 mockProvider = new PactProviderRuleMk2("pactprovideremployee", "localhost", 8044, this);

	@Pact(consumer = "employeeconsumer") // will default to the provider name from mockProvider in Rule
	public RequestResponsePact defineExpectation(PactDslWithProvider builder) {
		return builder.uponReceiving("get employee data").path("/api/EmployeeManagement/employee/3").method("GET")
				.willRespondWith().status(200)
				.body("{\n" + "\t\"firstName\": \"poulami\",\n" + "\t\"lastName\": \"mohan\",\n"
						+ "\t\"fullName\": \"poulamimohan\",\n" + "\t\"salary\": 15000,\n"
						+ "\t\"department\": \"ui\",\n" + "\t\"phone\": \"8978902443\",\n"
						+ "\t\"email\": \"poulami@gmail.com\",\n" + "\t\"address\": \"Bangolre\",\n" + "}")
				.toPact();

	}

	@Pact(consumer = "employeeconsumer") // will default to the provider name from mockProvider in Rule
	public RequestResponsePact defineExpectationwithState(PactDslWithProvider builder) {
		return builder.given("SomeState").uponReceiving("get employee data not in database of provider")
				.path("/api/EmployeeManagement/employee/9").method("GET").willRespondWith().status(200)
				.body("{\n" + "\"Employee\": [\n" + "{\n" + "\t\"firstName\": \"pallavi\",\n"
						+ "\t\"lastName\": \"dasi\",\n" + "\t\"fullName\": \"pallavidas\",\n" + "\t\"salary\": 19000,\n"
						+ "\t\"department\": \"tester\",\n" + "\t\"phone\": \"9978902443\",\n"
						+ "\t\"email\": \"pallavi.dasi@gmail.com\",\n" + "\t\"address\": \"chennai\",\n"
						+ "\"Employer\":[\n" + "{\n" + "\t\"employerName\":\"rahul\",\n"
						+ "\t\"phoneNo\":\"9876543219\",\n" + "\t\"email\":\"rahul@gmail.com\",\n"
						+ "\t\"address\":\"Bangolre\",\n" + "}\n" + "]\n" + "}\n" + "]\n" + "}")
				.toPact();

	}

//	@Pact(consumer = "myconsumer") // will default to the provider name from mockProvider in Rule
//    public RequestResponsePact defineExpectationWithStateAndMap(PactDslWithProvider builder) {
//
//        PactDslJsonBody body = new PactDslJsonBody()
//                //.stringMatcher("Id","^([A-Z])[0-9]{3}$","9")
//        		.integerType("Id", "9L")
//                .stringValue("firstName","Taraka")
//                .stringValue("lastName", "rao")
//                .stringValue("fullName", "Tarakarao")
//                .numberType("salary", "22000")
//                .stringValue("department","developer")
//                .stringValue("phone","8888902443")
//                .stringValue("email","taraka@gmail.com")
//                .stringValue("address","ongole")
//                .asBody();
//        return builder
//                //.given("SomeStateWithMap", "Mykey1", "MyValue1", "Mykey2", "MyValue2")
//                .given("SomeStateWithMap", "Mykey1", new Employee(9L,"Taraka","rao", "Tarakarao", 22000, "developer", "8888902443", "taraka@gmail.com", "ongole"))
//                .uponReceiving("get Employee data with state and map")
//                .path("/api/EmployeeManagement/employee/9")
//                .method("GET")
//                .willRespondWith()
//                .status(200)
//                .body(body)
//                .toPact();
//    }
//	

	@Test
	@PactVerification(fragment = "defineExpectation")
	public void runTest() {
		Assert.assertTrue(employeeconsumerService.getEmployee((long) 3).isPresent());
	}

	@Test
	@PactVerification(fragment = "defineExpectationwithState")
	public void runTestWithState() {
		Assert.assertTrue(employeeconsumerService.getEmployee((long) 9).isPresent());
	}
}

@TestConfiguration
class TestConfig {
	@Bean
	public EmployeeService getEmployeeService(ProviderConnector providerConnector) {
		return new EmployeeService(providerConnector);
	}

	@Bean
	public ProviderConnector getProviderConnector(ObjectMapper objectMapper, RestTemplateBuilder restTemplateBuilder) {
		return new ProviderConnector("http://localhost:8044/api/EmployeeManagement", restTemplateBuilder, objectMapper);
	}

	@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}

	@Bean
	public RestTemplateBuilder getRestTemplateBuilder() {
		return new RestTemplateBuilder();
	}
}
