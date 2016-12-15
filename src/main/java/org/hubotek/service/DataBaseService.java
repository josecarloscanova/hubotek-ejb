package org.hubotek.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.hubotek.service.orm.PersistenceService;
import org.nanotek.Base;

import com.google.common.base.Optional;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.QMap;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.impl.JPAQueryFactory;

/**
 * http://stackoverflow.com/questions/3403909/get-generic-type-of-class-at-runtime
 * @author JoseCanova
 *
 * @param <T>
 * @param <K>
 */
public abstract class DataBaseService<T extends Base<K> , K extends Serializable> implements Service {

	private JPAQueryFactory  qf;

	public static final Integer DEFAULT_MAX_RECORDS = 100;
	
	@Inject @Named("persistenceService")
	protected PersistenceService persistenceService;
	
	public void deleteAll (){ 
		persistenceService.delete(getPersistentClass());
	}
	
	public  T findById(K id)
	{ 
		return persistenceService.find(getPersistentClass(), id);
	}
	
	public List<Map<Expression<?>,?>> applyMapProjection(EntityPathBase<T> entityPathBase ,QMap projection , Integer offset , Integer limit)
	{ 
		return qf.select(projection).from(entityPathBase).offset(Optional.fromNullable(offset).or(0)).limit(Optional.fromNullable(limit).or(DEFAULT_MAX_RECORDS)).fetch();
	}
	
	public List<T> findByRange(Integer offset , Integer limit)
	{ 
		return findByRange(getPersistentClass() , offset , limit);
	}
	
	
	public List<T> findByRange(Class<T> clazz , Integer offset , Integer limit)
	{ 
		return   persistenceService.<T>createQuery("Select r from " + clazz.getSimpleName() + " r order by r.id desc" , clazz).setFirstResult(Optional.fromNullable(offset).or(0)).setMaxResults(Optional.fromNullable(limit).or(DEFAULT_MAX_RECORDS)).getResultList();
	}
	
	private List<?> getTypeArguments()
	{ 
		return Arrays.asList(((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments());
	}
	
	@SuppressWarnings("unchecked")
	public Class<T> getPersistentClass()
	{ 
		return (Class<T>)getTypeArguments().get(0);
	}
	
}