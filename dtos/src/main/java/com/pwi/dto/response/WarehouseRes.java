package com.pwi.dto.response;

import com.pwi.dto.company.WarehouseDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WarehouseRes extends HeaderDTO {

	private WarehouseDTO warehouse; 
}
