package org.hubotek.service.google.search;

/*provide the header and query string attributes for the custom search*/
public enum ParameterEnum{ 
		
		SEARCH_TERM ("searchTerms"), 
		NUM ("num"), 
		START_INDEX ("startIndex"),
		LANGUAGE ("language"), 
		SAFE ("safe"),
		CX ("cx"),
		CREF ("cref"),
		SORT ("sort"),
		FILTER ("filter"), 
		ALT ("alt"),
		COUNTRY("cr");
		
		private String parameterValue;
		
		private ParameterEnum(String parameter)
		{ 
			this.parameterValue = parameter;
		}
		
		public String getParameterValue()
		{ 
			return parameterValue;
		}
	}