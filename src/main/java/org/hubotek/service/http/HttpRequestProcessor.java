package org.hubotek.service.http;

import java.util.EnumMap;
import java.util.Map;

import javax.inject.Named;

import org.apache.http.client.fluent.Request;
import org.hubotek.service.HubotekServiceException;


@Named("httpRequestProcessor")
public class HttpRequestProcessor implements HttpRequestProcessorService{

	private static final Map <RequestType , RequestReference> requestMethodAdapter = new EnumMap<RequestType,RequestReference>(RequestType.class);

	static { 
		requestMethodAdapter.put(RequestType.GET,  s -> Request.Get(s));
		requestMethodAdapter.put(RequestType.PUT,  s ->  Request.Put(s));
		requestMethodAdapter.put(RequestType.POST, s ->  Request.Post(s));
		requestMethodAdapter.put(RequestType.HEAD, s ->  Request.Head(s));
		requestMethodAdapter.put(RequestType.PATCH, s ->  Request.Patch(s));
		requestMethodAdapter.put(RequestType.DELETE, s ->  Request.Delete(s));
	}

	public HttpRequestProcessor()
	{ 
	}
	
	@Override
	public String processRequest(String url , HttpRequestParameters requestParameters , RequestType requestType)
	{ 
		// Execute a GET with timeout settings and return response content as String.
		String bodyResponse = null;
		try { 

			bodyResponse =   requestMethodAdapter.get(requestType).prepare(url)
					.connectTimeout(requestParameters.getConnectTimeout())
					.socketTimeout(requestParameters.getSocketTimeout())
					.execute().returnContent().asString();
		} catch (Exception e) {
			throw new HubotekServiceException(e);
		}
		return bodyResponse;
	}

}
