package org.hubotek.service.ejb.cse;

import java.util.List;

import org.hubotek.service.ejb.LocalService;
import org.hubotek.view.cse.GoogleCustomSearchEngineKey;

public interface GoogleCseKeyService extends LocalService{

	List<GoogleCustomSearchEngineKey> findByValue(String key);
	
	List<GoogleCustomSearchEngineKey> getKeys(); 
	
	void saveKey(GoogleCustomSearchEngineKey googleCustomSearchEngineKey);

	void delete();
	
	GoogleCustomSearchEngineKey getCurrentKey();
	
}
