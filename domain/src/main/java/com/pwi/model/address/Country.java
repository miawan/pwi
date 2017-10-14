package com.pwi.model.address;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Country implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3119580918369944466L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String code;
	
	@OneToMany(mappedBy = "country")
	private List<Address> addresses = new ArrayList<Address>();

}
