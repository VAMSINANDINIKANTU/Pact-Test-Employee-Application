package com.employeeapp.entities;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employer_table_new")
public class Employer {
	@Id
	private Long employerId;
	private String employerName;
	private String phoneNo;
	private String email;
	private String address;
	@OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Employee> Employees = new ArrayList<>();

	public List<Employee> getEmployees() {
		return Employees;
	}

	public void setEmployees(List<Employee> employees) {
		Employees = employees;
	}

	public Long getEmployerId() {
		return employerId;
	}

	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Employer(Long employerId, String employerName, String phoneNo, String email, String address) {
		super();
		this.employerId = employerId;
		this.employerName = employerName;
		this.phoneNo = phoneNo;
		this.email = email;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employer [employerId=" + employerId + ", employerName=" + employerName + ", phoneNo=" + phoneNo
				+ ", email=" + email + ", address=" + address + "]";
	}

	public Employer() {
	}
}
