package org.hubotek.service.converter.cse;

import java.util.function.Function;

import javax.inject.Named;

import org.hubotek.model.cse.CseKey;
import org.hubotek.model.cse.QCseKey;
import org.hubotek.view.cse.GoogleCustomSearchEngineKey;

@Named("googleCseKeyConverter")
public class GoogleCseKeyConverter extends CseKeyConverter<GoogleCustomSearchEngineKey>{

	QCseKey qCseKey = QCseKey.cseKey;
	Function <CseKey , GoogleCustomSearchEngineKey> baseMap =    (CseKey x) ->     new GoogleCustomSearchEngineKey(x.getId() , x.getKey() , x.getDateCreated());
	
	@Override
	public GoogleCustomSearchEngineKey convert(CseKey origin) {
		return baseMap.apply(origin);
	}

}
