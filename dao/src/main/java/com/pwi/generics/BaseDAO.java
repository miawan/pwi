package com.pwi.generics;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

/**
 * @author mia
 */
public abstract class BaseDAO {

//	protected Class entityClass;

	
	private EntityManager entityManager;

	/*public BaseDAO() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class) genericSuperclass.getActualTypeArguments()[1];
	}*/
	@PersistenceContext
	void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	protected EntityManager getEntityManager(){
		return this.entityManager;
	}
	
	public Session getSession() {
		return (Session) getEntityManager().getDelegate();
	}
	
	public void saveOrUpdate(Object entity) {
		getSession().saveOrUpdate(entity);
	}

	public void remove(Object entity) {
		getSession().delete(entity);
	}

	public Object findById(Class<?> entityClass, Long id) {
		return getEntityManager().find(entityClass, id);
	}

}