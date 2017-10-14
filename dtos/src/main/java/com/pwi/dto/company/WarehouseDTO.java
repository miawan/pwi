package com.pwi.dto.company;

import com.pwi.dto.address.AddressDTO;

import lombok.Data;

@Data
public class WarehouseDTO {

	private Long id;
	private String name;
	private String description;
	private Boolean isActive;
	private AddressDTO address;
}
