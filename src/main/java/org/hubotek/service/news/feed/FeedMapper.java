package org.hubotek.service.news.feed;

import org.hubotek.SingleMapper;
import org.hubotek.model.news.feed.FeedSource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel="cdi")
@FunctionalInterface
public interface FeedMapper extends SingleMapper<Feed,FeedSource>{

	@Override
	@Mappings({
		@Mapping(source="feedSource.id" , target="feedId"),
		@Mapping(source="feedSource.feedUrl.url" , target="feedUrl")
	})
	Feed from(FeedSource feedSource);
	
}
