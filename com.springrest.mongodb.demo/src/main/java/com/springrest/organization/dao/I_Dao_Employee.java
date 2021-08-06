package com.springrest.organization.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springrest.organization.entity.Employee;

public interface I_Dao_Employee extends MongoRepository<Employee, Integer>{

}
