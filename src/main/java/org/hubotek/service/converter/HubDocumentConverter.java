package org.hubotek.service.converter;

import java.util.HashMap;
import java.util.Map;

import org.hubotek.Converter;
import org.hubotek.DocumentConverter;
import org.hubotek.model.HubDocument;
import org.hubotek.service.ejb.document.HubDocumentType;

public class HubDocumentConverter<T extends HubDocument> implements Converter<T,String> {

	private  final  Map<HubDocumentType , DocumentConverter <T>> dc = new HashMap<HubDocumentType,DocumentConverter<T>>();
	private HubDocumentType type; 
	
	
	@SuppressWarnings("unchecked")
	public HubDocumentConverter(HubDocumentType type) { 
		this.type = type;
		dc.put(HubDocumentType.ATOM, s -> ((T)new AtomDocumentConverter().convert(s)));
		dc.put(HubDocumentType.RSS, s -> ((T)new RssDocumentConverter().convert(s)));
	}
	
	
	@Override
	public T convert(String origin) {
		return dc.get(type).convert(origin);
	}

}
