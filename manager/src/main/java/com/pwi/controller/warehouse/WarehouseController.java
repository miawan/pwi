package com.pwi.controller.warehouse;

import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pwi.dto.company.WarehouseDTO;
import com.pwi.dto.response.HeaderDTO;
import com.pwi.dto.response.WarehouseRes;
import com.pwi.dto.response.WarehousesRes;
import com.pwi.manager.product.WarehouseManager;
import com.pwi.mapper.institution.Constants;
import com.pwi.mapper.institution.LocationMapper;
import com.pwi.model.company.Warehouse;


@Singleton
@Component
public class WarehouseController {

	private WarehouseManager warehouseManager;
	
	public WarehouseController(){}
	
	
	@Autowired
	public WarehouseController(WarehouseManager warehouseManager){
		this.warehouseManager = warehouseManager;
	}
	
	
	public boolean getListOfActiveWarehouses(WarehousesRes res){
		
		res.setWarehoses(LocationMapper.warehouseToDTOs(this.warehouseManager.getListOfActiveWarehouses()));
		if(null != res.getWarehoses()){
			res.setErrorCode(Constants.SUCCESS_CODE);
			res.setErrorMessage(Constants.SUCCESS);
			res.setRecordCount(res.getWarehoses().size());
			return true;
		}else{
			res.setErrorCode(Constants.ERROR_CODE);
			res.setErrorMessage(Constants.FAILED);
			res.setRecordCount(res.getWarehoses().size());
			return false;
		}
	}
	
	public boolean getWarehouseByWarehouseId(WarehouseRes res, long id){
		HeaderDTO header = new HeaderDTO();
		if(id < 1){
			this.addToResponse(header, Constants.INVALID_ID, Constants.ERROR_CODE, Constants.ERROR_CODE);
			return false;
		}
		Warehouse wh = this.warehouseManager.getWarehouseByWarehouseId(id);
		if(null != wh){
			res.setWarehouse(LocationMapper.warehouseToDTO(wh));
			this.addToResponse(res, Constants.SUCCESS, Constants.SUCCESS_CODE, Constants.SUCCESS_CODE);
		}else{
			this.addToResponse(res, Constants.INVALID_ID, Constants.ERROR_CODE, Constants.ERROR_CODE);
		}
		return true;
	}
	
	
	public boolean saveWarehouse(WarehouseRes res, WarehouseDTO req){
		Long retVal = this.warehouseManager.saveWarehouse(LocationMapper.dtoToWarehouse(req));
		if(retVal == null){
			this.addToResponse(res, Constants.FAILED, Constants.ERROR_CODE, Constants.ERROR_CODE);
			return false;
		}else{
			req.setId(retVal);
			res.setWarehouse(req);
			this.addToResponse(res, Constants.SUCCESS, Constants.SUCCESS_CODE, Constants.SUCCESS_CODE);
		}
		return true;
	}
	
	public Boolean deleteWarehouse(HeaderDTO res, long id){
		Warehouse warehouse = this.warehouseManager.getWarehouseByWarehouseId(id);
		if(null != warehouse){
			if(LocationMapper.deactivateWarehouse(warehouse)){
				if(this.warehouseManager.saveWarehouse(warehouse) > 0){
					addToResponse(res, Constants.SUCCESS, Constants.SUCCESS_CODE, Constants.SUCCESS_CODE);
					return true;
				}
			}
		}
		return false;
	}
	
	
	public void addToResponse(HeaderDTO dto, String message, int errorCode, int count){
		dto.setErrorCode(errorCode);
		dto.setErrorMessage(message);
		dto.setRecordCount(count);
	}
	
}
