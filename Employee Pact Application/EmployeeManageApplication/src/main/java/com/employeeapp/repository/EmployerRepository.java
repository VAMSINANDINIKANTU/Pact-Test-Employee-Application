package com.employeeapp.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.employeeapp.entities.Employer;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
	public List<Employer> findAll();
	public Optional<Employer> findByemployerId(Long employerId);
	public Optional<Employer> findByemployerName(String employerName);
}