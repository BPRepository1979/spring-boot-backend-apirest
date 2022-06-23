/**
 * 
 */
package com.sicpa.springboot.backend.apirest.models.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicpa.springboot.backend.apirest.models.entity.Departaments;

/**
 * @author Byron Pineda
 *
 */
@Repository
public interface IDepartamentsDao extends CrudRepository<Departaments,Long>	{
	

}	
