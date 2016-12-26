package org.hubotek.service.google.search;

/*provide the header and query string attributes for the custom search*/
public enum ParameterEnum{ 
		
		SEARCH_TERM ("q"), 
		NUM ("count"), 
		START_INDEX ("start"),
		LANGUAGE ("language"), 
		SAFE ("safe"),
		CX ("cx"),
		CREF ("cref"),
		SORT ("sort"),
		FILTER ("filter"), 
		ALT ("output"),
		COUNTRY("cr"),
		KEY("key");
		
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