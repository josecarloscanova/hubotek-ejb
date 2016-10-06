package org.hubotek.service.data;

import javax.inject.Inject;
import javax.inject.Named;

import org.hubotek.model.cse.GoogleSearchEngine;
import org.hubotek.model.feed.FeedUrl;
import org.hubotek.service.DataBaseService;
import org.hubotek.service.orm.PersistenceService;

@Named
public class GoogleSearchEngineService extends DataBaseService<GoogleSearchEngine , String>{

	
	public GoogleSearchEngine saveSearchEngineDefinition(GoogleSearchEngine cse)
	{ 
		return persistenceService.save(cse);
	}
	
	public GoogleSearchEngine findById(String id)
	{ 
		return persistenceService.find(GoogleSearchEngine.class, id);
	}
	
	public void deleteAll ()
	{ 
		persistenceService.delete(GoogleSearchEngine.class);
	}
	
}
