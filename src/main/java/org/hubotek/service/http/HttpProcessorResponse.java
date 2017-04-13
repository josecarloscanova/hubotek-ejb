package org.hubotek.service.http;

import javax.annotation.PostConstruct;

import org.hubotek.service.http.header.HttpHeader;
import org.hubotek.service.http.header.HttpHeaders;

public class HttpProcessorResponse {

	private HttpHeaders httpHeaderHolder;
	//TODO reate an arraybuffer of bytes and replace the string for content body.
	private String contentBody ;
	
	public HttpProcessorResponse() {
	}

	HttpProcessorResponse(String contentBody) 
	{
		super();
		this.contentBody = contentBody;
	}

	@PostConstruct
	void prepare()
	{ 
		httpHeaderHolder = new HttpHeaders();
	}

	public HttpHeader [] getHeaders() {
		return httpHeaderHolder.headers();
	}

	public String getContentBody() {
		return contentBody;
	}

	public void setContentBody(String contentBody) {
		this.contentBody = contentBody;
	}
	
	public void addHeader(HttpHeader header)
	{ 
		httpHeaderHolder.addHeader(header);
	}
}
