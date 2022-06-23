package com.sicpa.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sicpa.springboot.backend.apirest.models.dao.IEmployeesDao;

import com.sicpa.springboot.backend.apirest.models.entity.Employees;


@Service
public class EmployeesServicesImpl implements IEmployeesServices {
	
	
	@Autowired
	private IEmployeesDao employeesDao;


	@Override
	@Transactional(readOnly = true)
	public List<Employees> findAll() {
		return (List<Employees>) employeesDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Employees findById(Long id) {
		return employeesDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Employees save(Employees employees) {
		// TODO Auto-generated method stub
		Employees em  = employeesDao.save(employees);
		return em;
//		return enterprisesDao.save(enterprises);
	}


	

	

}
