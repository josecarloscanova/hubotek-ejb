package org.hubotek.service.http.header;

import java.util.ArrayList;
import java.util.List;

/**
 * representation of the http headers passed/received from a http request/response.
 * the header mean equals as two header instances having the same name.
 * @author JoseCanova
 *
 */
public class HttpHeader {

	private String name;
	
	private List<String> values; 
	
	public HttpHeader(){
		values = new ArrayList<String>();
	}
	
	public HttpHeader(String name, String value){
		values = new ArrayList<String>();
		values.add(value);
	}
	
	HttpHeader(String name, List<String> values) {
		super();
		this.name = name;
		this.values = values;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}
	
	public void addValue(String value)
	{ 
		values.add(value);
	}
	
	public void addValue(List<String> value)
	{ 
		values.addAll(value);
	}
	
	public String[] values()
	{ 
		return values.toArray(new String[values.size()]);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HttpHeader other = (HttpHeader) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
