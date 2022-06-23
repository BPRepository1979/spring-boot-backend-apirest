/**
 * 
 */
package com.sicpa.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicpa.springboot.backend.apirest.models.entity.Enterprises;

/**
 * @author Byron Pineda
 *
 */
@Repository
public interface IEnterprisesDao extends CrudRepository<Enterprises, Long> {

}
