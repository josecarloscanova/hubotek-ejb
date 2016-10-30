package org.hubotek.service.ejb.document;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.hubotek.model.HubDocument;
import org.hubotek.service.converter.HubDocumentConverter;
import org.hubotek.service.ejb.HubDocumentService;
import org.hubotek.service.http.HttpRequestParameters;
import org.hubotek.service.http.HttpRequestProcessor;
import org.hubotek.service.http.RequestType;

@Stateless
public class HubDocumentServiceImpl  implements HubDocumentService {

	@Inject
	private HttpRequestProcessor httpRequestProcessor;

	@Override
	public  HubDocument requestDocumentFromUrl(String uri, HubDocumentType documentType) {
		String xmlString = httpRequestProcessor.processRequest(uri, new HttpRequestParameters(), RequestType.GET);
		return new HubDocumentConverter(documentType).convert(xmlString);
	}

}
