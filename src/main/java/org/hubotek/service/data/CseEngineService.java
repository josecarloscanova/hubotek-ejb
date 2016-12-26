package org.hubotek.service.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.hubotek.model.cse.CseEngine;
import org.hubotek.model.cse.QCseEngine;
import org.hubotek.service.DataBaseService;

import com.querydsl.jpa.impl.JPAQueryFactory;

@Named("cseEngineService")
public class CseEngineService  extends DataBaseService<CseEngine , Long>{
	
	private QCseEngine qCseEngine; 
	
	
	JPAQueryFactory qf;
	
	public CseEngineService (){}
	
	@PostConstruct
	public void prepare(){
		 qf = new JPAQueryFactory(persistenceService.getEntityManager());
		qCseEngine = QCseEngine.cseEngine;
	}
	
	public void save(CseEngine t)
	{ 
		this.persistenceService.save(t);
	}
	
	public List<CseEngine> rangeOf(Integer offSet , Integer limit)
	{ 
		return this.findByRange(offSet, limit);
	}
	
	public void delete(CseEngine t)
	{ 
		CseEngine  toDelete = (CseEngine) qf.from(qCseEngine).where(qCseEngine.identification.eq(t.getDescription())).fetchOne();
		persistenceService.remove(toDelete);
	}
	
	public List<CseEngine> find(String description)
	{ 
	    return   qf.selectFrom(qCseEngine).where(qCseEngine.identification.like(new StringBuilder().append('%').append(description).append('%').toString())).fetch();
	}
	
}
