package com.employeeapp.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employeeapp.entities.Employee;
import com.employeeapp.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImplementation implements EmployeeService {
	@Autowired
	private EmployeeRepository employeerepository;

	@Override
	public Optional<Employee> findEmployeeById(Long id) {
		return employeerepository.findById(id);
	}

	@Override
	public List<Employee> findEmployeeBySalary(double salary) {
		return employeerepository.findEmployeeBySalaryGreaterThan(salary);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeerepository.findAll();
	}

	@Override
	public Optional<Employee> findEmployeeByfirstName(String firstName) {
		return employeerepository.findByfirstName(firstName);
	}

	@Override
	public Optional<Employee> findEmployeeBylastName(String lastName) {
		return employeerepository.findBylastName(lastName);
	}

	@Override
	public Optional<Employee> findEmployeeByName(String fullName) {
		return employeerepository.findByfullName(fullName);
	}

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeerepository.save(employee);
				
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		employeerepository.deleteById(id);
		
	}

	
}