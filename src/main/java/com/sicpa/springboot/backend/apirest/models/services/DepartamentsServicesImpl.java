/**
 * 
 */
package com.sicpa.springboot.backend.apirest.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sicpa.springboot.backend.apirest.models.dao.IDepartamentsDao;
import com.sicpa.springboot.backend.apirest.models.dao.IEnterprisesDao;
import com.sicpa.springboot.backend.apirest.models.entity.Departaments;
import com.sicpa.springboot.backend.apirest.models.entity.Enterprises;


/**
 * @author Byron Pineda
 *
 */
@Service
public class DepartamentsServicesImpl implements IDepartamentsServices {
	
	@Autowired
	private IDepartamentsDao departamentsDao;
	
	@Autowired
	private IEnterprisesDao enterprisesDao; 

	@Override
	@Transactional(readOnly = true)
	public List<Departaments> findAll() {
		List<Departaments> departments =(List<Departaments>) departamentsDao.findAll(); 
		return departments; 
	}

	@Override
	@Transactional(readOnly = true)
	public Departaments findById(Long id) {
		return departamentsDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Departaments save(Departaments departamento) {
		// TODO Auto-generated method stub
		
		Optional<Enterprises> enterprises = enterprisesDao.findById(departamento.getEnterprises().getId());
		
		Departaments dp  = new Departaments();
		dp = departamento;
		dp.setEnterprises(enterprises.get());
		departamentsDao.save(dp);
		return dp;
//		return enterprisesDao.save(enterprises);
	}

	
	


}
