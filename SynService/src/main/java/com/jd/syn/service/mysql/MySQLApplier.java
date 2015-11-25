/**
 * 
 */
package com.jd.syn.service.mysql;

/**
 * @author bailu
 *
 */
public interface MySQLApplier<T> {

	public boolean receiveBeanLog (T t);
	
}
