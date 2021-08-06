package com.springrest.organization.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.organization.entity.Employee;
import com.springrest.organization.service.I_EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private I_EmployeeService employeeService;
	
	//Get method to get all employee details
	
	@GetMapping("/employee_details")
	public ResponseEntity<List<Employee>> getEmployeeDetails()
	{
		
		List<Employee> employeesList=this.employeeService.employeeDetails();
		if(employeesList.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(employeesList));
		
	}
	
	//Get method to get Employee details by id
	
	@GetMapping("/employee_details/{employee_id}")
    public ResponseEntity<Employee> getEmployeeDetailsById(@PathVariable String employee_id)
    {
    	Employee empAttributes=this.employeeService.employeeDetailsById(Integer.parseInt(employee_id));
    	if(empAttributes==null)
    	{
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}
    	return ResponseEntity.of(Optional.of(empAttributes));
    }

	//Post method to add new employee details
	
	@PostMapping("/add_details")
	public ResponseEntity<Employee> addEmployeeDetails(@RequestBody Employee employeeAttributeBody)
	{
	  Employee empAttributes=null;
		
		try {
			empAttributes = this.employeeService.addDetails(employeeAttributeBody);
			System.out.println(empAttributes);
			return ResponseEntity.of(Optional.of(empAttributes));
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		
	}
	
	//Put method to update existing employee details
	
	@PutMapping("/update_details")
	public ResponseEntity<Employee> updateEmployeeDetails(@RequestBody Employee employeeAttributeBody)
	{
		Employee empAttributes=null;
		try{
			empAttributes=employeeService.updateDetails(employeeAttributeBody);
			return ResponseEntity.ok().body(empAttributes);
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//Delete method to delete employee details
	
	@DeleteMapping("/delete_details/{employee_id}")
	public ResponseEntity<HttpStatus> deleteEmployeeDetails(@PathVariable String employee_id)
	{
		try {
			this.employeeService.deleteDetails(Integer.parseInt(employee_id));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
//	@GetMapping("/employees_in_department/{department_id")
//	public ResponseEntity<list<Employee>> getEmployeesList(@PathVariable String Department_id)
//    {
//    	List<Employee> empAttributes=this.employeeService.allEmployeesList(Integer.parseInt(Department_id));
//    	if(empAttributes.size()<=0)
//    	{
//    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//    	}
//    	return ResponseEntity.of(Optional.of(empAttributes));
//    }
	
}
