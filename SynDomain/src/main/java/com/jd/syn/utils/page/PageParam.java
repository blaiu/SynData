/**
 * 
 */
package com.jd.syn.utils.page;

import java.io.Serializable;

/**
 * @author bailu
 *
 */
public class PageParam implements Serializable  {

	private static final long serialVersionUID = -6117301687370704493L;

	private Integer pageNo;
	
	private String taskId;
	
	private String recordId;
	
	private Integer taskType;
	
	private Integer modelType;
	
	private Integer maxTimes;
	
	private String keyWord;

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public Integer getTaskType() {
		return taskType;
	}

	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}

	public Integer getModelType() {
		return modelType;
	}

	public void setModelType(Integer modelType) {
		this.modelType = modelType;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public Integer getMaxTimes() {
		return maxTimes;
	}

	public void setMaxTimes(Integer maxTimes) {
		this.maxTimes = maxTimes;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	
	
	
}
