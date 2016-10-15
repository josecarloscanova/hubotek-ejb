package org.hubotek.service.ejb.http;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.hubotek.service.ejb.HttpService;
import org.hubotek.service.http.HttpRequestParameters;
import org.hubotek.service.http.HttpRequestProcessor;
import org.hubotek.service.http.RequestType;

@Stateless
public class HttpServiceImpl implements HttpService {

	
	@Inject 
	HttpRequestProcessor requestProcessor; 
	
	@Override
	public String doRequest(String url) {
		return requestProcessor.processRequest(url, new HttpRequestParameters(), RequestType.GET);
	}

}
