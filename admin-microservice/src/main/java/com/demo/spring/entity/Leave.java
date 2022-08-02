package com.demo.spring.entity;

import java.util.Objects;

public class Leave {

	private Long leaveId;
	private String fromdateOfLeave;
	private String todateOfLeave;
	private String reasonOfLeave;
	private String status;
	private Employee employee;

	public Leave() {

	}
 

	public Leave(Long leaveId, String fromdateOfLeave, String todateOfLeave, String reasonOfLeave, String status) {
		this.leaveId = leaveId;
		this.fromdateOfLeave = fromdateOfLeave;
		this.todateOfLeave = todateOfLeave;
		this.reasonOfLeave = reasonOfLeave;
		this.status = status;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public Long getLeaveId() {
		return leaveId;
	}


	public void setLeaveId(Long leaveId) {
		this.leaveId = leaveId;
	}


	public String getFromdateOfLeave() {
		return fromdateOfLeave;
	}


	public void setFromdateOfLeave(String fromdateOfLeave) {
		this.fromdateOfLeave = fromdateOfLeave;
	}


	public String getTodateOfLeave() {
		return todateOfLeave;
	}


	public void setTodateOfLeave(String todateOfLeave) {
		this.todateOfLeave = todateOfLeave;
	}


	public String getReasonOfLeave() {
		return reasonOfLeave;
	}


	public void setReasonOfLeave(String reasonOfLeave) {
		this.reasonOfLeave = reasonOfLeave;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public int hashCode() {
		return Objects.hash(leaveId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Leave other = (Leave) obj;
		return Objects.equals(leaveId, other.leaveId);
	}


	@Override
	public String toString() {
		return "Leave [leaveId=" + leaveId + ", fromdateOfLeave=" + fromdateOfLeave + ", todateOfLeave=" + todateOfLeave
				+ ", reasonOfLeave=" + reasonOfLeave + ", status=" + status + ", employee=" + employee + "]";
	}

	
}
