package org.hubotek.service.google.search;

import org.hubotek.model.google.search.SearchParameterTemplate;
import org.hubotek.service.ejb.LocalService;

public interface GoogleSearchService extends LocalService {
//TODO: change the parameter for a map.
	public String doSearch(SearchParameterTemplate searchParameterTemplate);
	
}
