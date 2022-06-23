package com.sicpa.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sicpa.springboot.backend.apirest.models.entity.Departamentos;


@Repository
public interface IDepartamentoDao extends CrudRepository<Departamentos,Long> {

}
