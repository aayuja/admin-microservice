package com.demo.spring.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Employee {

	private Long empId;
	private String name;
	private String email;
	private String password;

	public Employee() {

	}
    
	private Set<Payslip> payslips = new HashSet<>();
	private Set<Timesheet> timesheets = new HashSet<>();
	private Set<Leave> leaves = new HashSet<>();
	private Salary salary;
	
	

	public Employee(Long empId, String name, String email,String password) {
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.password=password;

	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	
	public Set<Payslip> getPayslips() {
		return payslips;
	}

	public void setPayslips(Set<Payslip> payslips) {
		this.payslips = payslips;
	}

	public Set<Timesheet> getTimesheets() {
		return timesheets;
	}

	public void setTimesheets(Set<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}

	public Set<Leave> getLeaves() {
		return leaves;
	}

	public void setLeaves(Set<Leave> leaves) {
		this.leaves = leaves;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return empId == other.empId;
	}


}
