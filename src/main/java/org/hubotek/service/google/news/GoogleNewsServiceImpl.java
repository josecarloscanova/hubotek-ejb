package org.hubotek.service.google.news;

import java.net.URLEncoder;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import org.hubotek.service.ejb.document.HubDocumentType;
import org.hubotek.service.event.DocumentProcessingEvent;
import org.hubotek.service.http.HttpRequestParameters;
import org.hubotek.service.http.RequestType;
import org.hubotek.service.http.impl.HttpRequestProcessorServiceImpl;


/**
 * Not yet finished.
 * @author JoseCanova
 *
 */
@SuppressWarnings("serial")
@Stateless
public class GoogleNewsServiceImpl implements GoogleNewsService
{

	@Inject @Named("httpRequestProcessor")
	HttpRequestProcessorServiceImpl httpRequestProcessor; 
	
	@Inject
	Event<DocumentProcessingEvent> event;
	
	@Override
	public String processRequest() {
		String documentString =  httpRequestProcessor.processRequest(getDefaultUrl(), new HttpRequestParameters(), RequestType.GET);
		fireEventDocumentProcessing(documentString);
		return documentString;
	}
	
	@Override
	public String processRequestTop() {
		String documentString =   httpRequestProcessor.processRequest(getTopUrl(), new HttpRequestParameters(), RequestType.GET);
		fireEventDocumentProcessing(documentString);
		return documentString;
	}

	@Override
	public String processRequestEntertainement() {
		String documentString =  httpRequestProcessor.processRequest(getEntertaimentUrl(), new HttpRequestParameters(), RequestType.GET);
		fireEventDocumentProcessing(documentString);
		return documentString;
	}
	
	@Override
	public String processRequestWorld() {
		String documentString =   httpRequestProcessor.processRequest(getWorldUrl(), new HttpRequestParameters(), RequestType.GET);
		fireEventDocumentProcessing(documentString);
		return documentString;
	}
	
	@Override
	public String processRequestSearch(String searchString)
	{ 
		String encodedString = URLEncoder.encode(searchString);
		String documentString = httpRequestProcessor.processRequest( getSearchUrl(encodedString), new HttpRequestParameters(), RequestType.GET);
		fireEventDocumentProcessing(documentString);
		return documentString;
	}
	
	private String getSearchUrl(String encodedString)
	{ 
		return new GoogleNewsUrlBuilder().withParameter(GoogleNewsUrlParametersEnum.NUM, "30").withParameter(GoogleNewsUrlParametersEnum.NED, "us").withParameter(GoogleNewsUrlParametersEnum.QUERY, encodedString).withParameter(GoogleNewsUrlParametersEnum.OUTPUT, "rss").build();
	}
	
	private String getDefaultUrl()
	{ 
		return new GoogleNewsUrlBuilder().withParameter(GoogleNewsUrlParametersEnum.CODE, "all").withParameter(GoogleNewsUrlParametersEnum.TOPIC, "tc").withParameter(GoogleNewsUrlParametersEnum.NED, "us").withParameter(GoogleNewsUrlParametersEnum.OUTPUT, "rss").build();
	}
	
	private String getEntertaimentUrl()
	{ 
		return new GoogleNewsUrlBuilder().withParameter(GoogleNewsUrlParametersEnum.CODE, "all").withParameter(GoogleNewsUrlParametersEnum.TOPIC, "e").withParameter(GoogleNewsUrlParametersEnum.NED, "us").withParameter(GoogleNewsUrlParametersEnum.OUTPUT, "rss").build();
	}

	private String getTopUrl()
	{ 
		return new GoogleNewsUrlBuilder().withParameter(GoogleNewsUrlParametersEnum.CODE, "all").withParameter(GoogleNewsUrlParametersEnum.PZ , "1").withParameter(GoogleNewsUrlParametersEnum.NED, "us").withParameter(GoogleNewsUrlParametersEnum.OUTPUT, "rss").build();
	}
	
	private String getWorldUrl()
	{ 
		return new GoogleNewsUrlBuilder().withParameter(GoogleNewsUrlParametersEnum.CODE, "all").withParameter(GoogleNewsUrlParametersEnum.TOPIC, "w").withParameter(GoogleNewsUrlParametersEnum.PZ , "1").withParameter(GoogleNewsUrlParametersEnum.NED, "us").withParameter(GoogleNewsUrlParametersEnum.OUTPUT, "rss").build();
	}

	private void fireEventDocumentProcessing(String documentString) {
		DocumentProcessingEvent eventSource = new DocumentProcessingEvent();
		eventSource.setDocumentToProcess(documentString);
		eventSource.setDocumentType(HubDocumentType.RSS);
		event.fire(eventSource);
	}

}
