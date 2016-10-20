package org.hubotek.service.ejb;

import org.hubotek.service.http.HttpRequestParameters;
import org.hubotek.service.http.RequestType;

public interface HttpService extends LocalService{

	String doRequest(String url);
	
	String doRequest(String url , RequestType requestType);
	
	String doRequest(String url , RequestType requestType , HttpRequestParameters httpRequestParameters);
	
	String doRequest(String url, HttpRequestParameters httpRequestParameters, RequestType get) ;
}
