package com.pwi.dto.response;

import com.pwi.dto.brand.ProductDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRes extends HeaderDTO{

	private ProductDTO product;
}
