package com.springrest.organization.service;

import java.util.List;

import com.springrest.organization.entity.Department;
import com.springrest.organization.entity.Employee;

public interface I_DepartmentService {

	public List<Department> departmentDetails();

	public Department departmentDetailsById(int department_id);

	public Department addDetails(Department departmentAttributeBody);

	public Department updateDetails(Department departmentAttributeBody);

	public void deleteDetails(int department_id);

	//public Employee allEmployeesList(int parseInt);


}
