/**
 * 
 */
package com.jd.syn.service;

/**
 * @author bailu
 *
 */
public interface Applier<T, V> {

	public void connect() throws Exception;

	public void disconnect();

	public void apply(T t, V v) throws Exception;
	
	
	
}
