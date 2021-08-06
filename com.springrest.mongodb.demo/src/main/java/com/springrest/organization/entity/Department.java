package com.springrest.organization.entity;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.core.mapping.Document;


@EntityScan
@Document(collection="Department")
public class Department {
@org.springframework.data.annotation.Id
private int department_id;
private String department_name;
private String department_floor;

//no-args constructor
public Department() {
	super();
}

//parameterized constructor
public Department(int department_id, String department_name, String department_floor) {
	super();
	this.department_id = department_id;
	this.department_name = department_name;
	this.department_floor = department_floor;
}

//Getters and setters
public int getDepartment_id() {
	return department_id;
}
public void setDepartment_id(int department_id) {
	this.department_id = department_id;
}
public String getDepartment_name() {
	return department_name;
}
public void setDepartment_name(String department_name) {
	this.department_name = department_name;
}
public String getDepartment_floor() {
	return department_floor;
}
public void setDepartment_floor(String department_floor) {
	this.department_floor = department_floor;
}

@Override
public String toString() {
	return "Department [department_id=" + department_id + ", department_name=" + department_name + ", department_floor="
			+ department_floor + "]";
}

}


