/**
 * 
 */
package com.jd.syn.domain;

/**
 * @author bailu
 *
 */
public class ApplierColumn {

	private String srcColumn;
	private String targetColumn;
	private String srcType;
	private String targetType;
	private String cacheTable;
	private String cachekey;
	private String cacheValue;
	private String dateFormat;
	private String version;
	public String getSrcColumn() {
		return srcColumn;
	}
	public void setSrcColumn(String srcColumn) {
		this.srcColumn = srcColumn;
	}
	public String getTargetColumn() {
		return targetColumn;
	}
	public void setTargetColumn(String targetColumn) {
		this.targetColumn = targetColumn;
	}
	public String getSrcType() {
		return srcType;
	}
	public void setSrcType(String srcType) {
		this.srcType = srcType;
	}
	public String getTargetType() {
		return targetType;
	}
	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}
	public String getCacheTable() {
		return cacheTable;
	}
	public void setCacheTable(String cacheTable) {
		this.cacheTable = cacheTable;
	}
	public String getCachekey() {
		return cachekey;
	}
	public void setCachekey(String cachekey) {
		this.cachekey = cachekey;
	}
	public String getCacheValue() {
		return cacheValue;
	}
	public void setCacheValue(String cacheValue) {
		this.cacheValue = cacheValue;
	}
	public String getDateFormat() {
		return dateFormat;
	}
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
}
