package com.springrest.organization.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springrest.organization.entity.Department;

public interface I_Dao_Department extends MongoRepository<Department , Integer> {

}
