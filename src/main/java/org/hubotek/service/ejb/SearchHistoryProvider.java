package org.hubotek.service.ejb;

import java.util.List;

import org.hubotek.view.search.history.HistoryDocument;
import org.hubotek.view.search.history.HistoryDocumentItem;

public interface SearchHistoryProvider  extends LocalService{

	List<HistoryDocument> findHistoryDocuments(Integer offSet , Integer limit);
	
	List<HistoryDocumentItem> findItemByDocumentId(Long historyDocumentId);
	
}
