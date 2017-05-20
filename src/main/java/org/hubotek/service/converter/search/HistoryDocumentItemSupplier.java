package org.hubotek.service.converter.search;

import java.util.Map;
import java.util.function.Supplier;

import org.hubotek.model.rss.QRssItem;
import org.hubotek.view.search.history.HistoryDocumentItem;

import com.querydsl.core.types.Expression;

public class HistoryDocumentItemSupplier implements Supplier<HistoryDocumentItem> {

	private Map<Expression<?>,?> tuple;
	private QRssItem rssItem;

	public HistoryDocumentItemSupplier(Map<Expression<?> , ?> item){
		this.tuple = item;
		rssItem = QRssItem.rssItem;
	}
	
	@Override
	public HistoryDocumentItem get() {
		return new HistoryDocumentItem((Long)tuple.get(rssItem.id) , (String) tuple.get(rssItem.title) , (String)tuple.get(rssItem.link) ,(String) tuple.get(rssItem.category) ,(String) tuple.get(rssItem.pubDate),(String)tuple.get(rssItem.rssItemDescription.description));
	}

}
