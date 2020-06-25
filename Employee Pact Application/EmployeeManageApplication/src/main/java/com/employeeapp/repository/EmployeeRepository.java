package com.employeeapp.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.employeeapp.entities.Employee;
import com.employeeapp.entities.Employer;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	 public Optional<Employee>findById(Long id);
	 public List<Employee>findEmployeeBySalaryGreaterThan(double salary);
	 public Optional<Employee> findByfirstName(String firstName); 
	 public Optional<Employee> findBylastName(String lastName); 
	 public Optional<Employee> findByfullName(String fullName);
	
}