package org.hubotek.service.ejb.document;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.hubotek.model.HubDocument;
import org.hubotek.service.ejb.HubDocumentService;

@SuppressWarnings("serial")
@Stateless
public class HubDocumentProviderImpl implements HubDocumentProvider{

	@EJB
	HubDocumentService hubDocumentService;
	
	public HubDocument processDocument(String xmlDocumentString , HubDocumentType documentType)
	{ 
		return hubDocumentService.processDocument(xmlDocumentString, documentType);
		
		
	}
}
