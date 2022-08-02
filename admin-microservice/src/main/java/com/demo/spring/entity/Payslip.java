package com.demo.spring.entity;

import java.util.Objects;

public class Payslip {
	

	private Long payslipId;
	private String monthOfSalary;
	private int totalPaidDays;
	private int totalSalary;
	private Employee employee;



	public Payslip() {

	}
	public Payslip(Long payslipId, String monthOfSalary, int totalPaidDays, int totalSalary) {
		this.payslipId = payslipId;
		this.monthOfSalary = monthOfSalary;
		this.totalPaidDays = totalPaidDays;
		this.totalSalary = totalSalary;
	}


	public Long getPayslipId() {
		return payslipId;
	}


	public void setPayslipId(Long payslipId) {
		this.payslipId = payslipId;
	}


	public String getMonthOfSalary() {
		return monthOfSalary;
	}


	public void setMonthOfSalary(String monthOfSalary) {
		this.monthOfSalary = monthOfSalary;
	}


	public int getTotalPaidDays() {
		return totalPaidDays;
	}


	public void setTotalPaidDays(int totalPaidDays) {
		this.totalPaidDays = totalPaidDays;
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
		return Objects.hash(payslipId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payslip other = (Payslip) obj;
		return Objects.equals(payslipId, other.payslipId);
	}

	
}
