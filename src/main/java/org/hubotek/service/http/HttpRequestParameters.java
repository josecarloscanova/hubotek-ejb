package org.hubotek.service.http;

public class HttpRequestParameters {

	private static final Integer DEFAULT_TIMEOUT = 300000;
	
	private Integer connectTimeout = DEFAULT_TIMEOUT; 
	
	private Integer socketTimeout = DEFAULT_TIMEOUT;

	public HttpRequestParameters(){}
	
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
