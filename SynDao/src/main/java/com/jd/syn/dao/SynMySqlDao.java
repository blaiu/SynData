/**
 * 
 */
package com.jd.syn.dao;

import java.util.List;
import java.util.Map;

import com.jd.ao1.domain.SynConfig;
import com.jd.ao1.domain.SynModel;
import com.jd.ao1.domain.SynRecord;

/**
 * @author bailu
 *
 */
public interface SynMySqlDao {

	public boolean executionSQL(String SQL);
	
	public boolean addModel(SynModel model);
	public boolean removeModel(String taskId);
	public int queryModelCount(Map<String, Object> map);
	public List<SynModel> querySynModel(Map<String, Object> map);
	public SynModel getModel(String taskId);
	public boolean modifyModel(SynModel model);
	public boolean modifyRecord(List<Integer> idList);
	
	
	public SynConfig getConfig(String taskId);
	public boolean addConfig(SynConfig config);
	public boolean removeConfig(String taskId);
	
	public boolean addRecord(List<SynRecord> list);
	
	public List<SynConfig> querySynConfig();
	
	
	public boolean removeRecord(List<Integer> idList);
	public int queryRecordCount(Map<String, Object> map);
	public List<SynRecord> querySynRecord(Map<String, Object> map);
	
	
}
