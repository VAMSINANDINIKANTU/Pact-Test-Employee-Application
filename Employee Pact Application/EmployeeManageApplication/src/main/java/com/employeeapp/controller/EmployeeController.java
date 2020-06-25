package com.employeeapp.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.employeeapp.entities.Employee;
import com.employeeapp.exceptionhandler.EmployeeNotFoundException;
import com.employeeapp.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;

	public EmployeeController(EmployeeService employeeservice) {
		super();
		this.employeeservice = employeeservice;
	}

	@GetMapping(path = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getAnEmployeeById(@PathVariable(name = "id") Long id) {
		Employee employee = employeeservice.findEmployeeById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@GetMapping(path = "/employee/limit/{salary}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getAnEmployeeBySalary(@PathVariable(name = "salary") double salary) {
		return new ResponseEntity<List<Employee>>(employeeservice.findEmployeeBySalary(salary), HttpStatus.OK);
	}

	@GetMapping(path = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return new ResponseEntity<List<Employee>>(employeeservice.getAllEmployee(), HttpStatus.OK);
	}

	@GetMapping(path = "/employeeFirstName/{firstName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getAnEmployeeByFirstName(@PathVariable(name = "firstName") String firstName) {
		Employee employee = employeeservice.findEmployeeByfirstName(firstName)
				.orElseThrow(() -> new EmployeeNotFoundException(firstName));
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@GetMapping(path = "/employeeLastName/{lastName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getAnEmployeeByLastName(@PathVariable(name = "lastName") String lastName) {
		Employee employee = employeeservice.findEmployeeBylastName(lastName)
				.orElseThrow(() -> new EmployeeNotFoundException(lastName));
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@GetMapping(path = "/employeeName/{fullName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getAnEmployeeByName(@PathVariable(name = "fullName") String fullName) {
		Employee employee = employeeservice.findEmployeeByName(fullName)
				.orElseThrow(() -> new EmployeeNotFoundException(fullName));
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@PostMapping(path = "/employee/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> addAnEmployee(@PathVariable(name = "id") Long id, @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeservice.addEmployee(employee), HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteAnEmployee(@PathVariable(name = "id") Long id) {
		employeeservice.deleteEmployee(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}