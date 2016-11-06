package org.hubotek.service.converter.search;

import javax.inject.Named;

import org.hubotek.Converter;
import org.hubotek.model.rss.RssItem;
import org.hubotek.view.search.history.HistoryDocumentItem;

@Named("historyDocumentItemConverter")
public class HistoryDocumentItemConverter implements Converter<HistoryDocumentItem , RssItem>{

	@Override
	public HistoryDocumentItem convert(RssItem origin) {
		return new HistoryDocumentItemSupplier(origin).get();
	}

}
