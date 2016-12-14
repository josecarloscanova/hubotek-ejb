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
import org.hubotek.view.cse.GoogleCustomSearchEngineKey;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Stateless
public class GoogleCseKeyServiceImpl extends DataBaseService<CseKey , Long> implements GoogleCseKeyService {

	private static final long serialVersionUID = 7560372868914363286L;

	private QCseKey qcseKey;

	private JPAQuery<Void> query;

	private JPAQueryFactory qf;
	
	@Inject @Named("customSearchKeyConverter")
	CustomSearchKeyConverter converter;
	
	@Inject @Named("googleCseKeyConverter")
	GoogleCseKeyConverter googleCseKeyConverter;
	
	public GoogleCseKeyServiceImpl(){}
	
	@PostConstruct
	public void prepare()
	{ 
		 qcseKey = QCseKey.cseKey;
		 query = new JPAQuery<Void>(persistenceService.getEntityManager());
		 qf = new JPAQueryFactory(persistenceService.getEntityManager());
	}
	
	public CseKey addNewKey(CseKey cseKey)
	{ 
		return persistenceService.save(cseKey);
	}
	
	public List<CseKey> findByKey(String key)
	{ 
		return qf.selectFrom(qcseKey).where(qcseKey.key.like(new StringBuffer('%').append(key).append('%').toString())).fetch();
	}
	
	public List<?> getKeys()
	{ 
		return qf.selectFrom(qcseKey).orderBy(qcseKey.id.asc()).fetch().stream().map(k ->googleCseKeyConverter.convert(k)).collect(Collectors.toList());
	}

	public void saveKey(GoogleCustomSearchEngineKey googleCustomSearchEngineKey) {
		addNewKey(converter.convert(googleCustomSearchEngineKey));
	}

	@Override
	public void delete() {
		deleteAll();
	}

	@Override
	public CseKey getCurrentKey() {
		return qf.selectFrom(qcseKey).orderBy(qcseKey.id.desc()).fetchFirst();
	}

}
