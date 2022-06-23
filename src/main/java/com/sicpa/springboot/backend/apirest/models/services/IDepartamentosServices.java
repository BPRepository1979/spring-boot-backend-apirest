package com.sicpa.springboot.backend.apirest.models.services;

import java.util.List;

import com.sicpa.springboot.backend.apirest.models.entity.Departamentos;



public interface IDepartamentosServices {
	
	public List<Departamentos> findAll();
	public Departamentos findById(Long id);
	public Departamentos save(Departamentos departamentos);

}
