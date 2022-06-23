package com.sicpa.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sicpa.springboot.backend.apirest.models.entity.Employees;



public interface IEmployeesDao  extends CrudRepository<Employees,Long>{

}
