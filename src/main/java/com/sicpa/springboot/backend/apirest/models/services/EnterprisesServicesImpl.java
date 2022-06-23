/**
 * 
 */
package com.sicpa.springboot.backend.apirest.models.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.sicpa.springboot.backend.apirest.models.dao.IEnterprisesDao;

import com.sicpa.springboot.backend.apirest.models.entity.Enterprises;

/**
 * @author Byron Pineda
 *
 */
@Service
public class EnterprisesServicesImpl implements IEnterprisesServices {
	
	@Autowired
	private IEnterprisesDao enterprisesDao;


	@Override
	@Transactional(readOnly = true)
	public List<Enterprises> findAll() {
		return (List<Enterprises>) enterprisesDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Enterprises findById(Long id) {
		return enterprisesDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Enterprises save(Enterprises enterprises) {
		// TODO Auto-generated method stub
		Enterprises em  = enterprisesDao.save(enterprises);
		return em;
//		return enterprisesDao.save(enterprises);
	}

	@Override
	@Transactional
	public void delete(Enterprises enterprises) {
		enterprisesDao.delete(enterprises);
		
	}
	

	
	

}
