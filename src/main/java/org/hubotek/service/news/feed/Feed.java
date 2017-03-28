package org.hubotek.service.news.feed;

import org.hubotek.model.document.DocumentType;

public class Feed {

	private Long feedId;
	
	private String feedName;
	
	private DocumentType documentType;
	
	private String description;
	
	private String feedUrl;
	
	private String feedUrlDescription;
	
	public Feed() {
	}
	
	public Long getFeedId() {
		return feedId;
	}

	public void setFeedId(Long feedId) {
		this.feedId = feedId;
	}

	public String getFeedName() {
		return feedName;
	}

	public void setFeedName(String feedName) {
		this.feedName = feedName;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFeedUrl() {
		return feedUrl;
	}

	public void setFeedUrl(String feedUrl) {
		this.feedUrl = feedUrl;
	}

	public String getFeedUrlDescription() {
		return feedUrlDescription;
	}

	public void setFeedUrlDescription(String feedUrlDescription) {
		this.feedUrlDescription = feedUrlDescription;
	}

	
}
