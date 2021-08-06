package com.springrest.organization.service;

import java.util.List;

import com.springrest.organization.entity.Employee;

public interface I_EmployeeService {

	public List<Employee> employeeDetails();
	public Employee employeeDetailsById(int employee_id);
	public Employee addDetails(Employee employeeAttribute);
	public Employee updateDetails(Employee employee);
	public void deleteDetails(int employee_id);
//	public List <Employee> allEmployeesList(int parseInt);
}

