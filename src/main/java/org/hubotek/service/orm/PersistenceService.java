package org.hubotek.service.orm;

import java.util.Map;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import org.nanotek.Base;

/**
 * Not yet finished
 * 
 * @author JoseCanova
 *
 */
@Named("persistenceService")
public class PersistenceService{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public PersistenceService(){}
	
	public EntityManager  getEntityManager () 
	{ 
		return entityManager;
	}
	
	public <T extends Base<?>> T save(T t)
	{ 
		return entityManager.merge(t);
	}
	
	public <T extends Base<?>>  void delete(Class<T> baseClass)
	{ 
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaDelete<T> criteriaDelete =  cb.createCriteriaDelete(baseClass);
		Root<T> delete = criteriaDelete.from(baseClass);
		entityManager.createQuery(criteriaDelete).executeUpdate();
	}
	
	public <T extends Base<?>>  void remove(T instance)
	{ 
		 entityManager.remove(instance);
	}


	public <T extends Base<?>>  void persist(T entity) {
		entityManager.persist(entity);
	}


	public <T> T find(Class<T> entityClass, Object primaryKey) {
		return entityManager.find(entityClass, primaryKey);
	}


	public <T> T find(Class<T> entityClass, Object primaryKey, Map<String, Object> properties) {
		return entityManager.find(entityClass, primaryKey, properties);
	}


	public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode) {
		return entityManager.find(entityClass, primaryKey, lockMode);
	}


	public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode, Map<String, Object> properties) {
		return entityManager.find(entityClass, primaryKey, lockMode, properties);
	}


	public void flush() {
		entityManager.flush();
	}


	public void setFlushMode(FlushModeType flushMode) {
		entityManager.setFlushMode(flushMode);
	}


	public void refresh(Object entity) {
		entityManager.refresh(entity);
	}


	public void refresh(Object entity, Map<String, Object> properties) {
		entityManager.refresh(entity, properties);
	}


	public void refresh(Object entity, LockModeType lockMode) {
		entityManager.refresh(entity, lockMode);
	}


	public void refresh(Object entity, LockModeType lockMode, Map<String, Object> properties) {
		entityManager.refresh(entity, lockMode, properties);
	}


	public boolean contains(Object entity) {
		return entityManager.contains(entity);
	}


	public Query createQuery(String qlString) {
		return entityManager.createQuery(qlString);
	}


	public <T> TypedQuery<T> createQuery(String qlString, Class<T> resultClass) {
		return entityManager.createQuery(qlString, resultClass);
	}


	public Query createNamedQuery(String name) {
		return entityManager.createNamedQuery(name);
	}


	public <T> TypedQuery<T> createNamedQuery(String name, Class<T> resultClass) {
		return entityManager.createNamedQuery(name, resultClass);
	}


	public Query createNativeQuery(String sqlString) {
		return entityManager.createNativeQuery(sqlString);
	}


	public Query createNativeQuery(String sqlString, Class<?> resultClass) {
		return entityManager.createNativeQuery(sqlString, resultClass);
	}


	public Query createNativeQuery(String sqlString, String resultSetMapping) {
		return entityManager.createNativeQuery(sqlString, resultSetMapping);
	}


	public StoredProcedureQuery createNamedStoredProcedureQuery(String name) {
		return entityManager.createNamedStoredProcedureQuery(name);
	}


	public <T> T unwrap(Class<T> cls) {
		return entityManager.unwrap(cls);
	}


	public CriteriaBuilder getCriteriaBuilder() {
		return entityManager.getCriteriaBuilder();
	}
	
}
