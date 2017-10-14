package com.pwi.model.brand;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pwi.model.company.Warehouse;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@ToString
public class Item implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -554946680099121450L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Product product;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Warehouse warehouse;
	
	private Integer inStock;
	private Integer availableQuantity;
	private Integer inTransit;
	private Integer moq;
	private Integer qpb;
	private Integer reOrderPoint;
	@Column(columnDefinition = "boolean default true")
	private Boolean isActive;
	
	private Date createdAt;
	private Long createdBy;
	private Date modifiedAt;
	private Long modifiedBy;

}
