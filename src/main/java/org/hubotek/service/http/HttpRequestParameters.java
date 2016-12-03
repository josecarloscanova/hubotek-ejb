package org.hubotek.service.http;

public class HttpRequestParameters {

	private Integer connectTimeout = 90000; 
	
	private Integer socketTimeout = 90000;

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
