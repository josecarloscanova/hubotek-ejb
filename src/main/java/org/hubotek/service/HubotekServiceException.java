package org.hubotek.service;

@SuppressWarnings("serial")
public class HubotekServiceException extends RuntimeException {

	public HubotekServiceException() {
		super();
	}

	public HubotekServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public HubotekServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public HubotekServiceException(String message) {
		super(message);
	}

	public HubotekServiceException(Throwable cause) {
		super(cause);
	}

}
