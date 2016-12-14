package org.hubotek.service.converter.search;

import java.util.Map;

import javax.inject.Named;

import org.hubotek.service.converter.ExpressionConverter;
import org.hubotek.view.search.history.HistoryDocument;

import com.querydsl.core.types.Expression;

@Named("historyDocumentExpressionConverter")
public class HistoryDocumentExpressionConverter extends ExpressionConverter<HistoryDocument>{

	@Override
	public HistoryDocument convert(Map<Expression<?>, ?> origin) {
		return new HistoryExpressionSupllier(origin).get();
	}

}
