package org.hubotek.service.converter.search;

import javax.enterprise.context.Dependent;

import org.hubotek.Converter;
import org.hubotek.model.HubDocument;
import org.hubotek.view.search.history.HistoryDocument;

@Dependent
public abstract class HistoryDocumentCoverter<T extends HubDocument> implements Converter<HistoryDocument , T>{
}
