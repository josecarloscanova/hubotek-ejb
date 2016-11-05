package org.hubotek.service.ejb;

import java.util.List;

import org.hubotek.view.search.history.HistoryDocument;

public interface SearchHistoryProvider  extends LocalService{

	List<HistoryDocument> findHistoryDocuments();
	
}
