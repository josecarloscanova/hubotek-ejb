package org.hubotek.service.converter.search;

import java.util.function.Supplier;

import org.hubotek.model.rss.RssDocument;
import org.hubotek.view.search.history.HistoryDocument;

public class HistoryRssDocumentSupllier implements Supplier<HistoryDocument> {

	private RssDocument rssDocument;
	
	public HistoryRssDocumentSupllier(RssDocument rssDocument)
	{
		this.rssDocument = rssDocument;
	}
	
	@Override
	public HistoryDocument get() {
		return new HistoryDocument(rssDocument.getId() , rssDocument.getLegacyDocumentyType().name() , rssDocument.getRssBody().getTitle() , rssDocument.getRssBody().getLink() , rssDocument.getRssBody().getLanguage() , rssDocument.getRssBody().getWebMaster() , rssDocument.getRssBody().getCopyright() , rssDocument.getRssBody().getPubDate() , rssDocument.getRssBody().getLastBuildDate());
	}

}
