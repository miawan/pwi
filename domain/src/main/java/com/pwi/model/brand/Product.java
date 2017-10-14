package com.pwi.model.brand;

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

import com.pwi.model.management.PlacedOrder;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Product implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -554946680099121450L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Brand brand;
//	@ManyToOne
//	@JoinColumn(nullable = true)
//	private Warehouse warehouse;
	private String name;
	private String description;
	private String type;
	private String size;
	private Boolean isActive;
	private Date createdAt;
	private Long createdBy;
	private Date modifiedAt;
	private Long modifiedBy;
	
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy = "product")
	private List<Item> items = new ArrayList<Item>();
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy = "product")
	private List<PlacedOrder> orders;
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy = "product")
	private List<ProductSize> productSizes = new ArrayList<ProductSize>();
	

}
