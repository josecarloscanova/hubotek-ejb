package org.hubotek.service.converter.search;

import java.util.function.Supplier;

import org.hubotek.model.rss.RssItem;
import org.hubotek.view.search.history.HistoryDocumentItem;

public class HistoryDocumentItemSupplier implements Supplier<HistoryDocumentItem> {

	private RssItem item;

	public HistoryDocumentItemSupplier(RssItem item){
		this.item = item;
	}
	
	@Override
	public HistoryDocumentItem get() {
		return new HistoryDocumentItem(item.getId() , item.getTitle() , item.getLink() , item.getCategory() , item.getPubDate(),item.getRssItemDescription().getDescription());
	}

}
