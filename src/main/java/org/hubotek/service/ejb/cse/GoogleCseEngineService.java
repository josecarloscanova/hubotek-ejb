package org.hubotek.service.ejb.cse;

import java.util.List;

import org.hubotek.service.ejb.LocalService;
import org.hubotek.view.cse.GoogleCustomSearchEngine;


public interface GoogleCseEngineService extends LocalService{

	GoogleCustomSearchEngine findByValue(String definition);
	
	List<GoogleCustomSearchEngine> getEngines(); 
	
	void saveEngine(GoogleCustomSearchEngine googleCustomSearchEngine);

	void delete(GoogleCustomSearchEngine gcse); 
	
	void delete();
}
