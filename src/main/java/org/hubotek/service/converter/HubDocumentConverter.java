package org.hubotek.service.converter;

import org.hubotek.Converter;
import org.hubotek.model.HubDocument;
import org.hubotek.service.ejb.document.HubDocumentType;

public class HubDocumentConverter<T extends HubDocument> implements Converter<T,String> {

	private HubDocumentType type; 
	
	public HubDocumentConverter(HubDocumentType type) { 
		this.type = type;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public T convert(String origin) {
		T hubDocument = null; 
		switch(type){ 
		case ATOM: 
			hubDocument = (T)new AtomDocumentConverter().convert(origin);
			break;
		case JSON:
			break;
		case RSS:
			hubDocument = (T)new RssDocumentConverter().convert(origin); 
			break;
		default:
			break;
		}
		return hubDocument;
	}

}
