package com.jd.syn.utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.ClassPathResource;

import com.jd.syn.domain.ApplierColumn;
import com.jd.syn.domain.ApplierRowKey;
import com.jd.syn.domain.ApplierTable;


public class BinlogSyncXml {
	
	public static List<ApplierTable> parsexml() throws Exception {
		
		ClassPathResource resource = new ClassPathResource("SynMySql.xml");
		File file = resource.getFile();
		if (!resource.exists()) {
			throw new FileNotFoundException(resource.getPath());
		}
		return parse (file);
	}
	
	public static List<ApplierTable> parsexml(String path) throws Exception {
		if (StringUtils.isNotEmpty(path)) {
			File file = new File(path);
			if (!file.exists()) {
				throw new FileNotFoundException(path);
			}
			return parse (file);
		}
		throw new FileNotFoundException("xml not exist !");
	}
	
	@SuppressWarnings({ "unchecked"})
	public static List<ApplierTable> parse (File file) throws DocumentException {
		List<ApplierTable> list = new ArrayList<ApplierTable>();
		SAXReader reader = new SAXReader();
		Document doc = reader.read(file);
		Element root = doc.getRootElement();
		List<Element> sli = root.elements();
		for (Element elements : sli) {
			if ("mappings".equals(elements.getName())) {
				List<Element> list1 = elements.elements();
				for (Element element : list1) {
					if ("mapping".equals(element.getName())) {
						ApplierTable table = new ApplierTable();
						List<ApplierColumn> columns = new ArrayList<ApplierColumn>();
						table.setMemo(element.attributeValue("memo").trim());
						table.setOperate(element.attributeValue("operate").trim());
						table.setSrcTable(element.attributeValue("srcTable").trim());
						table.setTargetTable(element.attributeValue("targetTable").trim());
						table.setType(element.attributeValue("type").trim());
						List<Element> list2 = element.elements();
						for (Element element2 : list2) {
							if ("rowkey".equals(element2.getName())) {
								ApplierRowKey rowKey = new ApplierRowKey();
								rowKey.setSeparator(element2.attributeValue("separator").trim());
								List<Element> listRow = element2.elements();
								for (Element elementRow : listRow) {
									rowKey.setSrcColumn(elementRow.attributeValue("srcColumn").trim());
									rowKey.setTargetColumn(elementRow.attributeValue("targetColumn").trim());
									rowKey.setType(elementRow.attributeValue("type").trim());
								}
								table.setRowKey(rowKey);

							} else if ("column".equals(element2.getName())) {
								ApplierColumn column = new ApplierColumn();
								column.setCachekey(element2.attributeValue("cachekey").trim());
								column.setCacheTable(element2.attributeValue("cacheTable").trim());
								column.setCacheValue(element2.attributeValue("cacheValue").trim());
								column.setDateFormat(element2.attributeValue("dateFormat").trim());
								column.setSrcColumn(element2.attributeValue("srcColumn").trim());
								column.setTargetColumn(element2.attributeValue("targetColumn").trim());
								column.setSrcType(element2.attributeValue("srcType").trim());
								column.setVersion(element2.attributeValue("version").trim());
								column.setTargetType(element2.attributeValue("targetType").trim());
								columns.add(column);
							}
						}
						table.setListColumns(columns);
						list.add(table);
					}
				}
			}
		}
		
		return list;
	}
//	
//	private static final String XmlName = "SynMySql.xml";
//
//	private static BinlogSyncXml instance = null;
//
//	private BinlogSyncXml() {
//		this.init();
//	}
//
//	public static BinlogSyncXml getInstance() {
//		if (instance == null) {
//			instance = new BinlogSyncXml();
//		}
//		return instance;
//	}
//
//	@SuppressWarnings({ "unchecked", "static-access" })
//	public void init() {
//		String xmlPath = System.getProperty("user.dir") + "\\src\\main\\resources\\" + this.XmlName;
//		SAXReader reader = new SAXReader();
//		try {
//			Document doc = reader.read(xmlPath);
//			Element root = doc.getRootElement();
//			List<Element> sli = root.elements();
//			for (Element elements : sli) {
//				if ("mappings".equals(elements.getName())) {
//					List<Element> list1 = elements.elements();
//					for (Element element : list1) {
//						if ("mapping".equals(element.getName())) {
//							ApplierTable table = new ApplierTable();
//							List<ApplierColumn> columns = new ArrayList<ApplierColumn>();
//							table.setMemo(element.attributeValue("memo").trim());
//							table.setOperate(element.attributeValue("operate").trim());
//							table.setSrcTable(element.attributeValue("srcTable").trim());
//							table.setTargetTable(element.attributeValue("targetTable").trim());
//							table.setType(element.attributeValue("type").trim());
//							List<Element> list2 = element.elements();
//							for (Element element2 : list2) {
//								if ("rowkey".equals(element2.getName())) {
//									ApplierRowKey rowKey = new ApplierRowKey();
//									rowKey.setSeparator(element2.attributeValue("separator").trim());
//									List<Element> listRow = element2.elements();
//									for (Element elementRow : listRow) {
//										rowKey.setSrcColumn(elementRow.attributeValue("srcColumn").trim());
//										rowKey.setTargetColumn(elementRow.attributeValue("targetColumn").trim());
//										rowKey.setType(elementRow.attributeValue("type").trim());
//									}
//									table.setRowKey(rowKey);
//
//								} else if ("column".equals(element2.getName())) {
//									ApplierColumn column = new ApplierColumn();
//									column.setCachekey(element2.attributeValue("cachekey").trim());
//									column.setCacheTable(element2.attributeValue("cacheTable").trim());
//									column.setCacheValue(element2.attributeValue("cacheValue").trim());
//									column.setDateFormat(element2.attributeValue("dateFormat").trim());
//									column.setSrcColumn(element2.attributeValue("srcColumn").trim());
//									column.setTargetColumn(element2.attributeValue("targetColumn").trim());
//									column.setSrcType(element2.attributeValue("srcType").trim());
//									column.setVersion(element2.attributeValue("version").trim());
//									column.setTargetType(element2.attributeValue("targetType").trim());
//									columns.add(column);
//								}
//							}
//							table.setListColumns(columns);
//						}
//
//					}
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void main(String[] args) {
//		BinlogSyncXml.getInstance();
//
//	}
}
