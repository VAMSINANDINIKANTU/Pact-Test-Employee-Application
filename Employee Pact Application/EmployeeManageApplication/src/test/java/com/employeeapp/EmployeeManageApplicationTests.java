package com.employeeapp;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import com.employeeapp.entities.Employee;
import com.employeeapp.entities.Employer;
import com.employeeapp.repository.EmployeeRepository;
import com.employeeapp.repository.EmployerRepository;
import com.employeeapp.service.EmployeeService;
import com.employeeapp.service.EmployerService;
import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.VerificationReports;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;

@RunWith(PactRunner.class)
@Provider("pactprovideremployee")
@VerificationReports({ "console", "markdown", "json" })
//@PactFolder("/C:\\Users\\win10\\workspaceSts\\EmployeeManageConsumer\\target\\pacts")
@PactBroker
public class EmployeeManageApplicationTests {

	private int PORT = 8092;

	@TestTarget
	public final Target target = new HttpTarget("http", "localhost", PORT);

	private static ConfigurableApplicationContext applicationContext;

	@BeforeClass
	public static void setVersions() {

		System.setProperty("pact.provider.version", "1.0.0");
		System.setProperty("pact.verifier.publishResults", "true");

	}

	@BeforeClass
	public static void start() {

		applicationContext = SpringApplication.run(EmployeeManageApplication.class);

	}

	@State("SomeState")
	public void withSomeState() {
		System.out.println("something with state");
		EmployeeService employeeservice = applicationContext.getBean(EmployeeService.class);
		EmployerService employerservice = applicationContext.getBean(EmployerService.class);
		EmployeeRepository repo = applicationContext.getBean(EmployeeRepository.class);
		EmployerRepository repo1 = applicationContext.getBean(EmployerRepository.class);

		// Employer employer1 = new
		// Employer(3L,"rahul","9876543219","rahul@gmail.com","Bangolre");
		// repo1.save(employer1);

		// Employee employee1 = new
		// Employee(9L,"pallavi","dasi","pallavidas",19000,"tester","9978902443","pallavi.dasi@gmail.com","chennai");

		// employee1.setEmployer(employer1);

		// repo.save(employee1);

		// employeeservice.createStudent(new Student("Z123", "Jerry Van Dam", 27, new
		// Address("line1", "line2", "postCode", "mycity")));
		// Employer emp=new Employer(3L, "rahul", "9876543219", "rahul@gmail.com",
		// "Bangolre");
		employeeservice.addEmployee((new Employee(9L, "pallavi", "dasi", "pallavidas", 19000, "tester", "9978902443",
				"pallavi.dasi@gmail.com", "chennai",
				new Employer(3L, "rahul", "9876543219", "rahul@gmail.com", "Bangolre"))));
		}
	}