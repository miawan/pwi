package com.pwi.dto.request;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class QuantityUpdaterDTO {

	private Long id;
	private Long productId;
	private Long warehouseId;
	private Long companyId;
	private List<Long> warehouseids = new ArrayList<Long>();
	private Boolean allWarehouses;
	private String name;
	private String description;
	private String type;
	private String size;
	private Boolean isActive;
	private Date createdAt;
	private Long createdBy;
	private Date modifiedAt;
	private Long modifiedBy;
	
	private Integer inStock;
	private Integer availableQuantity;
	private Integer inTransit;
	private Integer moq;
	private Integer qpb;
	private Integer reOrderPoint;
}
