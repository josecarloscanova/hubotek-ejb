package org.hubotek.service.event;

import java.util.Optional;

import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;

import org.hubotek.model.HubDocument;
import org.hubotek.model.document.DocumentBase;
import org.hubotek.service.ejb.document.HubDocumentProvider;
import org.hubotek.service.orm.PersistenceService;
import org.nanotek.Base;

@SuppressWarnings("serial")
@Named("documentProcessingEventHandler")
@Stateless
public class DocumentProcessingEventHandler implements DocumentProcessingHandler {

	@EJB
	HubDocumentProvider hubDocumentProvider;
	
	@Inject
	PersistenceService persistenceService;
	
	@Asynchronous
	public void processXmlStringDocument(@Observes DocumentProcessingEvent documentProcessingEvent)
	{ 
		HubDocument document = hubDocumentProvider.processDocument(documentProcessingEvent.getDocumentToProcess(), documentProcessingEvent.getDocumentType());
		persistenceService.persist(toBase(document));
	}

	@SuppressWarnings("unchecked")
	private <T extends Base<?>> T toBase(HubDocument document) {
		return  (T) Optional.of(document).get();
	}

}
