package org.hubotek.service.ejb;

public interface HttpService extends LocalService{

	String doRequest(String url);
	
}
