/**
 * 
 */
package com.jd.ao1.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author bailu
 *
 */
public class SynRecord implements Serializable {

	private static final long serialVersionUID = 90675555361235641L;

	private Integer id;
	private String taskId;
	private Integer taskType;
	private Integer Times;
	private Date startTime;
	private String recordId;
	private String recordDesc;
	private Integer queryCount;
	
	private String orgNo;
	private String distributeNo;
	private String warehouseNo;
    private String businessNo;
    private String businessName;
    private String taskNo;
    private Date createTime;
    private String createdUser;
    private Date updateTime;
    private int reDoQty;
	
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public Integer getTimes() {
		return Times;
	}
	public void setTimes(Integer times) {
		Times = times;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getRecordDesc() {
		return recordDesc;
	}
	public void setRecordDesc(String recordDesc) {
		this.recordDesc = recordDesc;
	}
	public Integer getTaskType() {
		return taskType;
	}
	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQueryCount() {
		return queryCount;
	}
	public void setQueryCount(Integer queryCount) {
		this.queryCount = queryCount;
	}
	public String getOrgNo() {
		return orgNo;
	}
	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}
	public String getDistributeNo() {
		return distributeNo;
	}
	public void setDistributeNo(String distributeNo) {
		this.distributeNo = distributeNo;
	}
	public String getWarehouseNo() {
		return warehouseNo;
	}
	public void setWarehouseNo(String warehouseNo) {
		this.warehouseNo = warehouseNo;
	}
	public String getBusinessNo() {
		return businessNo;
	}
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getTaskNo() {
		return taskNo;
	}
	public void setTaskNo(String taskNo) {
		this.taskNo = taskNo;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public int getReDoQty() {
		return reDoQty;
	}
	public void setReDoQty(int reDoQty) {
		this.reDoQty = reDoQty;
	}
	
	
	
}
