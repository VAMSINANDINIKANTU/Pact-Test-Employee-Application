package com.employeeapp.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employeeapp.entities.Employee;

@Service
public class EmployeeService {
	@Autowired
	ProviderConnector providerConnector;

	public EmployeeService(ProviderConnector providerConnector) {
		super();
		this.providerConnector = providerConnector;
	}

	public Optional<Employee> getEmployee(Long id) {
		Optional<Employee> EmployeeHolder = Optional.empty();
		try {
			EmployeeHolder = Optional.ofNullable(providerConnector.serializeData(
					providerConnector.getData(String.format("/employee/%d", id)).getBody(), Employee.class));
		} catch (Exception e) {
			e.printStackTrace();
			return EmployeeHolder;
		}
		return EmployeeHolder;
	}

	public Optional<Employee> getEmployee(String fullName) {
		Optional<Employee> EmployeeHolder = Optional.empty();
		try {
			EmployeeHolder = Optional.ofNullable(providerConnector.serializeData(
					providerConnector.getData(String.format("/employeeName/%s", fullName)).getBody(), Employee.class));
		} catch (Exception e) {
			e.printStackTrace();
			return EmployeeHolder;
		}
		return EmployeeHolder;
	}
}
