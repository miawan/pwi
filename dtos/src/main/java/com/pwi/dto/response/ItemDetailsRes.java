package com.pwi.dto.response;

import java.util.List;

import com.pwi.dto.brand.ProductDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDetailsRes extends HeaderDTO {
	
	private ProductDTO product;
	private List<WarehouseDetails> warehouses;

}
