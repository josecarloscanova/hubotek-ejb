package org.hubotek.service.google.news;

import org.hubotek.model.HubDocument;
import org.hubotek.service.ejb.LocalService;

public interface GoogleNewsService extends LocalService{

	String processRequest();
	
	String processRequestTop(); 
	
	String processRequestEntertainement();
	
	String processRequestWorld();
	
	String processRequestSearch(String searchString);
	
	HubDocument processRequestSearchHub(String searchString);
}
