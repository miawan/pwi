package com.pwi.dao.product;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.pwi.generics.BaseDAO;
import com.pwi.model.company.Warehouse;

import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author mia
 *
 */


@Repository
@Component
@Slf4j
public class WarehouseDAO extends BaseDAO{
	
	
	@SuppressWarnings("unchecked")
	public List<Warehouse> getListOfActiveWarehouses(){
		List<Warehouse> retVal = null;
		try{
			log.debug("querying all active Warehouse from db... ");
			String queryString = "from Warehouse wh where wh.isActive = 1";
			Query query = getSession().createQuery(queryString);
			retVal = query.list();
		}catch(Exception e){
			e.printStackTrace();
			log.error("fetching all active warehouses failed ..."+e.getMessage());
		}
		return retVal;
	}
	
	public Warehouse getWarehouseByWarehouseId(long id){
		log.debug("getting warehouse by product id:"+id);
		try{
			return getSession().get(Warehouse.class, id);
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return null;
	}
	
	
	
	public Long saveWarehouse(Warehouse wh){
		log.debug("saving warehouse to database : "+wh.toString());
		try{
			if(null != wh.getId())
				wh.setModifiedAt(new Timestamp(System.currentTimeMillis()));
			else
				wh.setCreatedAt(new Timestamp(System.currentTimeMillis()));
			super.saveOrUpdate(wh);
			getSession().flush();
			return wh.getId();
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return null;
	}
	
	
	public Boolean deleteWarehouse(long id){
		log.debug("deleting warehouse with id : "+id);
		try{
			String queryString = "delete from Warehouse wh where wh.id = :id";
			Query query = getSession().createQuery(queryString);
			query.setLong("id", id);
			query.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return false;
		}
		return true;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Warehouse> warehouseProducts(){
		List<Warehouse> retVal = null;
		try{
			log.debug("warehouseProducts from db... ");
			String queryString = "from Warehouse wh where wh.isActive = 1";
			Query query = getSession().createQuery(queryString);
			retVal = query.list();
		}catch(Exception e){
			e.printStackTrace();
			log.error("fetching all active warehouses failed ..."+e.getMessage());
		}
		return retVal;
	}
	
}
