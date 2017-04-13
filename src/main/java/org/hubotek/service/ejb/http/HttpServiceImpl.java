package org.hubotek.service.ejb.http;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.inject.Named;

import org.hubotek.service.ejb.HttpService;
import org.hubotek.service.http.HttpRequestParameters;
import org.hubotek.service.http.RequestType;
import org.hubotek.service.http.impl.HttpRequestProcessorServiceImpl;

@SuppressWarnings("serial")
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class HttpServiceImpl implements HttpService {

	@Inject @Named(value="httpRequestProcessor")
	HttpRequestProcessorServiceImpl requestProcessor; 

	@Override
	public String doRequest(String url) {
		return doRequest(url , new HttpRequestParameters() , RequestType.GET);
	}

	@Override
	public String doRequest(String url, RequestType requestType) {
		return doRequest(url , new HttpRequestParameters() , requestType);
	}

	@Override
	public String doRequest(String url, RequestType requestType, HttpRequestParameters httpRequestParameters) {
		return requestProcessor.processRequest(url, httpRequestParameters, RequestType.GET).getContentBody();
	}

	public String doRequest(String url, HttpRequestParameters httpRequestParameters, RequestType get) {
		return requestProcessor.processRequest(url, httpRequestParameters, RequestType.GET).getContentBody();	
	}
}
