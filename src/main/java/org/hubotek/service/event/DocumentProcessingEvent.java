package org.hubotek.service.event;

import java.io.Serializable;

import javax.inject.Named;

import org.hubotek.service.ejb.document.HubDocumentType;

@SuppressWarnings("serial")
@Named("documentProcessingEvent")
public class DocumentProcessingEvent implements Serializable{

	private String documentToProcess;
	
	private HubDocumentType documentType;

	public String getDocumentToProcess() {
		return documentToProcess;
	}

	public void setDocumentToProcess(String documentToProcess) {
		this.documentToProcess = documentToProcess;
	}

	public HubDocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(HubDocumentType documentType) {
		this.documentType = documentType;
	}
	
	
}
