package com.pwi.dto.response;

import java.util.List;

import com.pwi.dto.company.WarehouseDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WarehousesRes extends HeaderDTO {

	private List<WarehouseDTO> warehoses; 
}
