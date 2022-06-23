package com.sicpa.springboot.backend.apirest.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.sicpa.springboot.backend.apirest.models.entity.Enterprises;
import com.sicpa.springboot.backend.apirest.models.services.IEnterprisesServices;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class EnterprisesRestControllers {

	@Autowired
	private IEnterprisesServices enterprisesServices;

	@GetMapping("/enterprises")
	public List<Enterprises> index() {
		return enterprisesServices.findAll();
	}

	@GetMapping("/enterprises/{id}")
	public Enterprises show(@PathVariable Long id) {
		return this.enterprisesServices.findById(id);
	}

	@PostMapping("/enterprises")
	@ResponseStatus(HttpStatus.CREATED)
	public Enterprises create(@RequestBody Enterprises enterprises) {
		enterprises.setModified_date(new Date());
		enterprises.setCreateDate(new Date());
		enterprises.setModified_by("ADMIN");
		enterprises.setCreated_by("ADMIN");
		
		this.enterprisesServices.save(enterprises);
		return enterprises;
	}

	@PutMapping("/enterprises/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Enterprises update(@RequestBody Enterprises enterprisesaux, @PathVariable Long id) {
		Enterprises currentEnterprises = this.enterprisesServices.findById(id);
		currentEnterprises.setName(enterprisesaux.getName());
		currentEnterprises.setPhone(enterprisesaux.getPhone());
		currentEnterprises.setAdress(enterprisesaux.getAdress());
		currentEnterprises.setStatus(enterprisesaux.getStatus());
		currentEnterprises.setModified_date(new Date());
		this.enterprisesServices.save(currentEnterprises);
		return currentEnterprises;
	}

	@DeleteMapping("/enterprises/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Enterprises currentEnterprises = this.enterprisesServices.findById(id);
		this.enterprisesServices.delete(currentEnterprises);
	}

}
