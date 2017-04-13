package org.hubotek.service.http;

import org.hubotek.service.http.header.HttpHeaders;

public class HttpRequestParameters {

	private static final Integer DEFAULT_TIMEOUT = 300000;
	
	private Integer connectTimeout = DEFAULT_TIMEOUT; 
	
	private Integer socketTimeout = DEFAULT_TIMEOUT;
	
	//TODO implements a method that manipulate the request headers on service.
	private HttpHeaders headers;

	public HttpRequestParameters(){
		headers = new HttpHeaders();
	}
	
	public HttpRequestParameters(Integer connectTimeout, Integer socketTimeout) {
		super();
		this.connectTimeout = connectTimeout;
		this.socketTimeout = socketTimeout;
	}

	public Integer getConnectTimeout() {
		return connectTimeout;
	}

	public Integer getSocketTimeout() {
		return socketTimeout;
	}
	
}
