/**
 * 
 */
package com.sicpa.springboot.backend.apirest.models.entity;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * @author Byron Pineda
 *
 */
@Getter
@Setter
@Entity
@Table(name="enterprises")
public class Enterprises implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String created_by;
	@Column(name = "create_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
    private String modified_by;
    @Column(name = "modified_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified_date;
    
    private String status;
    
    private String adress;
    
    private String name;
    
    private String phone;
    
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval= true,
            mappedBy = "enterprises"
    )
    @JsonIgnoreProperties(value = "enterprises", allowSetters = true)
    private List<Departaments> departaments;
    
    public Enterprises() {
    	this.createDate = new Date();
    	this.modified_date = new Date();
    	this.created_by="ADMIN";
    	this.modified_by="ADMIN";
    	this.departaments = new ArrayList<>();
    }
    
    public void setDepartaments(List<Departaments> addresses) {
        this.departaments.clear();
        addresses.forEach(this::addDepartaments);
    }
    
    public void addDepartaments(Departaments departament) {
        this.departaments.add(departament);
        departament.setEnterprises(this);
    }
    
    public void removeDepartaments(Departaments departament) {
        this.departaments.remove(departament);
        departament.setEnterprises(null);

    }
    
}
