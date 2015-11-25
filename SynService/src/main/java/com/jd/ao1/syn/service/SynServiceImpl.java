/**
 * 
 */
package com.jd.ao1.syn.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import com.jd.ao1.domain.SynConfig;
import com.jd.ao1.domain.SynModel;
import com.jd.ao1.domain.SynRecord;
import com.jd.syn.manager.SynMySqlManager;
import com.jd.syn.utils.page.Pagination;

/**
 * @author bailu
 *
 */
public class SynServiceImpl implements SynService {

	@Resource
	private SynMySqlManager synMySqlManager;
	
	@Override
	public boolean addModel(SynModel model) {
		return synMySqlManager.addModel(model);
	}

	@Override
	public boolean addConfig(SynConfig config) {
		return synMySqlManager.addConfig(config);
	}

	@Override
	public Pagination queryModelPage(Map<String, Object> map, int pageNo, int pageSize) {
		int total = synMySqlManager.queryModelCount(map);
		int endIndex = pageNo * pageSize;
		if (endIndex > total) {
			endIndex = total;
		}
		map.put("startRow", (pageNo - 1) * pageSize);
		map.put("pageSize", pageSize);
		List<SynModel> list = synMySqlManager.queryModelList(map);
		 Pagination p  = new Pagination(pageNo, pageSize, total, list);
		 String taskIdParam = "?taskId=" + ((null != map.get("taskId"))?map.get("taskId").toString():"");
		 String taskTypeParam = "&taskType=" + ((null != map.get("taskType"))?map.get("taskType").toString():"");
		 String taskNameParam = "&taskName=" + ((null != map.get("taskName"))?map.get("taskName").toString():"");
		 String modelTypeParam = "&modelType=" + ((null != map.get("modelType"))?map.get("modelType").toString():"");
		 p.setUrl(map.get("path").toString() + taskIdParam + taskTypeParam + taskNameParam + modelTypeParam);
		 return p;
	}
	
	@Override
	public List<SynModel> queryModel(Map<String, Object> map) {
		map.put("startRow", 0);
		map.put("pageSize", 1000);
		return synMySqlManager.queryModelList(map);
	}
	
	@Override
	public List<SynRecord> queryRecord(Map<String, Object> map) {
		map.put("startRow", 0);
		map.put("pageSize", 100);
		return synMySqlManager.queryRecordList(map);
	}
	
	@Override
	public Pagination queryRecordPage(Map<String, Object> map, int pageNo, int pageSize) {
		int total = synMySqlManager.queryRecordCount(map);
		int endIndex = pageNo * pageSize;
		if (endIndex > total) {
			endIndex = total;
		}
		map.put("startRow", (pageNo - 1) * pageSize);
		map.put("pageSize", pageSize);
		List<SynRecord> list = synMySqlManager.queryRecordList(map);
		Pagination p  = new Pagination(pageNo, pageSize, total, list);
		String taskIdParam = "?taskId=" + ((null != map.get("taskId"))?map.get("taskId").toString():"");
		String taskTypeParam = "&taskType=" + ((null != map.get("taskType"))?map.get("taskType").toString():"");
		String taskNameParam = "&maxTimes=" + ((null != map.get("maxTimes"))?map.get("maxTimes").toString():"");
		String modelTypeParam = "&recordId=" + ((null != map.get("recordId"))?map.get("recordId").toString():"");
		p.setUrl(map.get("path").toString() + taskIdParam + taskTypeParam + taskNameParam + modelTypeParam);
		return p;
	}
	
	@Override
	public boolean removeModel(String taskId) {
		if (!StringUtils.isEmpty(taskId)) {
			return synMySqlManager.removeModel(taskId);
		}
		return false;
	}

	@Override
	public SynConfig getConfig(String taskId) {
		return synMySqlManager.getConfig(taskId);
	}

	@Override
	public SynModel getModel(String taskId) {
		return synMySqlManager.getModel(taskId);
	}

	@Override
	public boolean modifyModel(SynModel model) {
		return synMySqlManager.modifyModel(model);
	}

	@Override
	public boolean addRecord(List<SynRecord> list) {
		return synMySqlManager.addRecord(list);
	}

	@Override
	public boolean removeRecord(List<Integer> idList) {
		return synMySqlManager.removeRecord(idList);
	}

	@Override
	public boolean modifyRecord(List<Integer> idList) {
		return synMySqlManager.removeRecord(idList);
	}

}
