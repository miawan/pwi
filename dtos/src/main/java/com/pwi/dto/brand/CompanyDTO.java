package com.pwi.dto.brand;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.pwi.dto.address.AddressDTO;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table
@Getter
@Setter
public class CompanyDTO  {
	private Long id;
	private List<AddressDTO> addresses = new ArrayList<AddressDTO>();
	private String name;
	private String description;
	private Date createdAt;
	private Long createdBy;
	private Date modifiedAt;
	private Long modifiedBy;
	private List<BrandDTO> brands = new ArrayList<BrandDTO>();

}
