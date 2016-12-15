package org.hubotek.service.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.hubotek.model.cse.CseKey;
import org.hubotek.model.cse.QCseKey;
import org.hubotek.service.DataBaseService;

import com.querydsl.jpa.impl.JPAQueryFactory;

@Named("cseKeyService")
public class CseKeyService extends DataBaseService<CseKey , Long>{
	
	private QCseKey qcseKey;
	private JPAQueryFactory qf;
	
	public CseKeyService(){}
	
	@PostConstruct
	void prepare()
	{ 
		 qcseKey = QCseKey.cseKey;
		 qf = new JPAQueryFactory(persistenceService.getEntityManager());
	}
	
	public CseKey addNewKey(CseKey cseKey)
	{ 
		return persistenceService.save(cseKey);
	}
	
	public List<CseKey> findByValue(String key)
	{ 
		return qf.selectFrom(qcseKey).where(qcseKey.key.like(new StringBuffer('%').append(key).append('%').toString())).fetch();
	}
	
	public List<CseKey> listKeys(Integer offset , Integer limit)
	{ 
		return qf.selectFrom(qcseKey).offset(offset).limit(limit).orderBy(qcseKey.id.asc()).fetch();
	}
	
	public CseKey getCurrentKey() {
		return qf.selectFrom(qcseKey).orderBy(qcseKey.id.desc()).fetchFirst();
	}
	
}
