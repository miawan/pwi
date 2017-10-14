package com.pwi.dto.brand;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BrandDTO {
	private Long id;
	private CompanyDTO company;
	private String name;
	private String description;
	private Date createdAt;
	private Long createdBy;
	private Date modifiedAt;
	private Long modifiedBy;
	private List<ProductDTO> products = new ArrayList<ProductDTO>();

}
