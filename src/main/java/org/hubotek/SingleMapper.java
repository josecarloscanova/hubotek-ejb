package org.hubotek;

@FunctionalInterface
public interface SingleMapper <T,O>{

	T from(O origin);
	
}
