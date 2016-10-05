package org.hubotek.service.repository.orm;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.nanotek.Base;

@Named
public class PersistenceService {

	@PersistenceContext
	private EntityManager entityManager;
	
	public <T extends Base<?>> T save(T t)
	{ 
		return entityManager.merge(t);
	}
	
	
	public <T extends Base<?>>  void delete(Class<T> baseClass)
	{ 
		 entityManager.createQuery("delete from " + baseClass.getSimpleName());
	}
}
