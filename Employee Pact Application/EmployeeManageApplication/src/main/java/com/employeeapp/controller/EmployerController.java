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
import com.employeeapp.entities.Employer;
import com.employeeapp.exceptionhandler.EmployerNotFoundException;
import com.employeeapp.service.EmployerService;

@RestController
public class EmployerController {
	private EmployerService employerservice;
    @Autowired
	public EmployerController(EmployerService employerservice) {
		super();
		this.employerservice = employerservice;
	}

	@GetMapping(path = "/manager", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employer>> getAllEmployers() {
		return new ResponseEntity<List<Employer>>(employerservice.getAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/manager/{employerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employer> getAnEmployerById(@PathVariable(name = "employerId") Long employerId) {
		Employer employer = employerservice.findEmployerById(employerId).orElseThrow(() -> new EmployerNotFoundException(employerId));
		return new ResponseEntity<Employer>(employer, HttpStatus.OK);
    }
	
	@GetMapping(path = "/managerName/{employerName}", produces = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Employer>getAnEmployer(@PathVariable(name = "employerName") String employerName) {
	    Employer employer =employerservice.findEmployerByName(employerName).orElseThrow(() -> new EmployerNotFoundException(employerName));
		return new ResponseEntity<Employer>(employer, HttpStatus.OK);
	}
	
	@PostMapping(path = "manager/{employerId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employer> addAnEmployer(@PathVariable(name = "employerId") Long employerId, @RequestBody Employer employer) {
		return new ResponseEntity<Employer>(employerservice.addEmployer(employer), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/manager/{employerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteAnEmployer(@PathVariable(name = "employerId") Long employerId) {
		employerservice.deleteEmployer(employerId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}