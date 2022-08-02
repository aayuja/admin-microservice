package com.demo.spring.entity;

import java.util.Objects;

public class Salary {
	
	private Long salaryId;
	private int basic;
	private int hra;
	private int totalSalary;
	private Employee employee;

	
	public Salary() {
		
	}


	public Salary(Long salaryId, int basic, int hra, int totalSalary) {
		this.salaryId = salaryId;
		this.basic = basic;
		this.hra = hra;
		this.totalSalary = totalSalary;
	}


	public Long getSalaryId() {
		return salaryId;
	}

	public void setSalaryId(Long salaryId) {
		this.salaryId = salaryId;
	}

	public int getBasic() {
		return basic;
	}

	public void setBasic(int basic) {
		this.basic = basic;
	}

	public int getHra() {
		return hra;
	}

	public void setHra(int hra) {
		this.hra = hra;
	}

	public int getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(int totalSalary) {
		this.totalSalary = totalSalary;
	}

	

	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public int hashCode() {
		return Objects.hash(salaryId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salary other = (Salary) obj;
		return Objects.equals(salaryId, other.salaryId);
	}


	@Override
	public String toString() {
		return "Salary [salaryId=" + salaryId + ", basic=" + basic + ", hra=" + hra + ", totalSalary=" + totalSalary
				+ "]";
	}
	
	
}
