/**
 * 
 */
package com.jd.syn.manager;

import java.util.List;
import java.util.Map;

import com.jd.ao1.domain.SynConfig;
import com.jd.ao1.domain.SynModel;
import com.jd.ao1.domain.SynRecord;

/**
 * @author bailu
 *
 */
public interface SynMySqlManager {

	public boolean executionSQL(String SQL);
	
	public boolean addModel(SynModel model);
	public int queryModelCount(Map<String, Object> map);
	public List<SynModel> queryModelList(Map<String, Object> map);
	public boolean removeModel(String taskId);
	public SynModel getModel(String taskId);
	public boolean modifyModel(SynModel model);
	
	public boolean removeRecord(List<Integer> idList);
	public boolean modifyRecord(List<Integer> idList);
	public int queryRecordCount(Map<String, Object> map);
	public List<SynRecord> queryRecordList(Map<String, Object> map);
	
	
	public SynConfig getConfig(String taskId);
	public boolean addConfig(SynConfig config);
	
	public boolean addRecord(List<SynRecord> list);
	
}
