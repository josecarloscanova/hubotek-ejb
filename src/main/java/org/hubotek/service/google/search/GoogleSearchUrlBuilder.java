package org.hubotek.service.google.search;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.hubotek.Builder;

@Named("googleSearchUrlBuilder")
public class GoogleSearchUrlBuilder implements Builder<String>{
	
	private EnumMap<ParameterEnum , String> parameters = new EnumMap<ParameterEnum , String>(ParameterEnum.class);
	
	public GoogleSearchUrlBuilder(){}
	
	@PostConstruct
	public void prepare()
	{ 
		parameters = new EnumMap<ParameterEnum , String>(ParameterEnum.class);
	}
	
	public GoogleSearchUrlBuilder withSearchTerms(String searchTerms)
	{ 
		parameters.put(ParameterEnum.SEARCH_TERM, searchTerms);
		return this;
	}
	
	public GoogleSearchUrlBuilder withNum(Integer num)
	{ 
		parameters.put(ParameterEnum.NUM, Optional.ofNullable(num).orElse(10).toString());
		return this;
	}

	public GoogleSearchUrlBuilder withStartIndex(Integer startIndex)
	{ 
		parameters.put(ParameterEnum.START_INDEX, Optional.ofNullable(startIndex).orElse(1).toString());
		return this;
	}
	
	public GoogleSearchUrlBuilder withLanguage(String language)
	{ 
		parameters.put(ParameterEnum.LANGUAGE, Optional.ofNullable(language).orElse("en-US"));
		return this;
	}
	
	public GoogleSearchUrlBuilder withSafe (String safe)
	{ 
		parameters.put(ParameterEnum.SAFE, Optional.ofNullable(safe).orElse("off"));
		return this;
	}
	
	public GoogleSearchUrlBuilder withCx(String cx)
	{ 
		parameters.put(ParameterEnum.CX, Optional.ofNullable(cx).orElse("insert-cx"));
		return this;
	}
	
	public GoogleSearchUrlBuilder withCref(String cref)
	{ 
		parameters.put(ParameterEnum.CREF, Optional.ofNullable(cref).orElse("cref"));
		return this;
	}
	
	public GoogleSearchUrlBuilder withSort(String sort)
	{ 
		parameters.put(ParameterEnum.SORT, Optional.ofNullable(sort).orElse("sort"));
		return this;
	}
	
	public GoogleSearchUrlBuilder withAlt(String alt)
	{ 
		parameters.put(ParameterEnum.ALT, Optional.ofNullable(alt).orElse("json"));
		return this;
	}

	public GoogleSearchUrlBuilder withCountry(String country)
	{ 
		parameters.put(ParameterEnum.COUNTRY , Optional.ofNullable(country).orElse("countryUS"));
		return this;
	}
	
	public GoogleSearchUrlBuilder withKey(String key)
	{ 
		parameters.put(ParameterEnum.KEY , Optional.ofNullable(key).orElse("insert-your-key"));
		return this;
	}
	
	//Check for a Guava helper
	@Override
	public String build() {
		List<String> queryStringList = new ArrayList<String>();
		parameters.keySet().stream().forEach((k)->queryStringList.add(k.getParameterValue()+"="+ parameters.get(k)));
		return queryStringList.stream().reduce((s , t) -> s +="&"+t).get();
	}
	
}
