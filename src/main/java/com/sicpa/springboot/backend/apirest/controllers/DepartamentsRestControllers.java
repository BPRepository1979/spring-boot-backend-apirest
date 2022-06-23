/**
 * 
 */
package com.sicpa.springboot.backend.apirest.controllers;

import java.util.Date;
import java.util.List;

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

import com.sicpa.springboot.backend.apirest.models.entity.Departaments;
import com.sicpa.springboot.backend.apirest.models.entity.Enterprises;
import com.sicpa.springboot.backend.apirest.models.services.IDepartamentsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



/**
 * @author Byron Pineda
 *
 */
@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class DepartamentsRestControllers {

	@Autowired(required = false)
	private IDepartamentsServices departamentsServices;
	
	@GetMapping("/Departaments")
	public ResponseEntity<?> index() {
//		return departamentsServices.findAll();
		
		return ResponseEntity.ok().body(departamentsServices.findAll());
	}
	
	@PostMapping("/Departaments")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Departaments departaments) {
		//enterprises.setCreate_date(new Date());
		departaments.setCreateDate(new Date());
		departaments.setModified_date(new Date());
		departaments.setCreated_by("ADMIN");
		departaments.setModified_by("ADMIN");
		departaments.setStatus("ACTIVO");
		
		return ResponseEntity.ok().body(departamentsServices.save(departaments));
		//this.departamentsServices.save(departaments);
		//return departaments;
	}
	
	
	/*@PostMapping("/Departaments")
	@ResponseStatus(HttpStatus.CREATED)
	public Departaments create(@RequestBody Departaments departaments) {
		//enterprises.setCreate_date(new Date());
		this.departamentsServices.save(departaments);
		return departaments;
	}*/
	
	@GetMapping("/Departaments/{id}")
	public Departaments show(@PathVariable Long id) {
		return this.departamentsServices.findById(id);
	}
	
}
