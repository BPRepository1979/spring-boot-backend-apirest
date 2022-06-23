package com.sicpa.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sicpa.springboot.backend.apirest.models.dao.IDepartamentoDao;
import com.sicpa.springboot.backend.apirest.models.entity.Departamentos;



@Service
public class DepartamentosServicesImpl implements IDepartamentosServices {

	@Autowired
	private IDepartamentoDao departamentosDao;


	@Override
	@Transactional(readOnly = true)
	public List<Departamentos> findAll() {
		return (List<Departamentos>) departamentosDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Departamentos findById(Long id) {
		return departamentosDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Departamentos save(Departamentos departamentos) {
		// TODO Auto-generated method stub
		Departamentos em  = departamentosDao.save(departamentos);
		return em;
//		return enterprisesDao.save(enterprises);
	}


	

	
}
