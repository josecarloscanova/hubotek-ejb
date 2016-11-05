package org.hubotek.service.converter.search;

import javax.inject.Named;

import org.hubotek.model.rss.RssDocument;
import org.hubotek.view.search.history.HistoryDocument;

@Named("historyRssDocumentCoverter")
public class HistoryRssDocumentCoverter extends HistoryDocumentCoverter<RssDocument> {

	@Override
	public HistoryDocument convert(RssDocument origin) {
		return new HistoryRssDocumentSupllier(origin).get();
	}

}
