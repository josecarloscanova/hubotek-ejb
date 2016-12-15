package org.hubotek.service.google.news;

import java.net.URLEncoder;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import org.hubotek.model.HubDocument;
import org.hubotek.service.ejb.document.HubDocumentProvider;
import org.hubotek.service.ejb.document.HubDocumentType;
import org.hubotek.service.event.DocumentProcessingEvent;
import org.hubotek.service.http.HttpRequestParameters;
import org.hubotek.service.http.RequestType;
import org.hubotek.service.http.impl.HttpRequestProcessorServiceImpl;
import org.hubotek.util.EncoderHelper;


/**
 * @author JoseCanova
 */
@Stateless
public class GoogleNewsServiceImpl implements GoogleNewsService
{

	private static final long serialVersionUID = -8668390061371345053L;

	@Inject @Named("httpRequestProcessor")
	HttpRequestProcessorServiceImpl httpRequestProcessor; 
	
	@Inject
	Event<DocumentProcessingEvent> event;
	
	@EJB 
	HubDocumentProvider hubDocumentProvider;
	
	@Override
	public HubDocument processRequest() {
		String documentString =  httpRequestProcessor.processRequest(getDefaultUrl(), new HttpRequestParameters(), RequestType.GET);
		fireEventDocumentProcessing(documentString);
		return hubDocumentProvider.processDocument(documentString, HubDocumentType.RSS);
	}
	
	@Override
	public HubDocument processRequestTop() {
		String documentString =   httpRequestProcessor.processRequest(getTopUrl(), new HttpRequestParameters(), RequestType.GET);
		fireEventDocumentProcessing(documentString);
		return hubDocumentProvider.processDocument(documentString, HubDocumentType.RSS);
	}

	@Override
	public HubDocument processRequestEntertainement() {
		String documentString =  httpRequestProcessor.processRequest(getEntertaimentUrl(), new HttpRequestParameters(), RequestType.GET);
		fireEventDocumentProcessing(documentString);
		return hubDocumentProvider.processDocument(documentString, HubDocumentType.RSS);
	}
	
	@Override
	public HubDocument processRequestWorld() {
		String documentString =   httpRequestProcessor.processRequest(getWorldUrl(), new HttpRequestParameters(), RequestType.GET);
		fireEventDocumentProcessing(documentString);
		return hubDocumentProvider.processDocument(documentString, HubDocumentType.RSS);
	}
	
	@Override
	public HubDocument processRequestSearch(String searchString)
	{ 
		String encodedString = EncoderHelper.encode(searchString);
		String documentString = httpRequestProcessor.processRequest( getSearchUrl(encodedString), new HttpRequestParameters(), RequestType.GET);
		fireEventDocumentProcessing(documentString);
		return  hubDocumentProvider.processDocument(documentString, HubDocumentType.RSS);
	}
	
	@Override
	public HubDocument processRequestCountry() {
		String documentString =   httpRequestProcessor.processRequest(getCountryUrl(), new HttpRequestParameters(), RequestType.GET);
		fireEventDocumentProcessing(documentString);
		return hubDocumentProvider.processDocument(documentString, HubDocumentType.RSS);
	}

	@Override
	public HubDocument processRequestSports() {
		String documentString =   httpRequestProcessor.processRequest(getSportsUrl(), new HttpRequestParameters(), RequestType.GET);
		fireEventDocumentProcessing(documentString);
		return hubDocumentProvider.processDocument(documentString, HubDocumentType.RSS);
	}

	@Override
	public HubDocument processRequestHealth() {
		String documentString =   httpRequestProcessor.processRequest(getHealthUrl(), new HttpRequestParameters(), RequestType.GET);
		fireEventDocumentProcessing(documentString);
		return hubDocumentProvider.processDocument(documentString, HubDocumentType.RSS);
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
		return new GoogleNewsUrlBuilder().withParameter(GoogleNewsUrlParametersEnum.CODE, "all").withParameter(GoogleNewsUrlParametersEnum.PZ , "1").withParameter(GoogleNewsUrlParametersEnum.TOPIC, "e").withParameter(GoogleNewsUrlParametersEnum.NED, "us").withParameter(GoogleNewsUrlParametersEnum.OUTPUT, "rss").build();
	}

	private String getTopUrl()
	{ 
		return new GoogleNewsUrlBuilder().withParameter(GoogleNewsUrlParametersEnum.CODE, "all").withParameter(GoogleNewsUrlParametersEnum.PZ , "1").withParameter(GoogleNewsUrlParametersEnum.NED, "us").withParameter(GoogleNewsUrlParametersEnum.OUTPUT, "rss").build();
	}
	
	private String getWorldUrl()
	{ 
		return new GoogleNewsUrlBuilder().withParameter(GoogleNewsUrlParametersEnum.CODE, "all").withParameter(GoogleNewsUrlParametersEnum.TOPIC, "w").withParameter(GoogleNewsUrlParametersEnum.PZ , "1").withParameter(GoogleNewsUrlParametersEnum.NED, "us").withParameter(GoogleNewsUrlParametersEnum.OUTPUT, "rss").build();
	}

	
	private String getCountryUrl()
	{ 
		return new GoogleNewsUrlBuilder().withParameter(GoogleNewsUrlParametersEnum.CODE, "all").withParameter(GoogleNewsUrlParametersEnum.TOPIC, "n").withParameter(GoogleNewsUrlParametersEnum.PZ , "1").withParameter(GoogleNewsUrlParametersEnum.NED, "us").withParameter(GoogleNewsUrlParametersEnum.OUTPUT, "rss").build();
	}
	
	private String getSportsUrl()
	{ 
		return new GoogleNewsUrlBuilder().withParameter(GoogleNewsUrlParametersEnum.CODE, "all").withParameter(GoogleNewsUrlParametersEnum.TOPIC, "s").withParameter(GoogleNewsUrlParametersEnum.PZ , "1").withParameter(GoogleNewsUrlParametersEnum.NED, "us").withParameter(GoogleNewsUrlParametersEnum.OUTPUT, "rss").build();
	}
	
	private String getHealthUrl()
	{ 
		return new GoogleNewsUrlBuilder().withParameter(GoogleNewsUrlParametersEnum.CODE, "all").withParameter(GoogleNewsUrlParametersEnum.TOPIC, "m").withParameter(GoogleNewsUrlParametersEnum.PZ , "1").withParameter(GoogleNewsUrlParametersEnum.NED, "us").withParameter(GoogleNewsUrlParametersEnum.OUTPUT, "rss").build();
	}
	
	private void fireEventDocumentProcessing(String documentString) {
		DocumentProcessingEvent eventSource = new DocumentProcessingEvent();
		eventSource.setDocumentToProcess(documentString);
		eventSource.setDocumentType(HubDocumentType.RSS);
		event.fire(eventSource);
	}

}
