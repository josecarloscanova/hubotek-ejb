package org.hubotek.service.ejb.document;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.inject.Named;

import org.hubotek.model.HubDocument;
import org.hubotek.service.document.HubDocumentService;

@SuppressWarnings("serial")
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class HubDocumentProviderImpl implements HubDocumentProvider{

	@Inject @Named("hubDocumentService")
	HubDocumentService hubDocumentService;
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public HubDocument processDocument(String xmlDocumentString , HubDocumentType documentType)
	{ 
		return hubDocumentService.processDocument(xmlDocumentString, documentType);
	}
}
