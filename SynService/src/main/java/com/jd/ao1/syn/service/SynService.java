/**
 * 
 */
package com.jd.ao1.syn.service;

import java.util.List;
import java.util.Map;

import com.jd.ao1.domain.SynConfig;
import com.jd.ao1.domain.SynModel;
import com.jd.ao1.domain.SynRecord;
import com.jd.syn.utils.page.Pagination;

/**
 * @author bailu
 *
 */
public interface SynService {

	public boolean addModel(SynModel model);
	public Pagination queryModelPage(Map<String, Object> map, int pageNo, int pageSize);
	public Pagination queryRecordPage(Map<String, Object> map, int pageNo, int pageSize);
	
	public List<SynModel> queryModel(Map<String, Object> map);
	public List<SynRecord> queryRecord(Map<String, Object> map);
	public boolean addRecord(List<SynRecord> list);
	
	public boolean removeRecord(List<Integer> idList);
	
	public boolean modifyRecord(List<Integer> idList);
	
	public boolean removeModel(String ids);
	public SynModel getModel(String taskId);
	public boolean modifyModel(SynModel model);
	
	public SynConfig getConfig(String taskId);
	public boolean addConfig(SynConfig config);
}
