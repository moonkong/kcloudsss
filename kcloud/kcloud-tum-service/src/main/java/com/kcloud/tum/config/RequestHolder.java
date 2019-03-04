package com.kcloud.tum.config;

public class RequestHolder {

	 private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();
	 
	    public static void setId(Long id) {
	        requestHolder.set(id);
	    }
	 
	    public static Long getId() {
	        return requestHolder.get();
	    }
	 
	    public static void remove() {
	        requestHolder.remove();
	    } 
}
