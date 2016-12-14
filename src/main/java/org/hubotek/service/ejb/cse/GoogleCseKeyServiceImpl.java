package org.hubotek.service.ejb.cse;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import org.hubotek.model.cse.CseKey;
import org.hubotek.model.cse.QCseKey;
import org.hubotek.service.DataBaseService;
import org.hubotek.service.converter.cse.CustomSearchKeyConverter;
import org.hubotek.service.converter.cse.GoogleCseKeyConverter;
import org.hubotek.service.data.CseKeyService;
import org.hubotek.view.cse.GoogleCustomSearchEngineKey;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Stateless
public class GoogleCseKeyServiceImpl extends DataBaseService<CseKey , Long> implements GoogleCseKeyService {

	private static final long serialVersionUID = 7560372868914363286L;

	@Inject @Named("customSearchKeyConverter")
	CustomSearchKeyConverter converter;
	
	@Inject @Named("googleCseKeyConverter")
	GoogleCseKeyConverter cseKeyConverter;
	
	@Inject @Named("cseKeyService")
	CseKeyService cseKeyService;
	
	public GoogleCseKeyServiceImpl(){}
	
	@PostConstruct
	public void prepare()
	{ 
	}
	
	public List<GoogleCustomSearchEngineKey> findByValue(String key)
	{ 
		return cseKeyService.findByValue(key).stream().map(k ->cseKeyConverter.convert(k)).collect(Collectors.toList());
	}
	
	public List<GoogleCustomSearchEngineKey> getKeys()
	{ 
		return cseKeyService.listKeys( 0 , DEFAULT_MAX_RECORDS).stream().map(k ->cseKeyConverter.convert(k)).collect(Collectors.toList());
	}

	public void saveKey(GoogleCustomSearchEngineKey googleCustomSearchEngineKey) {
		cseKeyService.addNewKey(converter.convert(googleCustomSearchEngineKey));
	}

	@Override
	public void delete() {
		deleteAll();
	}

	@Override
	public GoogleCustomSearchEngineKey getCurrentKey() {
		return    cseKeyConverter.convert(cseKeyService.getCurrentKey());
	}

}
