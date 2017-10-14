package com.pwi.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pwi.controller.product.ProductController;
import com.pwi.dto.brand.ProductDTO;
import com.pwi.dto.request.GeneralRequest;
import com.pwi.dto.request.QuantityUpdaterDTO;
import com.pwi.dto.response.ItemDetailsRes;
import com.pwi.dto.response.ProductListRes;
import com.pwi.dto.response.ProductRes;
import com.pwi.dto.response.ProductSizesRes;

import lombok.extern.slf4j.Slf4j;

/**
 * *<strong>
 *This Product class offers Product and product related queries...
 *</strong>
 *<br>
 *<h2>
 *Base Adress
 *</h2>
 *<h2>
 *http://localhost:8081/pwi/
 * </h2>
 * @author mia
 *
 */

@Path("/")
@Component
@Slf4j
public class ProductService {

	private ProductController productController;
	
	
	@Autowired
	public ProductService(ProductController productController){
		this.productController = productController;
	}
	
	/**
	 * To get all active products into the data base.
	 * @param req Optional parans like.... BrandId, WarehouseId 
	 * @return This will return All active Products list...
	 */
	@GET
	@Path("activeProducts")
	@Produces("application/json")
	public ProductListRes allActiveProducts(GeneralRequest req){
		long start = System.currentTimeMillis();
		ProductListRes res = new ProductListRes();
		log.info("activeProducts called at "+start);
		try{
			this.productController.getListOfActiveInstitutions(res, req);
		}catch(Exception e){
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("call end at "+ end);
		res.setResponseTime(end-start);
		return res;
	}
	
	/**
	 * To Get specific product against Product id
	 * @param req productId
	 * @return This will return a specific product
	 */
	@GET
	@Path("product")
	@Produces("application/json")
	public ProductRes getProductByProductId(QuantityUpdaterDTO req){
		long start = System.currentTimeMillis();
		ProductRes res = new ProductRes();
		log.info("getProductByProductId called at "+start);
		try{
			this.productController.getProductByProductId(res, req.getProductId(), req.getWarehouseId());
		}catch(Exception e){
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("call end at "+ end);
		res.setResponseTime(end-start);
		return res;
	}
	
	
	/**
	 * This method save provided product into database and also update already saved one.
	 * @param req	This method takes object of Product as parameters.
	 * @return This will return saved object
	 */
	@POST
	@Path("saveProduct")
	@Produces("application/json")
	public ProductRes saveProduct(ProductDTO req){
		long start = System.currentTimeMillis();
		ProductRes res = new ProductRes();
		log.info("saveProduct called at "+start);
		try{
			this.productController.saveProduct(res, req);
		}catch(Exception e){
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("call end at "+ end);
		res.setResponseTime(end-start);
		return res;
	}
	
	/**
	 * To remove a product from database, This actually deactivate a product
	 * @param req Product id required as param
	 * @return return success of failure message in response headder.
	 */
	@DELETE
	@Path("deleteProduct")
	@Produces("application/json")
	public ProductRes deleteProduct(QuantityUpdaterDTO req){
		long start = System.currentTimeMillis();
		ProductRes res = new ProductRes();
		log.info("deleteProduct called at "+start);
		try{
			this.productController.deleteProduct(res, req.getProductId(), req.getWarehouseId());
		}catch(Exception e){
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("call end at "+ end);
		res.setResponseTime(end-start);
		return res;
	}
	
	
	/**
	 * This save the quantity of any product in 
	 * @param req Takes inStock, availableQuantity, inTransit, moq, qpb, reOrderPoint as param
	 * @return will return success or failure in response header
	 */
	@POST
	@Path("setQuantity")
	@Produces("application/json")
	public ProductRes setQuantity(QuantityUpdaterDTO req){
		long start = System.currentTimeMillis();
		ProductRes res = new ProductRes();
		log.info("saveProduct called at "+start);
		try{
			this.productController.setProductQuantity(res, req);
		}catch(Exception e){
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("call end at "+ end);
		res.setResponseTime(end-start);
		return res;
	}
	
	
	/**
	 * View Item Quantity in Single/All Warehouse(s) of Company or any Office(s)
	 * @param req PrudctID, warehouseID(s)
	 * @return This returns Item Quantity like inStock, availableQuantity, inTransit, moq, qpb, reOrderPoint...
	 */
	@GET
	@Path("itemDetails")
	@Produces("application/json")
	public ItemDetailsRes itemDetails(QuantityUpdaterDTO req){
		long start = System.currentTimeMillis();
		ItemDetailsRes res = new ItemDetailsRes();
		log.info("getProductByProductId called at "+start);
		try{
			this.productController.itemDetails(res, req);
		}catch(Exception e){
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("call end at "+ end);
		res.setResponseTime(end-start);
		return res;
	}
	
	
	/**
	 * All available sizes of any Item
	 * @param req PrudctID, warehouseID(s)(optional)
	 * @return This methods response back available sizes of a product in single or multiple warehouses 
	 */
	@GET
	@Path("availableSize")
	@Produces("application/json")
	public ProductSizesRes availableSize(QuantityUpdaterDTO req){
		long start = System.currentTimeMillis();
		ProductSizesRes res = new ProductSizesRes();
		log.info("getProductByProductId called at "+start);
		try{
			this.productController.availableSizes(res, req);
		}catch(Exception e){
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("call end at "+ end);
		res.setResponseTime(end-start);
		return res;
	}
	
	
	
}
