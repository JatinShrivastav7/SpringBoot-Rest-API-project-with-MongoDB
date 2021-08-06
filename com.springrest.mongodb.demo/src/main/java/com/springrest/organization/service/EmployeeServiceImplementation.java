package com.springrest.organization.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.organization.dao.I_Dao_Employee;
import com.springrest.organization.entity.Employee;
@Service
public class EmployeeServiceImplementation implements I_EmployeeService  {
	@Autowired	
	private I_Dao_Employee daoEmployeeDetails;
	
	
	public EmployeeServiceImplementation() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Employee> employeeDetails() {

		return this.daoEmployeeDetails.findAll();
	}

	@Override
	public Employee employeeDetailsById(int employee_id) {		
		
		Optional<Employee> result = daoEmployeeDetails.findById(employee_id);
		
		Employee attributes=null;
		
		if(result.isPresent()) {
			attributes=result.get();
		}
		else {
			return null;
		}
		return attributes;
		
	}

	@Override
	public Employee addDetails(Employee employeeAttribute) {

		return daoEmployeeDetails.save(employeeAttribute);
	}

	@Override
	public Employee updateDetails(Employee employee) {

		daoEmployeeDetails.save(employee);
		return employee;
	}

	@Override
	public void deleteDetails(int employee_id) {

		Optional<Employee> result = daoEmployeeDetails.findById(employee_id);
		Employee attributes=result.get();
		daoEmployeeDetails.delete(attributes);
	}

//	@Override
//	public List<Employee> allEmployeesList(int department_id) {
//		
//	Optional<Employee> result = daoEmployeeDetails.findById(department_id);
//			
//			List<Employee> attributes;
//			
//			if(attributes.size()<=0) {
//				attributes=result.get();
//			}
//			else {
//				return null;
//			}
//			return attributes;
//		
//	}

}
