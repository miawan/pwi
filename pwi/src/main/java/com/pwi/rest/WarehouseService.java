package com.pwi.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pwi.controller.warehouse.WarehouseController;
import com.pwi.dto.brand.ProductDTO;
import com.pwi.dto.company.WarehouseDTO;
import com.pwi.dto.request.QuantityUpdaterDTO;
import com.pwi.dto.response.HeaderDTO;
import com.pwi.dto.response.WarehouseRes;
import com.pwi.dto.response.WarehousesRes;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 *<strong>
 *This Warehouse Service class offers Warehouse and Warehouse related queries...
 *</strong>
 *<h2>
 *Base Adress
 *</h2>
 *<br>
 *<h2>
 *http://localhost:8081/pwi/
 * </h2>
 * @author mia
 */

@Path("/")
@Component
@Slf4j
public class WarehouseService {

	private WarehouseController warehouseController;
	
	
	@Autowired
	public WarehouseService(WarehouseController warehouseController){
		this.warehouseController = warehouseController;
	}
	
	/**
	 * To get all active Warehouses into the data base.
	 * @return This will return All active Warehouses list...
	 */
	@GET
	@Path("activeWarehouses")
	@Produces("application/json")
	public WarehousesRes allActiveWarehouses(){
		long start = System.currentTimeMillis();
		WarehousesRes res = new WarehousesRes();
		log.info("allActiveWarehouses called at "+start);
		try{
			this.warehouseController.getListOfActiveWarehouses(res);
		}catch(Exception e){
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("call end at "+ end);
		res.setResponseTime(end-start);
		return res;
	}
	
	
	/**
	 * To Get specific warehouse
	 * @param req Wahrehouse ID
	 * @return Will return a Warehouse in reponse object
	 */
	@GET
	@Path("warehouse")
	@Produces("application/json")
	public WarehouseRes getWarehouseByWarehouseId(QuantityUpdaterDTO req){
		long start = System.currentTimeMillis();
		WarehouseRes res = new WarehouseRes();
		log.info("getWarehouseByWarehouseId called at "+start);
		try{
			this.warehouseController.getWarehouseByWarehouseId(res, req.getWarehouseId());
		}catch(Exception e){
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("call end at "+ end);
		res.setResponseTime(end-start);
		return res;
	}
	
	/**
	 * This will save or update Warehouse
	 * @param req Warehouse object as input
	 * @return Response back save warehouse object
	 */
	@POST
	@Path("saveWarehouse")
	@Produces("application/json")
	public WarehouseRes getWarehouse(WarehouseDTO req){
		long start = System.currentTimeMillis();
		WarehouseRes res = new WarehouseRes();
		log.info("saveProduct called at "+start);
		try{
			this.warehouseController.saveWarehouse(res, req);
		}catch(Exception e){
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("call end at "+ end);
		res.setResponseTime(end-start);
		return res;
	}
	
	
	/**
	 * This will delete warehouse actually deactivate warehouse and all related products to specific warehouse
	 * @param req warehouseID
	 * @return Response back as success or failure in response obeject
	 */
	@DELETE
	@Path("deleteWarehouse")
	@Produces("application/json")
	public HeaderDTO deleteProduct(ProductDTO req){
		long start = System.currentTimeMillis();
		HeaderDTO res = new HeaderDTO();
		log.info("deleteProduct called at "+start);
		try{
			this.warehouseController.deleteWarehouse(res, req.getId());
		}catch(Exception e){
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("call end at "+ end);
		res.setResponseTime(end-start);
		return res;
	}
	
	
	
	@GET
	@Path("warehouseProducts")
	@Produces("application/json")
	public WarehousesRes warehouseProducts(){
		long start = System.currentTimeMillis();
		WarehousesRes res = new WarehousesRes();
		log.info("allActiveWarehouses called at "+start);
		try{
			this.warehouseController.getListOfActiveWarehouses(res);
		}catch(Exception e){
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("call end at "+ end);
		res.setResponseTime(end-start);
		return res;
	}
}
