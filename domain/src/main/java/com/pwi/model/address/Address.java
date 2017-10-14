package com.pwi.model.address;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pwi.model.brand.Company;
import com.pwi.model.company.Warehouse;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Address implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3119580918369944466L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zipCode;
	private Boolean isPrimary;
	private Boolean active;
	private Integer createdBy;
	private Timestamp createdAt;
	private Integer modifiedBy;
	private Timestamp modifiedAt;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn
	private Country country;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = true)
	private Company company;
	
	@OneToMany(mappedBy = "address")
	private List<Warehouse> warehouses = new ArrayList<Warehouse>();

}
