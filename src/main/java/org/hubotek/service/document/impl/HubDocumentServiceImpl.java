package org.hubotek.service.document.impl;

import javax.inject.Named;

import org.hubotek.model.HubDocument;
import org.hubotek.service.converter.HubDocumentConverter;
import org.hubotek.service.document.HubDocumentService;
import org.hubotek.service.ejb.document.HubDocumentType;

@SuppressWarnings("serial")
@Named("hubDocumentService")
public class HubDocumentServiceImpl  implements HubDocumentService {

	@Override
	public  HubDocument processDocument(String xmlDocument, HubDocumentType documentType) {
		return new HubDocumentConverter(documentType).convert(xmlDocument);
	}

}
