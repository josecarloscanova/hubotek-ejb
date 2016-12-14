package org.hubotek;

@FunctionalInterface
public interface Reference <T,I> {

	T reference(I i);
	
}
