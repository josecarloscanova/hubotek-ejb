package org.hubotek.service.ejb.cse;

import java.util.List;

import org.hubotek.model.cse.CseKey;
import org.hubotek.service.ejb.LocalService;
import org.hubotek.view.cse.GoogleCustomSearchEngineKey;

public interface GoogleCseKeyService extends LocalService{

	List<CseKey> findByKey(String key);
	
	List<?> getKeys(); 
	
	void saveKey(GoogleCustomSearchEngineKey googleCustomSearchEngineKey);

	void delete();
	
	CseKey getCurrentKey();
	
}
