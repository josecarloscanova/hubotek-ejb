package org.hubotek.service.google.news;

import java.net.URLEncoder;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.hubotek.model.rss.RssDocument;
import org.hubotek.service.ejb.HubDocumentService;
import org.hubotek.service.ejb.document.HubDocumentType;
import org.hubotek.service.http.HttpRequestParameters;
import org.hubotek.service.http.HttpRequestProcessor;
import org.hubotek.service.http.RequestType;


/**
 * Not yet finished.
 * @author JoseCanova
 *
 */
@Stateless
public class GoogleNewsServiceImpl implements GoogleNewsService
{

	@Inject
	HttpRequestProcessor httpRequestProcessor; 
	
	@Inject
	GoogleNewsUrlBuilder googleNewsUrlBuilder; 
	
	@Inject
	HubDocumentService hubDocumentService;
	
	@Override
	public String processRequest() {
		return  httpRequestProcessor.processRequest(getDefaultUrl(), new HttpRequestParameters(), RequestType.GET);
	}
	
	@Override
	public String processRequestTop() {
		return httpRequestProcessor.processRequest(getTopUrl(), new HttpRequestParameters(), RequestType.GET);
	}

	@Override
	public String processRequestEntertainement() {
		return httpRequestProcessor.processRequest(getEntertaimentUrl(), new HttpRequestParameters(), RequestType.GET);
	}
	
	@Override
	public String processRequestWorld() {
		return httpRequestProcessor.processRequest(getWorldUrl(), new HttpRequestParameters(), RequestType.GET);
	}
	
	@Override
	public String processRequestSearch(String searchString)
	{ 
		String encodedString = URLEncoder.encode(searchString);
		return httpRequestProcessor.processRequest( getSearchUrl(encodedString), new HttpRequestParameters(), RequestType.GET);
	}
	
	private String getSearchUrl(String encodedString)
	{ 
		return googleNewsUrlBuilder.withParameter(GoogleNewsUrlParametersEnum.NUM, "30").withParameter(GoogleNewsUrlParametersEnum.NED, "us").withParameter(GoogleNewsUrlParametersEnum.QUERY, encodedString).withParameter(GoogleNewsUrlParametersEnum.OUTPUT, "rss").build();
	}
	
	private String getDefaultUrl()
	{ 
		return googleNewsUrlBuilder.withParameter(GoogleNewsUrlParametersEnum.CODE, "all").withParameter(GoogleNewsUrlParametersEnum.TOPIC, "tc").withParameter(GoogleNewsUrlParametersEnum.NED, "us").withParameter(GoogleNewsUrlParametersEnum.OUTPUT, "rss").build();
	}
	
	private String getEntertaimentUrl()
	{ 
		return googleNewsUrlBuilder.withParameter(GoogleNewsUrlParametersEnum.CODE, "all").withParameter(GoogleNewsUrlParametersEnum.TOPIC, "e").withParameter(GoogleNewsUrlParametersEnum.NED, "us").withParameter(GoogleNewsUrlParametersEnum.OUTPUT, "rss").build();
	}

	private String getTopUrl()
	{ 
		return googleNewsUrlBuilder.withParameter(GoogleNewsUrlParametersEnum.CODE, "all").withParameter(GoogleNewsUrlParametersEnum.PZ , "1").withParameter(GoogleNewsUrlParametersEnum.NED, "us").withParameter(GoogleNewsUrlParametersEnum.OUTPUT, "rss").build();
	}
	
	private String getWorldUrl()
	{ 
		return googleNewsUrlBuilder.withParameter(GoogleNewsUrlParametersEnum.CODE, "all").withParameter(GoogleNewsUrlParametersEnum.TOPIC, "w").withParameter(GoogleNewsUrlParametersEnum.PZ , "1").withParameter(GoogleNewsUrlParametersEnum.NED, "us").withParameter(GoogleNewsUrlParametersEnum.OUTPUT, "rss").build();
	}

}
