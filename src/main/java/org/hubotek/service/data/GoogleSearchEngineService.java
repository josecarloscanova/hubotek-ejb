package org.hubotek.service.data;

import java.util.List;

import javax.inject.Named;

import org.hubotek.model.google.cse.GoogleSearchEngine;
import org.hubotek.model.google.cse.QGoogleSearchEngine;
import org.hubotek.service.DataBaseService;

@Named
public class GoogleSearchEngineService extends DataBaseService<GoogleSearchEngine , Long>{

	
	public GoogleSearchEngine saveSearchEngineDefinition(GoogleSearchEngine cse)
	{ 
		return persistenceService.save(cse);
	}
	
	public GoogleSearchEngine findById(Long id)
	{ 
		return persistenceService.find(GoogleSearchEngine.class, id);
	}
	
	public void deleteAll ()
	{ 
		persistenceService.delete(GoogleSearchEngine.class);
	}

	@Override
	public List<GoogleSearchEngine> rangeOf() {
		QGoogleSearchEngine se = QGoogleSearchEngine.googleSearchEngine;
		return null;
	}
	
}
