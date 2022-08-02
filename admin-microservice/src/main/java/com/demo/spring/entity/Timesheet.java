package com.demo.spring.entity;
import java.util.Objects;
public class Timesheet {

	private Long timesheetId;
	private int regularHours;
	private int extraHours;
	private String fromDate;
	private String toDate;
	private Employee employee;



	public Timesheet() {

	}

	public Timesheet(Long timesheetId, int regularHours, int extraHours, String fromDate,
			String toDate) {
		this.timesheetId = timesheetId;
		this.regularHours = regularHours;
		this.extraHours = extraHours;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public Long getTimesheetId() {
		return timesheetId;
	}

	public void setTimesheetId(Long timesheetId) {
		this.timesheetId = timesheetId;
	}

	public int getRegularHours() {
		return regularHours;
	}

	public void setRegularHours(int regularHours) {
		this.regularHours = regularHours;
	}

	public int getExtraHours() {
		return extraHours;
	}

	public void setExtraHours(int extraHours) {
		this.extraHours = extraHours;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	

	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public int hashCode() {
		return Objects.hash(timesheetId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Timesheet other = (Timesheet) obj;
		return Objects.equals(timesheetId, other.timesheetId);
	}


}
