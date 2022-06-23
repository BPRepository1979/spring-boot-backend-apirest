package com.sicpa.springboot.backend.apirest.models.services;
import java.util.List;


import com.sicpa.springboot.backend.apirest.models.entity.Enterprises;




public interface IEnterprisesServices {
	
    public List<Enterprises> findAll();
	public Enterprises findById(Long id);
	public Enterprises save(Enterprises enterprises);
	public void delete(Enterprises enterprises);
	
	
	

}
