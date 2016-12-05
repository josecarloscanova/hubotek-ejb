package org.hubotek.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.hubotek.service.orm.PersistenceService;
import org.nanotek.Base;

import com.google.common.base.Optional;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.QMap;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.impl.JPAQueryFactory;

public abstract class DataBaseService<T extends Base<K> , K extends Serializable> implements Service {

	private JPAQueryFactory  qf;

	public static final Integer DEFAULT_MAX_RECORDS = 100;
	
	@Inject 
	protected PersistenceService persistenceService; 
	
	public abstract void deleteAll ();
	
	public  abstract T findById(K id);
	
	public List<Map<Expression<?>,?>> applyMapProjection(EntityPathBase<T> entityPathBase ,QMap projection , Integer offset , Integer offSet)
	{ 
		return qf.select(projection).from(entityPathBase).limit(100).fetch();
	}
	
	public List<T> findByRange(Class<T> clazz , Integer offset , Integer limit)
	{ 
		return   persistenceService.<T>createQuery("Select r from " + clazz.getSimpleName() + " r order by r.id desc" , clazz).setFirstResult(Optional.fromNullable(offset).or(0)).setMaxResults(Optional.fromNullable(limit).or(DEFAULT_MAX_RECORDS)).getResultList();
	}
	
}
