package com.pwi.model.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pwi.model.address.Address;
import com.pwi.model.brand.Item;
import com.pwi.model.management.PlacedOrder;

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
public class Warehouse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -585571346791750584L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	private Boolean isActive;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	private Address address;
	
	private Date createdAt;
	private Long createdBy;
	private Date modifiedAt;
	private Long modifiedBy;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "warehouse", cascade = CascadeType.ALL)
	private List<Item> items = new ArrayList<Item>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "warehouse", cascade = CascadeType.ALL)
	private List<PlacedOrder> orders;
}
