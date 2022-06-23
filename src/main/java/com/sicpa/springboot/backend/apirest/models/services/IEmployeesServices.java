/**
 * 
 */
package com.sicpa.springboot.backend.apirest.models.services;

import java.util.List;

import com.sicpa.springboot.backend.apirest.models.entity.Employees;
import com.sicpa.springboot.backend.apirest.models.entity.Enterprises;

/**
 * @author Byron Pineda
 *
 */
public interface IEmployeesServices {
	
	public List<Employees> findAll();
	public Employees findById(Long id);
	public Employees save(Employees employees);
	

}
