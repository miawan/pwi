package com.pwi.dto.response;

import com.pwi.dto.address.AddressDTO;

import lombok.Data;

@Data
public class WarehouseDetails {

	private Integer inStock;
	private Integer availableQuantity;
	private Integer inTransit;
	private Integer moq;
	private Integer qpb;
	private Integer reOrderPoint;
	private Long id;
	private String name;
	private String description;
	private Boolean isActive;
	private AddressDTO address;
}
