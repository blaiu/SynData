/**
 * 
 */
package com.jd.syn.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jd.ao1.domain.SynConfig;
import com.jd.ao1.domain.SynModel;
import com.jd.ao1.domain.SynRecord;
import com.jd.bk.common.dao.mybatis.BaseDao;
import com.jd.syn.utils.ConstantsUtil;

/**
 * @author bailu
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class SynMySqlDaoImpl extends BaseDao implements SynMySqlDao {

	@Override
	public boolean executionSQL(String SQL) {
		return update("MySQLApplierMapper.executionSQL", SQL);
	}

	@Override
	public List<SynConfig> querySynConfig() {
		return queryForList("MySQLApplierMapper.querySynConfig");
	}
	
	@Override
	public int queryModelCount(Map<String, Object> map) {
		if(ConstantsUtil.QUERY_IS_FRIST) {
			ConstantsUtil.QUERY_IS_FRIST = false;
			update("MySQLApplierMapper.initModifySynModel", "");
		}
		
		Object obj = queryForObject("MySQLApplierMapper.querySynModelCount", map);
		if (null != obj) {
			return (Integer) obj;
		} else {
			return 0;
		}
	}

	@Override
	public List<SynModel> querySynModel(Map<String, Object> map) {
		return queryForList("MySQLApplierMapper.querySynModel", map);
	}

	@Override
	public boolean addModel(SynModel model) {
		return insert("MySQLApplierMapper.addSynModel", model);
	}
	
	@Override
	public boolean removeModel(String taskId) {
		return delete("MySQLApplierMapper.deleteSynModel", taskId);
	}
	
	@Override
	public boolean removeConfig(String taskId) {
		return delete("MySQLApplierMapper.deleteSynConfig", taskId);
	}
	
	@Override
	public SynModel getModel(String taskId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("taskId", taskId);
		map.put("startRow", 0);
		map.put("pageSize", 1);
		List<SynModel> list = querySynModel(map);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public boolean modifyModel(SynModel model) {
		return update("MySQLApplierMapper.modifySynModel", model);
	}
	
	@Override
	public int queryRecordCount(Map<String, Object> map) {
		Object obj = queryForObject("MySQLApplierMapper.querySynRecordCount", map);
		if (null != obj) {
			return (Integer) obj;
		} else {
			return 0;
		}
	}
	
	@Override
	public List<SynRecord> querySynRecord(Map<String, Object> map) {
		return queryForList("MySQLApplierMapper.querySynRecord", map);
	}

	@Override
	public SynConfig getConfig(String taskId) {
		Object obj = queryForObject("MySQLApplierMapper.querySynConfig", taskId);
		if (null != obj) {
			return (SynConfig) obj;
		}
		return null;
	}
	
	@Override
	public boolean addConfig(SynConfig config) {
		if(null == getConfig(config.getTaskId())) {
			return insert("MySQLApplierMapper.addSynConfig", config);
		} else {
			return update("MySQLApplierMapper.modifySynConfig", config);
		}
	}

	@Override
	public boolean addRecord(List<SynRecord> list) {
		return insert("MySQLApplierMapper.addSynRecord", list);
	}

	@Override
	public boolean removeRecord(List<Integer> idList) {
		return delete("MySQLApplierMapper.deleteSynRecord", idList);
	}

	@Override
	public boolean modifyRecord(List<Integer> idList) {
		return update("MySQLApplierMapper.updateSynRecord", idList);
	}



}
