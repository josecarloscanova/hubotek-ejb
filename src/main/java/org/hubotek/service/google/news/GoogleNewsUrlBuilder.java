package org.hubotek.service.google.news;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.hubotek.Builder;

@Named("googleNewsUrlBuilder")
public class GoogleNewsUrlBuilder implements Builder<String>{

	private final String baseUrl = "https://news.google.com/news"; 
	private EnumMap<GoogleNewsUrlParametersEnum,String> urlParameterMap;
	
	public GoogleNewsUrlBuilder(){}
	
	public GoogleNewsUrlBuilder withParameter(GoogleNewsUrlParametersEnum name , String value)
	{ 
		if (notEmpty(value))
			put(name, value);
		return this;
	}
	
	@PostConstruct
	public void prepare()
	{ 
		urlParameterMap = new EnumMap<GoogleNewsUrlParametersEnum,String>(GoogleNewsUrlParametersEnum.class);
	}
	
	private void put(GoogleNewsUrlParametersEnum parameter , String value)
	{ 
		urlParameterMap.put(parameter, value);
	}
	
	private boolean notEmpty(String val)
	{ 
		return (val != null && val.length() > 0) ? true : false;
	}
	
	public List<String> prepareParameterList()
	{
		List<String> paramList = new ArrayList<String>();
		for (GoogleNewsUrlParametersEnum parameterKey : urlParameterMap.keySet())
		{
			StringBuilder param = new StringBuilder();
			param.append(parameterKey.getUrlParameter()).append("=").append(urlParameterMap.get(parameterKey));
			paramList.add(param.toString());
		}
		return paramList;
	}
	
	
	public String build()
	{ 
		StringBuilder sb = new StringBuilder();
		Iterator<String> parameterIterator = prepareParameterList().iterator();
		while(parameterIterator.hasNext())
		{ 
			sb.append(parameterIterator.next());
			if (parameterIterator.hasNext())
				sb.append('&');
		}
		sb.insert(0, baseUrl).insert(baseUrl.length(), '?');
		return sb.toString();
	}

}
