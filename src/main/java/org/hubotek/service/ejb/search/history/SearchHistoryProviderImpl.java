package org.hubotek.service.ejb.search.history;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import org.hubotek.service.converter.search.HistoryRssDocumentCoverter;
import org.hubotek.service.data.RssDocumentService;
import org.hubotek.service.ejb.SearchHistoryProvider;
import org.hubotek.view.search.history.HistoryDocument;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SearchHistoryProviderImpl implements SearchHistoryProvider {

	@Inject
	RssDocumentService rssDocumentService;
	
	@Inject
	HistoryRssDocumentCoverter converter;
	
	@Override
	public List<HistoryDocument> findHistoryDocuments() {
		return rssDocumentService.rangeOf().stream().map(p->converter.convert(p)).collect(Collectors.toList());
	}

}
