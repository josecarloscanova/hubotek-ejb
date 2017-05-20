package org.hubotek.service.converter.search;

import java.util.Map;

import javax.inject.Named;

import org.hubotek.Converter;
import org.hubotek.view.search.history.HistoryDocumentItem;

import com.querydsl.core.types.Expression;

@Named("historyDocumentItemConverter")
public class HistoryDocumentItemConverter implements Converter<HistoryDocumentItem , Map<Expression<?> , ?>>{

	@Override
	public HistoryDocumentItem convert( Map<Expression<?> , ?> origin) {
		return new HistoryDocumentItemSupplier(origin).get();
	}

}
