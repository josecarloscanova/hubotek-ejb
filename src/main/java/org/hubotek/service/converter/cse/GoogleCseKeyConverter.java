package org.hubotek.service.converter.cse;

import javax.inject.Named;

import org.hubotek.model.cse.CseKey;
import org.hubotek.view.cse.GoogleCustomSearchEngineKey;

@Named("googleCseKeyConverter")
public class GoogleCseKeyConverter extends CseKeyConverter<GoogleCustomSearchEngineKey>{

	@Override
	public GoogleCustomSearchEngineKey convert(CseKey origin) {
		return new GoogleCustomSearchEngineKey(origin.getId() , origin.getKey() , origin.getDateCreated());
	}

}
