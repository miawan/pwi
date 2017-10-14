package com.pwi.controller.product;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pwi.dto.brand.ProductDTO;
import com.pwi.dto.brand.ProductSizeDTO;
import com.pwi.dto.request.GeneralRequest;
import com.pwi.dto.request.QuantityUpdaterDTO;
import com.pwi.dto.response.HeaderDTO;
import com.pwi.dto.response.ItemDetailsRes;
import com.pwi.dto.response.ProductListRes;
import com.pwi.dto.response.ProductRes;
import com.pwi.dto.response.ProductSizesRes;
import com.pwi.manager.product.ProductManager;
import com.pwi.mapper.institution.Constants;
import com.pwi.mapper.institution.ProductMapper;
import com.pwi.model.brand.Item;
import com.pwi.model.brand.Product;
import com.pwi.model.brand.ProductSize;

@Singleton
@Component
public class ProductController {

	private ProductManager productManager;

	public ProductController() {
	}

	@Autowired
	public ProductController(ProductManager productManager) {
		this.productManager = productManager;
	}

	public boolean getListOfActiveInstitutions(ProductListRes res, GeneralRequest gr) {

		res.setProducts(ProductMapper.productsToDTO(this.productManager.getListOfActiveProducts(gr)));
		if (null != res.getProducts()) {
			res.setErrorCode(Constants.SUCCESS_CODE);
			res.setErrorMessage(Constants.SUCCESS);
			res.setRecordCount(res.getProducts().size());
			return true;
		} else {
			res.setErrorCode(Constants.ERROR_CODE);
			res.setErrorMessage(Constants.FAILED);
			res.setRecordCount(Constants.ERROR_CODE);
			return false;
		}
	}

	public boolean getProductByProductId(ProductRes res, Long id, Long warehouseId) {
		HeaderDTO header = new HeaderDTO();
		if (null == id || null == warehouseId) {
			this.addToResponse(header, Constants.INVALID_ID, Constants.ERROR_CODE, Constants.ERROR_CODE);
			return false;
		}
		Product pro = this.productManager.getProductByProductId(id, warehouseId);
		if (null != pro) {
			res.setProduct(ProductMapper.productToDTO(pro));
			this.addToResponse(res, Constants.SUCCESS, Constants.SUCCESS_CODE, Constants.SUCCESS_CODE);
		} else {
			this.addToResponse(res, Constants.INVALID_ID, Constants.ERROR_CODE, Constants.ERROR_CODE);
		}
		return true;
	}

	public boolean saveProduct(ProductRes res, ProductDTO req) {
		req.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		Long retVal = this.productManager.saveProduct(ProductMapper.dtoToProduct(req));
		if (retVal == null) {
			this.addToResponse(res, Constants.FAILED, Constants.ERROR_CODE, Constants.ERROR_CODE);
			return false;
		} else {
			req.setId(retVal);
			res.setProduct(req);
		}
		this.addToResponse(res, Constants.SUCCESS, Constants.SUCCESS_CODE, Constants.SUCCESS_CODE);
		return true;
	}

	public Boolean deleteProduct(HeaderDTO res, Long id, Long whid) {
		if(null != res && null != whid){
			if (this.productManager.deleteProduct(id, whid)) {
				addToResponse(res, Constants.SUCCESS, Constants.SUCCESS_CODE, Constants.SUCCESS_CODE);
				return true;
			}
		}
		this.addToResponse(res, Constants.INVALID_PARAMS, Constants.ERROR_CODE, Constants.ERROR_CODE);
		return false;
	}

	public boolean setProductQuantity(ProductRes res, QuantityUpdaterDTO req) {
		List<Item> items = this.productManager.selectedItems(req);
		if ((null != items && items.size() > 0)) {

			for (Item item : items) {
				ProductMapper.setProductQuantity(item, req);
			}
			if (this.productManager.updateItemQuantity(items)){
				addToResponse(res, Constants.SUCCESS, Constants.SUCCESS_CODE, Constants.SUCCESS_CODE);
				return true;
			}
		}
		addToResponse(res, Constants.FAILED, Constants.ERROR_CODE, Constants.ERROR_CODE);
		return false;
	}
	
	
	
	public Boolean itemDetails(ItemDetailsRes res, QuantityUpdaterDTO req){
		if(null == req.getWarehouseids() && req.getWarehouseId() != null){
			req.setWarehouseids(new ArrayList<Long>());
			req.getWarehouseids().add(req.getWarehouseId());
		}else{
			this.addToResponse(res, Constants.INVALID_PARAMS, Constants.ERROR_CODE, Constants.ERROR_CODE);
		}
			
		List<Item> items = this.productManager.itemDetails(req.getProductId(), req.getWarehouseids());
		
		if(null != items && items.size() > 0){
			res.setProduct(ProductMapper.productToDTO(items.get(0).getProduct()));
			res.setWarehouses(ProductMapper.itemToWarehouseDetails(items));
			addToResponse(res, Constants.SUCCESS, Constants.SUCCESS_CODE, res.getWarehouses().size());
		}
		
		
		return true;
	}
	
	
	public Boolean availableSizes(ProductSizesRes res, QuantityUpdaterDTO req){
		List<ProductSize> retVal = this.productManager.availableSizes(req);
		if(null != retVal && retVal.size() > 0){
			res.setProduct(ProductMapper.productToDTO(retVal.get(0).getProduct()));
			List<ProductSizeDTO> psdto = new ArrayList<ProductSizeDTO>();
			for(ProductSize ps : retVal){
				ProductSizeDTO dto = new ProductSizeDTO();
				dto.setId(ps.getId());
				dto.setSize(ps.getSize());
				psdto.add(dto);
			}
			res.setAvailableSize(psdto);
			addToResponse(res, Constants.SUCCESS, Constants.SUCCESS_CODE, retVal.size());
			return true;
		}
		addToResponse(res, Constants.FAILED, Constants.ERROR_CODE, Constants.ERROR_CODE);
		return false;
	}
	
	

	public void addToResponse(HeaderDTO dto, String message, int errorCode, int count) {
		dto.setErrorCode(errorCode);
		dto.setErrorMessage(message);
		dto.setRecordCount(count);
	}
	
	public void addToResponse(Object rdto, String message, int errorCode, int count) {
		HeaderDTO dto = (HeaderDTO)rdto;
		dto.setErrorCode(errorCode);
		dto.setErrorMessage(message);
		dto.setRecordCount(count);
	}

}
