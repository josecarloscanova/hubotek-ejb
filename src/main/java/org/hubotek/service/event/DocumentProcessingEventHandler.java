package org.hubotek.service.event;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;

import org.hubotek.model.HubDocument;
import org.hubotek.service.ejb.HubDocumentService;
import org.hubotek.service.orm.PersistenceService;
import org.nanotek.Base;

@SuppressWarnings("serial")
@Named("documentProcessingEventHandler")
@Stateless
public class DocumentProcessingEventHandler implements DocumentProcessingHandler {

	@EJB
	HubDocumentService hubDocumentService;
	
	@Inject
	PersistenceService persistenceService;
	
	public void processXmlStringDocument(@Observes DocumentProcessingEvent documentProcessingEvent)
	{ 
		HubDocument document = hubDocumentService.processDocument(documentProcessingEvent.getDocumentToProcess(), documentProcessingEvent.getDocumentType());
		persistenceService.persist(toBase(document));
	}

	@SuppressWarnings("unchecked")
	private <T extends Base<?>> T toBase(HubDocument document) {
		return (T)document;
	}

}
