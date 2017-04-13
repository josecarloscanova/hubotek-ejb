package org.hubotek.service.http.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

import javax.inject.Named;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.hubotek.service.HubotekServiceException;
import org.hubotek.service.http.HttpProcessorResponse;
import org.hubotek.service.http.HttpRequestParameters;
import org.hubotek.service.http.HttpRequestProcessorService;
import org.hubotek.service.http.RequestReference;
import org.hubotek.service.http.RequestType;
import org.hubotek.service.http.header.HttpHeader;
import org.hubotek.service.http.header.HttpHeaderEnum;


@Named("httpRequestProcessor")
public class HttpRequestProcessorServiceImpl implements HttpRequestProcessorService{

	private static final Map <RequestType , RequestReference> requestMethodAdapter = new EnumMap<RequestType,RequestReference>(RequestType.class);

	static { 
		requestMethodAdapter.put(RequestType.GET,  s -> Request.Get(s));
		requestMethodAdapter.put(RequestType.PUT,  s ->  Request.Put(s));
		requestMethodAdapter.put(RequestType.POST, s ->  Request.Post(s));
		requestMethodAdapter.put(RequestType.HEAD, s ->  Request.Head(s));
		requestMethodAdapter.put(RequestType.PATCH, s ->  Request.Patch(s));
		requestMethodAdapter.put(RequestType.DELETE, s ->  Request.Delete(s));
	}

	public HttpRequestProcessorServiceImpl()
	{ 
	}
	
	@Override
	public HttpProcessorResponse processRequest(String url , HttpRequestParameters requestParameters , RequestType requestType)
	{ 
		// Execute a GET with timeout settings and return response content as String.
		HttpProcessorResponse httpProcessorResponse = new HttpProcessorResponse();
		try { 
			Response response =   requestMethodAdapter.get(requestType).prepare(url)
					.connectTimeout(requestParameters.getConnectTimeout())
					.socketTimeout(requestParameters.getSocketTimeout())
					.execute();
			processResponse(response , httpProcessorResponse);
		} catch (Exception e) {
			throw new HubotekServiceException(e);
		}
		return httpProcessorResponse;
	}

	private void processResponse(Response response , HttpProcessorResponse httpResponse) throws IOException{
		processResponseHeaders(response.returnResponse() , httpResponse);
		processResponseContent(response.returnContent() , httpResponse);
	}

	//TODO implement de processing response of the content hold on apache http.
	private void processResponseContent(Content returnContent , HttpProcessorResponse httpResponse) {
		httpResponse.setContentBody(returnContent.asString());
	}

	private void processResponseHeaders(HttpResponse r , HttpProcessorResponse httpResponse) {
		Arrays.stream(r.getAllHeaders()).filter(h -> HttpHeaderEnum.byName(h.getName()) != HttpHeaderEnum.NONE).forEach(p -> processHeader(p , httpResponse));
	}

	private void processHeader(Header p , HttpProcessorResponse httpResponse) {
		httpResponse.addHeader(new HttpHeader(p.getName() , p.getValue()));
	}


}
