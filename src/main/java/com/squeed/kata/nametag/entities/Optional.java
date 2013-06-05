package com.squeed.kata.nametag.entities;

public class Optional<T> {

	private final T object;
	
	private Optional(T object){
		this.object = object;
	}
	
	public boolean hasValue() {
		return object != null;
	}

	public T get() {
		if (object == null) {
			throw new IllegalStateException("This nullable has no value to offer - use .hasValue");
		}
		return object;
	}

}
