package org.hubotek.service.converter.search;

import java.util.Map;
import java.util.function.Supplier;

import org.hubotek.model.rss.QRssBody;
import org.hubotek.model.rss.QRssDocument;
import org.hubotek.view.search.history.HistoryDocument;

import com.querydsl.core.types.Expression;

public class HistoryExpressionSupllier implements Supplier<HistoryDocument> {

	QRssDocument document; 
	QRssBody body; 
	
	private Map<Expression<?>, ?> tuple;
	
	public HistoryExpressionSupllier(Map<Expression<?>,?> expression)
	{ 
		document = QRssDocument.rssDocument;
		body = QRssBody.rssBody;
		this.tuple = expression;
	}
	
	@Override
	public HistoryDocument get() {
		
//		return new HistoryDocumentItem((Long)tuple.get(rssItem.id) , (String) tuple.get(rssItem.title) , (String)tuple.get(rssItem.link) ,(String) tuple.get(rssItem.category) ,(String) tuple.get(rssItem.pubDate),(String)tuple.get(rssItem.rssItemDescription.description));
		return new HistoryDocument((Long)tuple.get(document.id) , 
				(String)tuple.get(document.legacyDocumentyType) , 
				(String)tuple.get(document.rssBody.title) ,  (String)tuple.get(document.rssBody.link) , 
				(String)tuple.get(document.rssBody.language),(String) tuple.get(document.rssBody.webMaster), 
				(String)tuple.get(document.rssBody.copyright), (String)tuple.get(document.rssBody.pubDate), 
				(String)tuple.get(document.rssBody.lastBuildDate));
	}

}
