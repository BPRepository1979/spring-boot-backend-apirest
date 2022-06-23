/**
 * 
 */
package com.sicpa.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sicpa.springboot.backend.apirest.models.entity.Departaments;
import com.sicpa.springboot.backend.apirest.models.entity.Enterprises;

/**
 * @author Byron Pineda
 *
 */


public interface IDepartamentsServices {
	 
	
	public List<Departaments> findAll();
	public Departaments findById(Long id);
	public Departaments save(Departaments departamento);
		

}
