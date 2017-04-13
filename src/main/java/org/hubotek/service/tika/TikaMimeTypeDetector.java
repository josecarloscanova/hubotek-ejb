package org.hubotek.service.tika;

import javax.inject.Named;

import org.hubotek.model.document.HubotekDocument;
import org.hubotek.service.MimeTypeDetector;

@Named
public class TikaMimeTypeDetector implements MimeTypeDetector<HubotekDocument,MimeTypeEnum>{

	public TikaMimeTypeDetector() {
	}

	@Override
	public MimeTypeEnum detecMimeType(HubotekDocument origin) {
		return null;
	}

}
