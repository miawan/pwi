package com.pwi.manager.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.pwi.dao.product.ProductDAO;
import com.pwi.dto.request.GeneralRequest;
import com.pwi.dto.request.QuantityUpdaterDTO;
import com.pwi.model.brand.Item;
import com.pwi.model.brand.Product;
import com.pwi.model.brand.ProductSize;

@Transactional
@Component
public class ProductManager {

	private ProductDAO productDAO;
	
	@Autowired
	public ProductManager(ProductDAO productDAO){
		this.productDAO = productDAO;
	}
	
	
	
	public List<Product> getListOfActiveProducts(GeneralRequest gr){
		return this.productDAO.getListOfActiveProducts(gr);
	}
	
	public Product getProductByProductId(long id, long whid){
		return this.productDAO.getProductByProductId(id, whid);
	}
	
	public Long saveProduct(Product product){
		return this.productDAO.saveProduct(product);
	}
	public Boolean deleteProduct(Long id, Long whid){
		return this.productDAO.deleteProduct(id, whid);
	}
	
	public List<Item> selectedItems(QuantityUpdaterDTO req){
		return this.productDAO.selectedItems(req);
	}
	public Boolean updateItemQuantity(List<Item> items){
		return this.productDAO.updateItemQuantity(items);
	}
	
	
	public List<Item> itemDetails(Long id, List<Long> whid){
		return this.productDAO.itemDetails(id, whid);
	}
	
	public List<ProductSize> availableSizes(QuantityUpdaterDTO req){
		return this.productDAO.availableSizes(req);
	}
}
