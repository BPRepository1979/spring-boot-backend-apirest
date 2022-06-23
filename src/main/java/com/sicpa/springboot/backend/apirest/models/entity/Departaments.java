/**
 * 
 */
package com.sicpa.springboot.backend.apirest.models.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Byron Pineda
 *
 */
@Getter
@Setter
@Entity
@Table(name="departament")
public class Departaments implements Serializable {
	
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
    
    private String descripcion;
    
    private String name;
    
    private String phone;
    
    @JsonIgnoreProperties(value = "departaments")
	@ManyToOne //(fetch = FetchType.LAZY)
    @JoinColumn(name = "enterprise_id")
    private Enterprises enterprises;
    
    public Departaments() {
    	this.createDate = new Date();
    	this.modified_date = new Date();
    	this.created_by="ADMIN";
    	this.modified_by="ADMIN";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if(!(obj instanceof Departaments)) {
            return false;
        }

        Departaments a = (Departaments) obj;
        return this.id != null && this.id.equals(a.getId());
    }
    

}
