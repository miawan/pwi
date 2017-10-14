package com.pwi.dto.brand;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ProductDTO {

	private Long id;
	private BrandDTO brand;
	private List<ProductSizeDTO> productSizes;
	private String name;
	private String description;
	private String type;
	private Boolean isActive;
	private Date createdAt;
	private Long createdBy;
	private Date modifiedAt;
	private Long modifiedBy;
	
}


