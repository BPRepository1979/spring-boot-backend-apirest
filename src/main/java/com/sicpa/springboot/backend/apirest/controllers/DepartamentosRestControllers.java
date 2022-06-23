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

import com.sicpa.springboot.backend.apirest.models.entity.Departamentos;
import com.sicpa.springboot.backend.apirest.models.entity.Employees;
import com.sicpa.springboot.backend.apirest.models.services.IDepartamentosServices;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class DepartamentosRestControllers {

	
	@Autowired(required = false)
	private IDepartamentosServices departamentosServices;
	
	@GetMapping("/Departamentos")
	public List<Departamentos> index() {
		return departamentosServices.findAll();
	}
	
	@PostMapping("/Departamentos")
	@ResponseStatus(HttpStatus.CREATED)
	public Departamentos create(@RequestBody Departamentos departamentos) {
		//enterprises.setCreate_date(new Date());
		this.departamentosServices.save(departamentos);
		return departamentos;
	}
	
	@GetMapping("/Departamentos/{id}")
	public Departamentos show(@PathVariable Long id) {
		return this.departamentosServices.findById(id);
	}
	
	@PutMapping("/Departamentos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Departamentos update(@RequestBody Departamentos departamentos, @PathVariable Long id) {
		Departamentos currentEnterprises = this.departamentosServices.findById(id);
		/*currentEnterprises.setName(employees.getName());
		currentEnterprises.setSurname(employees.getSurname());
		currentEnterprises.setEmail(employees.getEmail());
		currentEnterprises.setStatus(employees.getStatus());
		currentEnterprises.setModified_date(new Date());
		currentEnterprises.setAge(employees.getAge());*/
		this.departamentosServices.save(currentEnterprises);
		return currentEnterprises;
	}
}
