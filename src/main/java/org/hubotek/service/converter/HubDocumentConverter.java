package org.hubotek.service.converter;

import org.hubotek.Converter;
import org.hubotek.model.HubDocument;
import org.hubotek.service.ejb.document.HubDocumentType;

public class HubDocumentConverter implements Converter<HubDocument,String> {

	private HubDocumentType type; 
	private Converter <HubDocument,String> ac = (o) -> (new AtomDocumentConverter().convert(o));
	private Converter <HubDocument,String> rc = (o) -> (new RssDocumentConverter().convert(o));
	
	public HubDocumentConverter(HubDocumentType type) { 
		this.type = type;
	}
	
	@Override
	public HubDocument convert(String origin) {
		HubDocument hubDocument = null; 
		switch(type){ 
		case ATOM: 
			hubDocument =   ac.convert(origin);
			break;
		case RSS:
			hubDocument = rc.convert(origin); 
			break;
		case JSON:
			break;
		default:
			break;
		}
		return hubDocument;
	}

}
