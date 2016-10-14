package org.hubotek.service.http;

import javax.inject.Named;

import org.apache.http.client.fluent.Request;
import org.hubotek.service.HubotekServiceException;
import org.hubotek.service.Service;

@Named
public class HttpRequestProcessor implements Service{

	public String processRequest(String url , HttpRequestParameters requestParameters)
	{ 
		// Execute a GET with timeout settings and return response content as String.
		String ret = null;
		try {
			  ret = Request.Get(url)
			        .connectTimeout(requestParameters.getConnectTimeout())
			        .socketTimeout(requestParameters.getSocketTimeout())
			        .execute().returnContent().asString();
		} catch (Exception e) {
			throw new HubotekServiceException(e);
		}
		return ret;
	}
	
}
