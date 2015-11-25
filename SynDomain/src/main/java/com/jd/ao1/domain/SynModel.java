/**
 * 
 */
package com.jd.ao1.domain;

import java.io.Serializable;

/**
 * @author bailu
 *
 */
public class SynModel implements Serializable {

	private static final long serialVersionUID = -1524405852951002165L;
	
	private Integer id;
	private String taskId;
	private String taskName;
	private Integer taskType;
	private String taskDesc;
	
	private String modelName;
	private Integer modelType;
	
	private String tokenQueryKey;
	private String tokenModifyKey;
	private String tokenCallCode;
	private String tokenUuid;
	private String address;
	
	private Integer isStart;
	private Integer yn;
	
	
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public Integer getTaskType() {
		return taskType;
	}
	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}
	public String getTaskDesc() {
		return taskDesc;
	}
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public Integer getModelType() {
		return modelType;
	}
	public void setModelType(Integer modelType) {
		this.modelType = modelType;
	}
	public String getTokenQueryKey() {
		return tokenQueryKey;
	}
	public void setTokenQueryKey(String tokenQueryKey) {
		this.tokenQueryKey = tokenQueryKey;
	}
	public String getTokenModifyKey() {
		return tokenModifyKey;
	}
	public void setTokenModifyKey(String tokenModifyKey) {
		this.tokenModifyKey = tokenModifyKey;
	}
	public String getTokenCallCode() {
		return tokenCallCode;
	}
	public void setTokenCallCode(String tokenCallCode) {
		this.tokenCallCode = tokenCallCode;
	}
	public String getTokenUuid() {
		return tokenUuid;
	}
	public void setTokenUuid(String tokenUuid) {
		this.tokenUuid = tokenUuid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getIsStart() {
		return isStart;
	}
	public void setIsStart(Integer isStart) {
		this.isStart = isStart;
	}
	public Integer getYn() {
		return yn;
	}
	public void setYn(Integer yn) {
		this.yn = yn;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	

}
