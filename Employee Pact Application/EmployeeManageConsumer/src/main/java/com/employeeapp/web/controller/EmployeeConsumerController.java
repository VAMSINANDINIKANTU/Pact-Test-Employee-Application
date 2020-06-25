package com.employeeapp.web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.employeeapp.entities.Employee;
import com.employeeapp.service.EmployeeService;

@RestController
public class EmployeeConsumerController {
	@Autowired
	EmployeeService employeeService;
	@GetMapping("hii")
    public ResponseEntity<String> keepAlive() {
        return ResponseEntity.ok("hii");
    }
	
	@GetMapping("employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {
		return employeeService.getEmployee(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("employeeName/{fullName}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("fullName") String fullName) {
		return employeeService.getEmployee(fullName).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
}