package org.hubotek.service.data;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.hubotek.model.lob.QRssItemDescription;
import org.hubotek.model.rss.QRssDocument;
import org.hubotek.model.rss.QRssItem;
import org.hubotek.model.rss.RssDocument;
import org.hubotek.service.DataBaseService;
import org.hubotek.service.Service;
import org.hubotek.service.orm.PersistenceService;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Named("rssDocumentService")
public class RssDocumentService extends DataBaseService<RssDocument , Long> implements Service{

	@Inject 
	PersistenceService persistenceService; 
	
	private QRssDocument rssDocument;
	private QRssItem rssItem;
	private QRssItemDescription rssItemDescription;
	private JPAQuery<?> query;
	private JPAQueryFactory  qf;
	
	public RssDocumentService(){}
	
	@PostConstruct
	public void prepare()
	{ 
		rssDocument = QRssDocument.rssDocument;
		rssItem = QRssItem.rssItem;
		rssItemDescription = QRssItemDescription.rssItemDescription;
		query = new JPAQuery<Void>(persistenceService.getEntityManager());
		qf = new JPAQueryFactory(persistenceService.getEntityManager());
	}
	
	public List<Map<Expression<?>,?>> getRangeOf()
	{ 
//		applyMapProjection(rssDocument, Projections.map(rssDocument.id  , rssDocument.rssBody.title , rssDocument.rssBody.link, rssDocument.rssBody.webMaster, rssDocument.rssBody.pubDate));
		return qf.select(Projections.map(rssDocument.id  , rssDocument.rssBody.title , rssDocument.rssBody.link, rssDocument.rssBody.webMaster, rssDocument.rssBody.pubDate)).from(rssDocument).orderBy(rssDocument.id.desc()).limit(100).fetch();
	}
	

	public List<Map<Expression<?>,?>> getRangeOf(int offset , int num_records)
	{ 
//		applyMapProjection(rssDocument, Projections.map(rssDocument.id  , rssDocument.rssBody.title , rssDocument.rssBody.link, rssDocument.rssBody.webMaster, rssDocument.rssBody.pubDate));
		return qf.select(Projections.map(rssDocument.id  , rssDocument.rssBody.title , rssDocument.rssBody.link, rssDocument.rssBody.webMaster, rssDocument.rssBody.pubDate)).from(rssDocument).orderBy(rssDocument.id.desc()).offset(offset).limit(num_records).fetch();
	}

	
	public List<Map<Expression<?>,?>> findRssDocumentItems(Long documentId)
	{ 
		
		return  qf.select(Projections.map(rssItem.id, rssItem.title , rssItem.link , rssItem.pubDate , rssItem.category , rssItem.rssItemDescription.description)).from(rssItem)
				.innerJoin(rssItem.rssItemDescription , rssItemDescription)
				.where (rssItem.id.in(
						JPAExpressions.select(rssItem.id)
			            .from(rssDocument)
			            .innerJoin(rssDocument.rssItems , rssItem)
			            .where(rssDocument.id.eq(documentId)))
				).fetch();
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
