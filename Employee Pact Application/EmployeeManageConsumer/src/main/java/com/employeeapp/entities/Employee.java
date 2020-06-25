package com.employeeapp.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {
	private Long id;
	private String firstName;
	private String lastName;
	private String fullName;
	private double salary;
	private String department;
	private String phone;
	private String email;
	private String address;
	private Long  employer_fk;
	public Long getEmployer_fk() {
		return employer_fk;
	}

	public void setEmployer_fk(Long employer_fk) {
		this.employer_fk = employer_fk;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
			this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Employee(Long id, String firstName, String lastName, String fullName, double salary, String department,
			String phone, String email, String address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.salary = salary;
		this.department = department;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", fullName=" + fullName + ", salary="
				+ salary + ", department=" + department + ", phone=" + phone + ", email=" + email + ", address="
				+ address + "]";
	}

	public Employee() {

	}
}