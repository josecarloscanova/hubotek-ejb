package org.hubotek.test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

public class BasePersistenceTestClass extends BaseTestClass{

	@PersistenceContext
    protected EntityManager entityManager;
    
    @Inject
    protected UserTransaction utx;
    
    
}
