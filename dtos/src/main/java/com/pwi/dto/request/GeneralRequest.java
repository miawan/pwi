package com.pwi.dto.request;

import lombok.Data;

@Data
public class GeneralRequest {
	
	private Long companyId;
	private Long brandId;
	private Long warehouseId;
	private String productType;
	private String productSize;

}
