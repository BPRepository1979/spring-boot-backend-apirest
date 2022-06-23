/**
 * 
 */
package com.sicpa.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Byron Pineda
 *
 */
@Getter
@Setter
@Entity
@Table(name="employees")

public class Employees implements Serializable {
	
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
     private int age;
     private String email;
     private String name;
     private String position;
     private String surname;
     
     
     public Employees() {
     	this.createDate = new Date();
     	this.modified_date = new Date();
     	this.created_by="ADMIN";
     	this.modified_by="ADMIN";
     }
    
    
    

}
