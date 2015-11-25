/**
 * 
 */
package com.jd.syn.domain;

import java.util.List;
import java.util.Map;

/**
 * @author bailu
 *
 */
public class ApplierTable {

	private String srcTable;
	private String targetTable;
	private String type;
	private String memo;
	private String operate;
	private Boolean snap;
	public Boolean getSnap() {
		return snap;
	}
	public void setSnap(Boolean snap) {
		this.snap = snap;
	}
	private Boolean record;
	
	public Boolean getRecord() {
		return record;
	}
	public void setRecord(Boolean record) {
		this.record = record;
	}
	private ApplierRowKey rowKey;
	
	private List<ApplierColumn> listColumns;
	
	private Map<String, ApplierColumn> columnMap;
	
	public String getSrcTable() {
		return srcTable;
	}
	public void setSrcTable(String srcTable) {
		this.srcTable = srcTable;
	}
	public String getTargetTable() {
		return targetTable;
	}
	public void setTargetTable(String targetTable) {
		this.targetTable = targetTable;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getOperate() {
		return operate;
	}
	public void setOperate(String operate) {
		this.operate = operate;
	}
	public ApplierRowKey getRowKey() {
		return rowKey;
	}
	public void setRowKey(ApplierRowKey rowKey) {
		this.rowKey = rowKey;
	}
	public List<ApplierColumn> getListColumns() {
		return listColumns;
	}
	public void setListColumns(List<ApplierColumn> listColumns) {
		this.listColumns = listColumns;
	}
	public Map<String, ApplierColumn> getColumnMap() {
		return columnMap;
	}
	public void setColumnMap(Map<String, ApplierColumn> columnMap) {
		this.columnMap = columnMap;
	}
	
	
	
}
