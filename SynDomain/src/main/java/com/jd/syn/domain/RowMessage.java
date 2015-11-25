//package com.jd.syn.domain;
//
//import java.io.Serializable;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//import java.sql.Timestamp;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@SuppressWarnings("serial")
//public class RowMessage implements Serializable {
//	
//	/** 时间 */
//	private Integer dataFrom;
//	
//	/** 表名 */
//	private HashMap<String, String> header = new HashMap<String, String>();
//    
//	/** 表修改后的列信息 */
//    private HashMap<String, Object> columnData = new HashMap<String, Object>();
//    
//    /** 表修改前的列信息 */
//    private Map<String, Object> beforeColumnData = new HashMap<String, Object>();
//    
//    /** 1：INSERT，2：UPDATE， 3，DELETE */
//    private Integer msgType = -1;
//    
//    /** 表的执行时间 */
//    private Date timestamp; 
//    
//    /** don't known */
//    private Long levelDBKey;
//    
//    
//    
//	public RowMessage(){}
//    
//    public RowMessage(CanalEntry.RowData rowData, String tableName, CanalEntry.Entry entry) {
//    	
//    	
//        //取得操作类型
//    	dataFrom =DataFrom.BINLOG.getValue();
//    	timestamp = new Date(entry.getHeader().getExecuteTime());
//    	msgType = entry.getHeader().getEventType().getNumber();
//    	List<CanalEntry.Column> srcColumns = rowData.getAfterColumnsList();
//    	switch(msgType){
//    	case 1://INSERT_VALUE
//    		for (CanalEntry.Column column : srcColumns) {
//                if (!column.getIsNull()) {
//                    String fieldName = column.getName().toUpperCase();
//                    columnData.put(fieldName, column.getValue());
//                    beforeColumnData.put(fieldName, column.getValue());
//                }
//            }
//    		header.put("ID", this.columnData.get("ID")+"");
//    		break;
//    	case 2://UPDATE_VALUE
//    		
//    		List<Column> beforeColumn = rowData.getBeforeColumnsList();
//    		for(Column c : beforeColumn){
//    			 String fieldName = c.getName().toUpperCase();
//    			beforeColumnData.put(fieldName, c.getValue());
//    		}
//    		
//    		for (CanalEntry.Column column : srcColumns) {
//                if (!column.getIsNull()) {
//                    String fieldName = column.getName().toUpperCase();
//                    columnData.put(fieldName, column.getValue());
//                }
//            }
//    		header.put("ID", this.columnData.get("ID")+"");
//    		break;
//    		
//    	case 3://DELETE_VALUE
//    		srcColumns = rowData.getBeforeColumnsList();
//    		for (CanalEntry.Column column : srcColumns) {
//                if (!column.getIsNull()) {
//                    String fieldName = column.getName().toUpperCase();
//                    this.beforeColumnData.put(fieldName, column.getValue());
//                }
//            }
//    		header.put("ID", this.beforeColumnData.get("ID")+"");
//    		break;
//    	}
//        header.put("TABLE_NAME", tableName);
//        header.put("DB_NAME", entry.getHeader().getSchemaName().toUpperCase());
//        
//    }
//
//
//    public RowMessage(ResultSet rs) {
//    	
//    	
//        try {
//        	dataFrom = DataFrom.SQL.getValue();
//            ResultSetMetaData rsd = rs.getMetaData();
//            int colCount = rsd.getColumnCount();
//            for (int i = 1; i <= colCount; i++) {
//                columnData.put(rsd.getColumnName(i).toUpperCase(), rs.getObject(i));
//            }
//            
//            header.put("TABLE_NAME", rsd.getTableName(1));
//            header.put("ID", this.columnData.get("ID")+"");
//            
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        
//    }
//
//    public int getMsgType() {
//        return msgType;
//    }
//    
//    @JsonIgnore
//    public String getTableName () {
//    	return header.get("TABLE_NAME");
//    }
//    
//    @JsonIgnore
//    public String getMsgTypeName() {
//    	
//        String ret = "UNKNOWN";
//        switch (msgType) {
//            case CanalEntry.EventType.INSERT_VALUE:
//                ret = "INSERT";
//                break;
//            case CanalEntry.EventType.UPDATE_VALUE:
//                ret = "UPDATE";
//                break;
//            case CanalEntry.EventType.DELETE_VALUE:
//                ret = "DELETE";
//                break;
//        }
//        return ret;
//    }
//
//    public String getHeader(String headName) {
//        return header.get(headName);
//    }
//
//    public HashMap<String, Object> getColumnData() {
//        return columnData;
//    }
//
//    
//    public String getString(String colName) {
//        Object value = columnData.get(colName);
//    	if(value== null) {
//    		return "";//
//    	} else if (String.class.isAssignableFrom(value.getClass())) {
//    		return (String)value;
//    	} else {
//    		return String.valueOf(value);
//    	}
//    }
//    
//    
//    public Timestamp getTimeStamp(String colName) {
//    	Object value = columnData.get(colName);
//    	if(value== null) {
//    		return null;
//    	} else if (Timestamp.class.isAssignableFrom(value.getClass())) {
//    		return (Timestamp)value;
//    	} else {
//    		return (Timestamp) ConvertUtils.convert(value, Timestamp.class);
//    	}
//    }
//    
//    public Object getObject(String colName) {
//        return columnData.get(colName);
//    }
//
//    @Override
//    public String toString() {
//        StringBuffer sbuf = new StringBuffer();
//        for (String field : columnData.keySet()) {
//            sbuf.append(" " + field + ":" + columnData.get(field));
//        }
//
//        return sbuf.toString();
//    }
//
//    public boolean isContainKey(String key) {
//        return this.columnData.containsKey(key);
//    }
//
//
//	public HashMap<String, String> getHeader() {
//		return header;
//	}
//
//
//	public void setHeader(HashMap<String, String> header) {
//		this.header = header;
//	}
//
//
//	public void setColumnData(HashMap<String, Object> columnData) {
//		this.columnData = columnData;
//	}
//	
//	public int getType() {
//		return msgType;
//	}
//
//	public void setType(int type) {
//		this.msgType = type;
//	}
//
//	public Map<String, Object> getBeforeColumnData() {
//		return beforeColumnData;
//	}
//
//	public void setBeforeColumnData(Map<String, Object> beforeColumnData) {
//		this.beforeColumnData = beforeColumnData;
//	}
//
//	public Date getTimestamp() {
//		return timestamp;
//	}
//
//	public void setTimestamp(Date timestamp) {
//		this.timestamp = timestamp;
//	}
//
//	public Integer getDataFrom() {
//		return dataFrom;
//	}
//
//	public void setDataFrom(Integer dataFrom) {
//		this.dataFrom = dataFrom;
//	}
//	
//	public Long getLevelDBKey() {
//		return levelDBKey;
//	}
//
//	public void setLevelDBKey(Long levelDBKey) {
//		this.levelDBKey = levelDBKey;
//	}
//		
//}
//
