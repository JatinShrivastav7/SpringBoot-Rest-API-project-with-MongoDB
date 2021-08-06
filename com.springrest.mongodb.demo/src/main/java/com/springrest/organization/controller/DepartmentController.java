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

import com.springrest.organization.entity.Department;
import com.springrest.organization.entity.Employee;
import com.springrest.organization.service.I_DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	private I_DepartmentService departmentService;
	
	//Get method to get all Department details
	
	@GetMapping("/department_details")
	public ResponseEntity<List<Department>> getDepartmentDetails()
	{
		
		List<Department> departmentList=this.departmentService.departmentDetails();
		if(departmentList.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(departmentList));
		
	}
	
	//Get method to get Department details by id
	
	@GetMapping("/department_details/{department_id}")
    public ResponseEntity<Department> getDepartmentDetailsById(@PathVariable String Department_id)
    {
    	Department deptAttributes=this.departmentService.departmentDetailsById(Integer.parseInt(Department_id));
    	if(deptAttributes==null)
    	{
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}
    	return ResponseEntity.of(Optional.of(deptAttributes));
    }

	//Post method to add new Department details
	
	@PostMapping("/add_department_details")
	public ResponseEntity<Department> addDepartmentDetails(@RequestBody Department DepartmentAttributeBody)
	{
	  Department deptAttributes=null;
		
		try {
			deptAttributes = this.departmentService.addDetails(DepartmentAttributeBody);
			System.out.println(deptAttributes);
			return ResponseEntity.of(Optional.of(deptAttributes));
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		
	}
	
	//Put method to update existing Department details
	
	@PutMapping("/update_department_details")
	public ResponseEntity<Department> updateDepartmentDetails(@RequestBody Department DepartmentAttributeBody)
	{
		Department deptAttributes=null;
		try{
			deptAttributes=departmentService.updateDetails(DepartmentAttributeBody);
			return ResponseEntity.ok().body(deptAttributes);
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//Delete method to delete Department details
	
	@DeleteMapping("/delete_department_details/{department_id}")
	public ResponseEntity<HttpStatus> deleteDepartmentDetails(@PathVariable String department_id)
	{
		try {
			this.departmentService.deleteDetails(Integer.parseInt(department_id));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
//	@GetMapping("/employees_in_department/{department_id")
//	public ResponseEntity<Employee> getEmployeesList(@PathVariable String Department_id)
//    {
//    	Employee empAttributes=this.departmentService.allEmployeesList(Integer.parseInt(Department_id));
//    	if(empAttributes==null)
//    	{
//    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//    	}
//    	return ResponseEntity.of(Optional.of(empAttributes));
//    }

	
}
