/**
 * 
 */
package com.jd.syn.utils;


/**
 * @author bailu
 *
 */
public class ConstantsUtil {

//	private static final Logger log = LogManager.getLogger(ConstantsUtil.class);
	
//	public static Map<String, ApplierTable> applierMap = new HashMap<String, ApplierTable>();
//	
//	public static Map<String, ApplierTable> getApplierMap () {
//		if (applierMap.size() == 0) {
//			try {
//				List<ApplierTable> list = BinlogSyncXml.parsexml();
//				for (ApplierTable table : list) {
//					if (!applierMap.containsKey(table.getSrcTable())) {
//						Map<String, ApplierColumn> columnMap = new HashMap<String, ApplierColumn>();
//						for (ApplierColumn col : table.getListColumns()) {
//							if(!columnMap.containsKey(col.getSrcColumn())) {
//								columnMap.put(col.getSrcColumn(), col);
//							}
//						}
//						table.setColumnMap(columnMap);
//						applierMap.put(table.getSrcTable(), table);
//					}
//				}
//			} catch (Exception e) {
//				log.error(e.getMessage(), e.getCause());
//			}
//		}
//		return applierMap;
//	}
	
	public static int PAGE_SIZE = 10;
	public static int QUERY_MAX_NUM = 3;
	public static boolean QUERY_IS_FRIST = true;
	public static boolean QUERY_TOKEN_START = false;
	public static String QUERY_WORKER_TASK_ID = "worker001";
	public static String QUERY_WORKER_CRON_EXPRESSION = "0 0/10 * * * ?";
	public static String QUERY_WORKER_CUSTOM_CRON_EXPRESSION = "";
	
}
