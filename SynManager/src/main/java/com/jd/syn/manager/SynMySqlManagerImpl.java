/**
 * 
 */
package com.jd.syn.manager;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.jd.ao1.domain.SynConfig;
import com.jd.ao1.domain.SynModel;
import com.jd.ao1.domain.SynRecord;
import com.jd.bk.common.manager.mybatis.BaseManager;
import com.jd.syn.dao.SynMySqlDao;

/**
 * @author bailu
 *
 */
public class SynMySqlManagerImpl extends BaseManager implements SynMySqlManager {

	@Resource
	private SynMySqlDao synMySqlDao;
	
	@Override
	public boolean executionSQL(final String SQL) {
		final boolean result[] = { true };
        try {
            TransactionTemplate template = this.getDataSourceTransactionManager();
            template.execute(new TransactionCallbackWithoutResult() {
                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                	try {
                		synMySqlDao.executionSQL(SQL);
                    } catch(DataAccessException e) {
                    	e.printStackTrace();
                        result[0] = false;
                        transactionStatus.setRollbackOnly();
                    }
                }
            });
        } catch (Exception e) {
            result[0] = false;
        }
        return result[0];
	}

	@Override
	public boolean addModel(final SynModel model) {
		final boolean result[] = { true };
        try {
            TransactionTemplate template = this.getDataSourceTransactionManager();
            template.execute(new TransactionCallbackWithoutResult() {
                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                	try {
                		synMySqlDao.addModel(model);
                    } catch(DataAccessException e) {
                    	e.printStackTrace();
                        result[0] = false;
                        transactionStatus.setRollbackOnly();
                    }
                }
            });
        } catch (Exception e) {
            result[0] = false;
        }
        return result[0];
	}

	@Override
	public boolean addConfig(final SynConfig config) {
		final boolean result[] = { true };
        try {
            TransactionTemplate template = this.getDataSourceTransactionManager();
            template.execute(new TransactionCallbackWithoutResult() {
                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                	try {
                		synMySqlDao.addConfig(config);
                    } catch(DataAccessException e) {
                    	e.printStackTrace();
                        result[0] = false;
                        transactionStatus.setRollbackOnly();
                    }
                }
            });
        } catch (Exception e) {
            result[0] = false;
        }
        return result[0];
	}

	@Override
	public boolean addRecord(final List<SynRecord> list) {
		final boolean result[] = { true };
        try {
            TransactionTemplate template = this.getDataSourceTransactionManager();
            template.execute(new TransactionCallbackWithoutResult() {
                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                	try {
                		synMySqlDao.addRecord(list);
                    } catch(DataAccessException e) {
                    	e.printStackTrace();
                        result[0] = false;
                        transactionStatus.setRollbackOnly();
                    }
                }
            });
        } catch (Exception e) {
            result[0] = false;
        }
        return result[0];
	}

	@Override
	public int queryModelCount(Map<String, Object> map) {
		return synMySqlDao.queryModelCount(map);
	}

	@Override
	public List<SynModel> queryModelList(Map<String, Object> map) {
		return synMySqlDao.querySynModel(map);
	}
	
	@Override
	public int queryRecordCount(Map<String, Object> map) {
		return synMySqlDao.queryRecordCount(map);
	}

	@Override
	public List<SynRecord> queryRecordList(Map<String, Object> map) {
		return synMySqlDao.querySynRecord(map);
	}

	@Override
	public boolean removeRecord(final List<Integer> idList) {
		final boolean result[] = { true };
		try {
			TransactionTemplate template = this.getDataSourceTransactionManager();
			template.execute(new TransactionCallbackWithoutResult() {
				protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
					try {
						synMySqlDao.removeRecord(idList);
					} catch(DataAccessException e) {
						e.printStackTrace();
						result[0] = false;
						transactionStatus.setRollbackOnly();
					}
				}
			});
		} catch (Exception e) {
			result[0] = false;
		}
		return result[0];
	}
	
	@Override
	public boolean removeModel(final String taskId) {
		final boolean result[] = { true };
        try {
            TransactionTemplate template = this.getDataSourceTransactionManager();
            template.execute(new TransactionCallbackWithoutResult() {
                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                	try {
                		synMySqlDao.removeModel(taskId);
                		synMySqlDao.removeConfig(taskId);
                    } catch(DataAccessException e) {
                    	e.printStackTrace();
                        result[0] = false;
                        transactionStatus.setRollbackOnly();
                    }
                }
            });
        } catch (Exception e) {
            result[0] = false;
        }
        return result[0];
	}

	@Override
	public SynConfig getConfig(String taskId) {
		return synMySqlDao.getConfig(taskId);
	}

	@Override
	public SynModel getModel(String taskId) {
		return synMySqlDao.getModel(taskId);
	}

	@Override
	public boolean modifyModel(final SynModel model) {
		final boolean result[] = { true };
        try {
            TransactionTemplate template = this.getDataSourceTransactionManager();
            template.execute(new TransactionCallbackWithoutResult() {
                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                	try {
                		synMySqlDao.modifyModel(model);
                    } catch(DataAccessException e) {
                    	e.printStackTrace();
                        result[0] = false;
                        transactionStatus.setRollbackOnly();
                    }
                }
            });
        } catch (Exception e) {
            result[0] = false;
        }
        return result[0];
	}

	@Override
	public boolean modifyRecord(final List<Integer> idList) {
		final boolean result[] = { true };
        try {
            TransactionTemplate template = this.getDataSourceTransactionManager();
            template.execute(new TransactionCallbackWithoutResult() {
                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                	try {
                		synMySqlDao.modifyRecord(idList);
                    } catch(DataAccessException e) {
                    	e.printStackTrace();
                        result[0] = false;
                        transactionStatus.setRollbackOnly();
                    }
                }
            });
        } catch (Exception e) {
            result[0] = false;
        }
        return result[0];
	}

}
