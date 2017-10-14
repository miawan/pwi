package com.pwi.dao.product;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.pwi.dto.request.GeneralRequest;
import com.pwi.dto.request.QuantityUpdaterDTO;
import com.pwi.generics.BaseDAO;
import com.pwi.model.brand.Item;
import com.pwi.model.brand.Product;
import com.pwi.model.brand.ProductSize;

import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author mia
 *
 */


@Repository
@Component
@Slf4j
public class ProductDAO extends BaseDAO{
	
	
	@SuppressWarnings("unchecked")
	public List<Product> getListOfActiveProducts(GeneralRequest gr){
		List<Product> retVal = null;
		try{
			log.debug("querying all active products from db... ");
			retVal = getProductQueryString(gr).list();
		}catch(Exception e){
			e.printStackTrace();
			log.error("fetching all active products failed ..."+e.getMessage());
		}
		return retVal;
	}
	
	public Product getProductByProductId(Long id, long whid){
		log.debug("getting product by product id:"+id);
		StringBuilder queryString = new StringBuilder();
		try{
			queryString.append("select pro from Item item join item.product pro where pro.isActive = 1 ");
			queryString.append(" and pro.id = :proId ");
			queryString.append(" and item.warehouse = :whid");
			Query query  = getSession().createQuery(queryString.toString());
			query.setLong("proId", id);
			query.setLong("whid", whid);
			return (Product) query.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return null;
	}
	
	
	public Long saveProduct(Product product){
		log.debug("saving product to database : "+product.toString());
		try{
			
			if(null != product.getId()){
				product.setModifiedAt(new Timestamp(System.currentTimeMillis()));
			}else{
				product.setCreatedAt(new Timestamp(System.currentTimeMillis()));
			}
			super.saveOrUpdate(product);
			getSession().flush();
			return product.getId();
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return null;
	}
	
//	public Boolean setQuantity(ProductDTO dto){
//		
//	}
	
	
	public Boolean deleteProduct(Long id, Long whid){
		log.debug("deleting product with id : "+id);
		try{
			String queryString = "update Item item set item.isActive = 0 where item.product.id = :pid and item.warehouse.id = :whid";
			Query query = getSession().createQuery(queryString);
			query.setLong("pid", id);
			query.setLong("whid", whid);
			query.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Item> selectedItems(QuantityUpdaterDTO req){
		log.debug("getting products to update product quantity :"+req.toString());
		StringBuilder queryString = new StringBuilder();
		try{
			queryString.append("from Item item where item.product.id = :proId");
			if(null != req.getAllWarehouses() && !req.getAllWarehouses())
				queryString.append(" and item.warehouse.id in :whids");
			Query query = getSession().createQuery(queryString.toString());
			query.setLong("proId", req.getProductId());
			if(null != req.getAllWarehouses() && !req.getAllWarehouses())
				query.setParameterList("whids", req.getWarehouseids());
			return query.list();
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return null;
		}
	}
	
	public Boolean updateItemQuantity(List<Item> items){
		log.debug("updating product quantities...");
		boolean flushed = false;
		try{
			if(null != items && items.size() > 0){
				for(int i=0; i<items.size(); i++){
					super.saveOrUpdate(items.get(i));
					if(flushed)
						flushed = false;
					if(i > 5){
						getSession().flush();
						flushed = true;
					}
				}
				if(!flushed)
					getSession().flush();
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return false;
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Item> itemDetails(Long id, List<Long> whid){
		log.debug("getting product by product id:"+id);
		StringBuilder queryString = new StringBuilder();
		try{
			queryString.append("select item from Item item  ");
			queryString.append(" where item.product.id = :proId ");
			queryString.append(" and item.warehouse.id in :whid");
			Query query  = getSession().createQuery(queryString.toString());
			query.setLong("proId", id);
			query.setParameterList("whid", whid);
			return (List<Item>)query.list();
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<ProductSize> availableSizes(QuantityUpdaterDTO req){
		log.debug("getting available sizes of any product");
		StringBuilder queryString = new StringBuilder();
		try{
//			queryString.append("from ProductSize ps where ps.product.id = :pid and ps.product.isActive = 1 ");
			queryString.append("select ps from Item item join item.product.productSizes ps where item.product.id = :pid and item.product.isActive = 1 ");
			if(null != req.getWarehouseId())
				queryString.append(" and item.warehouse.id = :whid");
			Query query = getSession().createQuery(queryString.toString());
			query.setLong("pid", req.getProductId());
			if(null != req.getWarehouseId())
				query.setLong("whid", req.getWarehouseId());
			return query.list();
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return null;
		}
	}
	
	public Query getProductQueryString(GeneralRequest req){
		StringBuilder retVal = new StringBuilder();
		Query query = null;
		if(null != req){
			retVal.append("select pro from Item item join item.product pro where pro.isActive = 1 ");
			if(null != req.getBrandId() && req.getBrandId() > 0)
				retVal.append(" and pro.brand = :brandId ");
			if(null != req.getWarehouseId() && req.getWarehouseId() > 0)
				retVal.append(" and item.warehouse = :whid");
			query = getSession().createQuery(retVal.toString());
			if(null != req.getBrandId() && req.getBrandId() > 0)
				query.setLong("brandId", req.getBrandId());
			if(null != req.getWarehouseId() && req.getWarehouseId() > 0)
			query.setLong("whid", req.getWarehouseId());
		}else{
			retVal.append("from Product pro where pro.isActive = 1 ");
			query = getSession().createQuery(retVal.toString());
		}
		return query;
	}
	
}
