package org.hubotek.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hubotek.service.orm.PersistenceService;
import org.nanotek.Base;

public abstract class DataBaseService<T extends Base<K> , K extends Serializable> implements Service {

	@Inject 
	protected PersistenceService persistenceService; 
	
	public abstract void deleteAll ();
	
	public  abstract T findById(K  id);
	
	public List<T> findByRange(Class<T> clazz)
	{ 
		return persistenceService.<T>createQuery("Select r from " + clazz.getSimpleName() , clazz).setFirstResult(0).setMaxResults(100).getResultList();
	}
	
	public abstract List<T> rangeOf();
}
