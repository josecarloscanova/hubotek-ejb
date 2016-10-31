package org.hubotek.service.ejb.document;

import javax.ejb.Stateless;

import org.hubotek.model.HubDocument;
import org.hubotek.service.converter.HubDocumentConverter;
import org.hubotek.service.ejb.HubDocumentService;

@SuppressWarnings("serial")
@Stateless
public class HubDocumentServiceImpl  implements HubDocumentService {

	@Override
	public  HubDocument processDocument(String xmlDocument, HubDocumentType documentType) {
		return new HubDocumentConverter(documentType).convert(xmlDocument);
	}

}
