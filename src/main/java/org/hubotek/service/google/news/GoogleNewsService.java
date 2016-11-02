package org.hubotek.service.google.news;

import org.hubotek.model.HubDocument;
import org.hubotek.service.ejb.LocalService;

public interface GoogleNewsService extends LocalService{

	HubDocument processRequest();
	
	HubDocument processRequestTop(); 
	
	HubDocument processRequestEntertainement();
	
	HubDocument processRequestWorld();
	
	HubDocument processRequestSearch(String searchString);
	
	HubDocument processRequestSearchHub(String searchString);
}
