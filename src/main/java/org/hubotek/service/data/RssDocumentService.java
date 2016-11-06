package org.hubotek.service.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.hubotek.model.rss.QRssDocument;
import org.hubotek.model.rss.RssDocument;
import org.hubotek.service.DataBaseService;
import org.hubotek.service.Service;
import org.hubotek.service.orm.PersistenceService;

import com.querydsl.jpa.impl.JPAQuery;

public class RssDocumentService extends DataBaseService<RssDocument , Long> implements Service{

	@Inject 
	PersistenceService persistenceService; 
	
	private QRssDocument rssDocument;
	
	public RssDocumentService(){}
	
	@PostConstruct
	public void prepare()
	{ 
		rssDocument = QRssDocument.rssDocument;
	}
	
	public List<RssDocument> rangeOf()
	{ 
		JPAQuery<?> query = new JPAQuery<Void>(persistenceService.getEntityManager());
		return query.from(rssDocument).orderBy(rssDocument.id.desc()).createQuery().setFirstResult(0).setMaxResults(100).getResultList();
	}
	
	@Override
	public void deleteAll() {
		persistenceService.delete(RssDocument.class);
	}

	@Override
	public RssDocument findById(Long id) {
		return persistenceService.find(RssDocument.class, id);
	}
	
}
