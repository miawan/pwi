package com.pwi.model.brand;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Brand implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9116353628576678723L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Company company;
	private String name;
	private String description;
	private Date createdAt;
	private Long createdBy;
	private Date modifiedAt;
	private Long modifiedBy;
	@OneToMany(mappedBy = "brand")
	private List<Product> products = new ArrayList<Product>();

}
