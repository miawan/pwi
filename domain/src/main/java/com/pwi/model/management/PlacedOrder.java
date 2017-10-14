package com.pwi.model.management;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pwi.model.brand.Product;
import com.pwi.model.company.Warehouse;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author mia
 *
 */

@Entity
@Table
@Getter
@Setter
public class PlacedOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -802140835687364017L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Product product;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Warehouse warehouse;
	private String description;
	private Boolean delevered;
	private Date createdAt;
	private Long createdBy;
	private Date modifiedAt;
	private Long modifiedBy;
	
	
	
}
