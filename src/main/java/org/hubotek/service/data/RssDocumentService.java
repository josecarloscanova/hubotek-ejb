package org.hubotek.service.data;

import javax.inject.Inject;
import javax.inject.Named;

import org.hubotek.model.rss.RssDocument;
import org.hubotek.service.DataBaseService;
import org.hubotek.service.orm.PersistenceService;

@Named
public class RssDocumentService extends DataBaseService<RssDocument , Long> {

	
	@Inject 
	PersistenceService persistenceService; 
	
	@Override
	public void deleteAll() {
		//nothing for now.
	}

	@Override
	public RssDocument findById(Long id) {
		return persistenceService.find(RssDocument.class, id);
	}

}
