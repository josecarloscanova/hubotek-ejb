package org.hubotek.service.converter.cse;

import javax.inject.Named;

import org.hubotek.model.cse.CseKey;
import org.hubotek.view.cse.GoogleCustomSearchEngineKey;

@Named("customSearchKeyConverter")
public class CustomSearchKeyConverter extends GoogleCustomSearchEngineKeyConverter<CseKey>{

	public CustomSearchKeyConverter(){}
	
	@Override
	public CseKey convert(GoogleCustomSearchEngineKey origin) {
		return new CseKey(origin.getKey() , origin.getDateCreated());
	}

}
