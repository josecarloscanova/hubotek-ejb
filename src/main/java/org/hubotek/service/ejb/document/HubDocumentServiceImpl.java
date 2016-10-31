package org.hubotek.service.ejb.document;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import org.hubotek.model.HubDocument;
import org.hubotek.service.converter.HubDocumentConverter;
import org.hubotek.service.ejb.HubDocumentService;
import org.hubotek.service.http.HttpRequestParameters;
import org.hubotek.service.http.RequestType;
import org.hubotek.service.http.impl.HttpRequestProcessorServiceImpl;

@Stateless
public class HubDocumentServiceImpl  implements HubDocumentService {

	@Inject  @Named("httpRequestProcessor")
	private HttpRequestProcessorServiceImpl httpRequestProcessor;

	@Override
	public  HubDocument requestDocumentFromUrl(String uri, HubDocumentType documentType) {
		String xmlString = httpRequestProcessor.processRequest(uri, new HttpRequestParameters(), RequestType.GET);
		return new HubDocumentConverter(documentType).convert(xmlString);
	}

}
