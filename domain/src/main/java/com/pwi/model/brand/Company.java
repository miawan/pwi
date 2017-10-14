package com.pwi.model.brand;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pwi.model.address.Address;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table
@Getter
@Setter
public class Company implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9116353628576678723L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	private List<Address> addresses = new ArrayList<Address>();
	private String name;
	private String description;
	private Date createdAt;
	private Long createdBy;
	private Date modifiedAt;
	private Long modifiedBy;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	private List<Brand> brands = new ArrayList<Brand>();

}
