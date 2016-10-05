package org.hubotek.service.data;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.TypedQuery;

import org.hubotek.model.feed.FeedUrl;
import org.hubotek.service.Service;
import org.hubotek.service.orm.PersistenceService;

@Named
public class FeedService implements Service {

	@Inject 
	private PersistenceService persistenceService; 
	
	public FeedUrl saveFeedUrl(FeedUrl feedUrl)
	{ 
		return persistenceService.save(feedUrl);
	}
	
	public FeedUrl findById(Long id)
	{ 
		return persistenceService.find(FeedUrl.class, id);
	}
	
	public FeedUrl findByName(String name)
	{ 
		TypedQuery<FeedUrl> query =  persistenceService.createQuery("Select fu from FeedUrl fu where fu.name = :yours" , FeedUrl.class); 
		query.setParameter("yours", name);
		return query.getSingleResult();
	}
	
	public void deleteAll ()
	{ 
		persistenceService.delete(FeedUrl.class);
	}
}
