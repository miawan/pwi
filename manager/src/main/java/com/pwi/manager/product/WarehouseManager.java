package com.pwi.manager.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.pwi.dao.product.WarehouseDAO;
import com.pwi.model.company.Warehouse;

@Transactional
@Component
public class WarehouseManager {

	private WarehouseDAO warehouseDAO;
	
	@Autowired
	public WarehouseManager(WarehouseDAO warehouseDAO){
		this.warehouseDAO = warehouseDAO;
	}
	
	
	
	public List<Warehouse> getListOfActiveWarehouses(){
		return this.warehouseDAO.getListOfActiveWarehouses();
	}
	
	public Warehouse getWarehouseByWarehouseId(long id){
		return this.warehouseDAO.getWarehouseByWarehouseId(id);
	}
	
	public Long saveWarehouse(Warehouse wh){
		return this.warehouseDAO.saveWarehouse(wh);
	}

	public Boolean deleteWarehouse(long id){
		return this.warehouseDAO.deleteWarehouse(id);
	}
}
