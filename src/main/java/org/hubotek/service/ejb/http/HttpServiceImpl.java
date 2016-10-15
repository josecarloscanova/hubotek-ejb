package org.hubotek.service.ejb.http;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.hubotek.service.ejb.HttpService;
import org.hubotek.service.http.HttpRequestProcessor;

@Stateless
public class HttpServiceImpl implements HttpService {

	
	/*@Inject 
	HttpRequestProcessor requestProcessor; */
	
	@Override
	public String doRequest(String url) {
		return "This is a String";
	}

}
