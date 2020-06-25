package com.employeeapp.service;
import java.util.List;
import java.util.Optional;
import com.employeeapp.entities.Employee;
public interface EmployeeService {
	 public Optional<Employee> findEmployeeById(Long id);
	 public List<Employee>findEmployeeBySalary(double salary);
	 public List<Employee>getAllEmployee();
	 public Optional<Employee>findEmployeeByfirstName(String firstName); 
	 public Optional<Employee>findEmployeeBylastName(String lastName);
	 public Optional<Employee> findEmployeeByName(String fullName); 
	 public Employee addEmployee(Employee employee);
	 public void deleteEmployee(Long id);
}