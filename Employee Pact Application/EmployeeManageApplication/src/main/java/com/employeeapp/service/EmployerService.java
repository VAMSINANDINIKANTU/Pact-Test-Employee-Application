package com.employeeapp.service;
import java.util.List;
import java.util.Optional;
import com.employeeapp.entities.Employee;
import com.employeeapp.entities.Employer;
public interface EmployerService {
	public List<Employer> getAll();
	public Optional<Employer> findEmployerById(Long employerId);
	public Optional<Employer> findEmployerByName(String employerName);
	public Employer addEmployer(Employer employer);
	public void deleteEmployer(Long employerId);
}
