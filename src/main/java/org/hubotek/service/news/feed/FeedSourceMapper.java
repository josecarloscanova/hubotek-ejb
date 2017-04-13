package org.hubotek.service.news.feed;

import org.hubotek.SingleMapper;
import org.hubotek.model.news.feed.FeedSource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel="cdi")
public interface FeedSourceMapper extends SingleMapper<FeedSource,Feed>{

	@Override
	@Mappings({
				@Mapping(source="feed.feedId" , target="id"),
				@Mapping(source="feed.description" , target="description"),
				@Mapping(source="feed.feedUrl" , target="feed.feedUrl.url"),
				@Mapping(source="feed.feedUrlDescription" , target="feed.feedUrl.description")
			  }
			)
	FeedSource from(Feed feed);
	
}
