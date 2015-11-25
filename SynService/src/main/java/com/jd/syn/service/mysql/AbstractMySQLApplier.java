/**
 * 
 */
package com.jd.syn.service.mysql;

import org.apache.commons.lang.StringUtils;

import com.jd.syn.domain.ApplierEnum;
import com.jd.syn.service.Applier;

/**
 * @author bailu
 *
 */
public abstract class AbstractMySQLApplier implements Applier<String, ApplierEnum> {

	@Override
	public void apply(String t, ApplierEnum v) throws Exception {
		applySQL(t, v);
	}
	
	@Override
	public void connect() throws Exception {}

	@Override
	public void disconnect() {}

	private boolean applySQL(String SQL, ApplierEnum ae) throws Exception {
		
		if (StringUtils.isNotEmpty(SQL)) {
			
			if (ae == ApplierEnum.INSERT) {
				insert(SQL);
			}
			
			if (ae == ApplierEnum.UPDATE) {
				update(SQL);
			}

			if (ae == ApplierEnum.DELETE) {
				delete(SQL);
			}
			
			if (ae == ApplierEnum.REPLACE) {
				replace(SQL);
			}
			
		}
		return true;
	}
	
	
	protected abstract void insert(String SQL) ;
	
	protected abstract void update(String SQL) ;
	
	protected abstract void delete(String SQL) ;
	
	protected abstract void replace(String SQL) ;

	
	
}
