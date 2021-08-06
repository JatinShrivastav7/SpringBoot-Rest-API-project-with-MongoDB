package com.springrest.organization.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.core.mapping.Document;

@EntityScan
@Document(collection="Employee")
public class Employee {
	
	@org.springframework.data.annotation.Id
	private int employee_id;
	private String employee_name;
	private String employee_email;
	private Department department;
	
	
	
	public Employee(int employee_id, String employee_name, String employee_email,
			Department department) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.employee_email = employee_email;
		this.department = department;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_email() {
		return employee_email;
	}

	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}

	public Department getEmployee_department() {
		return department;
	}

	public void setEmployee_department(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee_Attributes [employee_id=" + employee_id + ", employee_name=" + employee_name
				+ ", employee_email=" + employee_email + ", department=" + department + "]";
	}

	
	
	
	

}
