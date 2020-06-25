package com.employeeapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.employeeapp.entities.Employee;
import com.employeeapp.entities.Employer;
import com.employeeapp.repository.EmployeeRepository;
import com.employeeapp.repository.EmployerRepository;

@SpringBootApplication
public class EmployeeManageApplication implements CommandLineRunner {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployerRepository employerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeManageApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	}
}
