package org.hubotek.service.converter;

import java.util.Map;

import org.hubotek.Converter;

import com.querydsl.core.types.Expression;

public abstract class ExpressionConverter<T> implements Converter<T, Map<Expression<?> , ?> > {
}
