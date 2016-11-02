package org.hubotek.service;

import java.io.Serializable;

import javax.inject.Inject;

import org.hubotek.service.orm.PersistenceService;
import org.nanotek.Base;

@SuppressWarnings("serial")
public abstract class DataBaseService<T extends Base<K> , K extends Serializable> implements Service {

	@Inject 
	protected PersistenceService persistenceService; 
	
	public abstract void deleteAll ();
	
	public  abstract T findById(K  id);
}
