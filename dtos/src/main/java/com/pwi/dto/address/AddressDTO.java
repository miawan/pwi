package com.pwi.dto.address;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.pwi.dto.brand.CompanyDTO;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class AddressDTO {

	private Long id;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zipCode;
	private int countryIdFk;
	private Boolean isPrimary;
	private Boolean active;
	private Integer createdBy;
	private Timestamp createdAt;
	private Integer modifiedBy;
	private Timestamp modifiedAt;
	private CountryDTO country;
	private CompanyDTO company;

}
