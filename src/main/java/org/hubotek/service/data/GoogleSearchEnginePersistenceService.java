package org.hubotek.service.data;

import javax.inject.Inject;
import javax.inject.Named;

import org.hubotek.model.cse.GoogleSearchEngine;
import org.hubotek.service.orm.PersistenceService;

@Named
public class GoogleSearchEnginePersistenceService {

	
	@Inject 
	private PersistenceService persistenceService; 
	
	public GoogleSearchEngine saveSearchEngineDefinition(GoogleSearchEngine cse)
	{ 
		return persistenceService.save(cse);
	}
	
	public GoogleSearchEngine findById(String id)
	{ 
		return persistenceService.find(GoogleSearchEngine.class, id);
	}
	
}
