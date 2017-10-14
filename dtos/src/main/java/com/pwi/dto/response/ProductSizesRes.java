package com.pwi.dto.response;

import java.util.List;

import com.pwi.dto.brand.ProductDTO;
import com.pwi.dto.brand.ProductSizeDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSizesRes extends HeaderDTO {
	
	private ProductDTO product;
	private List<ProductSizeDTO> availableSize;

}
