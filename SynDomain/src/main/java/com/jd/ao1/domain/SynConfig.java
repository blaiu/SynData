/**
 * 
 */
package com.jd.ao1.domain;

import java.io.Serializable;

/**
 * @author bailu
 *
 */
public class SynConfig implements Serializable {

	private static final long serialVersionUID = -1239996058926672163L;

	private Integer id;
	private String taskId;
	private Integer taskType;
	private String cronExpression;
	private Integer maxTimes;
	private Integer maxNum;
	
	
	
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
	public Integer getMaxTimes() {
		return maxTimes;
	}
	public void setMaxTimes(Integer maxTimes) {
		this.maxTimes = maxTimes;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCronExpression() {
		return cronExpression;
	}
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}
	public Integer getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(Integer maxNum) {
		this.maxNum = maxNum;
	}
	
}
