package com.sicpa.springboot.backend.apirest.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sicpa.springboot.backend.apirest.models.entity.Employees;
import com.sicpa.springboot.backend.apirest.models.entity.Enterprises;
import com.sicpa.springboot.backend.apirest.models.services.IEmployeesServices;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class EmployeesRestControllers {
	
	@Autowired(required = false)
	private IEmployeesServices employeesServices;
	
	@GetMapping("/Employees")
	public List<Employees> index() {
		return employeesServices.findAll();
	}
	
	@PostMapping("/Employees")
	@ResponseStatus(HttpStatus.CREATED)
	public Employees create(@RequestBody Employees employees) {
		employees.setCreated_by("ADMIN");
		employees.setCreateDate(new Date());
		employees.setModified_by("ADMIN");
		employees.setModified_date(new Date());
		
		this.employeesServices.save(employees);
		return employees;
	}
	
	@GetMapping("/Employees/{id}")
	public Employees show(@PathVariable Long id) {
		return this.employeesServices.findById(id);
	}
	
	@PutMapping("/Employees/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Employees update(@RequestBody Employees employees, @PathVariable Long id) {
		Employees currentEnterprises = this.employeesServices.findById(id);
		currentEnterprises.setName(employees.getName());
		currentEnterprises.setSurname(employees.getSurname());
		currentEnterprises.setEmail(employees.getEmail());
		currentEnterprises.setStatus(employees.getStatus());
		currentEnterprises.setModified_date(new Date());
		currentEnterprises.setAge(employees.getAge());
		this.employeesServices.save(currentEnterprises);
		return currentEnterprises;
	}
	

}
