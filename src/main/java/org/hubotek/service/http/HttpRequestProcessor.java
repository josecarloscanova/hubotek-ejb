package org.hubotek.service.http;

import java.io.StringReader;
import java.util.EnumMap;
import java.util.Map;

import javax.inject.Named;

import org.apache.http.client.fluent.Request;
import org.hubotek.HubotekException;
import org.hubotek.model.rss.RssDocument;
import org.hubotek.model.rss.RssDocumentBuilder;
import org.hubotek.model.rss.RssItem;
import org.hubotek.service.HubotekServiceException;
import org.hubotek.service.Service;
import org.hubotek.util.DomParser;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;



@Named
public class HttpRequestProcessor implements Service{

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
