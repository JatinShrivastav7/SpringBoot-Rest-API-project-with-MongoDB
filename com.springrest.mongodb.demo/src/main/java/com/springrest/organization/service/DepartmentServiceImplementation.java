package com.springrest.organization.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.springrest.organization.dao.I_Dao_Department;
import com.springrest.organization.entity.Department;
@Service
public class DepartmentServiceImplementation implements I_DepartmentService {
	
	@Autowired
	private I_Dao_Department daoDepartmentDetails;
//	private I_Dao_EmployeeDetails daoEmployeeDetails;

	public DepartmentServiceImplementation() {
		super();
	}


	@Override
	public List<Department> departmentDetails() {
		return this.daoDepartmentDetails.findAll();
	}


	@Override
	public Department departmentDetailsById(int department_id) {
Optional<Department> result = daoDepartmentDetails.findById(department_id);
		
		Department attributes=null;
		
		if(result.isPresent()) {
			attributes=result.get();
		}
		else {
			return null;
		}
		return attributes;
	}


	@Override
	public Department addDetails(Department departmentAttributeBody) {
		return daoDepartmentDetails.save(departmentAttributeBody);
	}


	@Override
	public Department updateDetails(Department departmentAttributeBody) {
		daoDepartmentDetails.save(departmentAttributeBody);
		return departmentAttributeBody;
	}


	@Override
	public void deleteDetails(int department_id) {
		Optional<Department> result = daoDepartmentDetails.findById(department_id);
		Department attributes=result.get();
		daoDepartmentDetails.delete(attributes);		
	}


//	@Override
//	public Employee allEmployeesList(int department_id) {
//Optional<Employee> result = daoDepartmentDetails.findById(department_id);
//		
//		Employee attributes=null;
//		
//		if(result.isPresent()) {
//			attributes=result.get();
//		}
//		else {
//			return null;
//		}
//		return attributes;
//	}


	
	
}
