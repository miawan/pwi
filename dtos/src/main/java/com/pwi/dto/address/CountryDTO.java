package com.pwi.dto.address;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class CountryDTO {

	private Long id;
	private String name;
	private String code;
	private List<AddressDTO> addresses = new ArrayList<AddressDTO>();

}
