package com.jd.syn.service.mysql;

import com.jd.syn.manager.SynMySqlManager;

@SuppressWarnings("hiding")
public class MySQLApplierImpl<Object, ApplierEnum> extends AbstractMySQLApplier implements MySQLApplier<Object>  {

	private SynMySqlManager synMySqlManager;
	
	@Override
	protected void insert(String SQL) {
		synMySqlManager.executionSQL(SQL);
	}

	@Override
	protected void update(String SQL) {
		synMySqlManager.executionSQL(SQL);
	}

	@Override
	protected void delete(String SQL) {
		synMySqlManager.executionSQL(SQL);
	}

	@Override
	protected void replace(String SQL) {
		synMySqlManager.executionSQL(SQL);
	}

	@Override
	public boolean receiveBeanLog(Object t) {
		String SQL = (String) t;
		boolean flag = false;
		try {
			apply(SQL, com.jd.syn.domain.ApplierEnum.INSERT);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	

}
