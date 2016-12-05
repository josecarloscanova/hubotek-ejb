package org.hubotek.service.ejb.search.history;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.inject.Named;

import org.hubotek.model.rss.RssDocument;
import org.hubotek.service.converter.search.HistoryDocumentItemConverter;
import org.hubotek.service.converter.search.HistoryRssDocumentCoverter;
import org.hubotek.service.data.RssDocumentService;
import org.hubotek.service.ejb.SearchHistoryProvider;
import org.hubotek.view.search.history.HistoryDocument;
import org.hubotek.view.search.history.HistoryDocumentItem;

@SuppressWarnings("serial")
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SearchHistoryProviderImpl implements SearchHistoryProvider {

	@Inject
	RssDocumentService rssDocumentService;
	
	@Inject
	HistoryRssDocumentCoverter converter;
	
	@Inject @Named("historyDocumentItemConverter")
	HistoryDocumentItemConverter documentItemConverter;
	
	//TODO: create class/type to manage pagination request.
	@Override
	public List<HistoryDocument> findHistoryDocuments(Integer offset , Integer limit) {
		return rssDocumentService.findByRange(RssDocument.class , offset , limit).stream().map(p->converter.convert(p)).collect(Collectors.toList());
	}

	@Override
	public List<HistoryDocumentItem> findItemByDocumentId(Long documentId) {
		return rssDocumentService.findRssDocumentItems(documentId).stream().map(p -> documentItemConverter.convert(p)).collect(Collectors.toList());
	}

}
