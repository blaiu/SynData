/**
 * 
 */
package com.jd.ao1.syn.service.worker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.codehaus.jackson.type.TypeReference;

import com.jd.ao1.domain.SynConfig;
import com.jd.ao1.domain.SynModel;
import com.jd.ao1.domain.SynRecord;
import com.jd.ao1.domain.WorkerTaskQuery;
import com.jd.ao1.syn.service.SynService;
import com.jd.bk.common.util.json.JsonUtil;
import com.jd.wms.domain.ws.receivemessage.param.BizToken;
import com.jd.wms.rpc.wms3message.clientbean.BaseWebService;
import com.jd.wms.rpc.wms3message.clientbean.Result;
import com.jd.wms.rpc.wms3message.service.impl.Wms3MessageRpcImpl;

/**
 * @author bailu
 *
 */
public class SimpleService implements Serializable {

	@Resource
	private Wms3MessageRpcImpl wms3MessageRpc;
	@Resource
	private JaxWsProxyFactoryBean jaxWsProxyFactoryBean;
	
	@Resource
	private SynService synService;
	
	@Resource
    private BizToken bizToken;
	
	private static final long serialVersionUID = -1478855932313673141L;

	public void execute (String jobName) {
		System.out.println("[" + jobName + "] 开始执行！");
		SynModel model = synService.getModel(jobName);
		SynConfig config = synService.getConfig(model.getTaskId());
		if (null != model) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("maxTimes", config.getMaxTimes());
			map.put("taskId", model.getTaskId());
			List<SynRecord> list = synService.queryRecord(map);
			if (list.size() > 0) {
				try {
					bizToken.setBizType(model.getTokenQueryKey());
					bizToken.setCallCode(model.getTokenCallCode());
					bizToken.setUuid(model.getTokenUuid());
					jaxWsProxyFactoryBean.setAddress(model.getAddress());
					BaseWebService bws = Simple.soaplMap.get(model.getTaskId());
					if (null != bws) {
						wms3MessageRpc.setClientWebServiceSoap(bws);
					} else {
						BaseWebService bws2 = (BaseWebService)jaxWsProxyFactoryBean.create();
						Simple.soaplMap.put(model.getTaskId(), bws2);
						wms3MessageRpc.setClientWebServiceSoap(bws2);
					}
					for (SynRecord record : list) {
						String[] recordIds = record.getRecordId().split("\\|");
						record.setBusinessName(record.getRecordDesc());
						record.setBusinessNo(recordIds[1]);
						record.setTaskNo(recordIds[2]);
						record.setReDoQty(0);
						Result result = wms3MessageRpc.processWs(JsonUtil.toJson(bizToken), JsonUtil.toJson(record));
						List<Integer> idList = new ArrayList<Integer>();
						idList.add(record.getId());
						if(result.getResultCode() == 1) {
							synService.removeRecord(idList);
						} else {
							synService.modifyRecord(idList);
						}
					} 
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void executeQuery () {
		System.out.println("抓取数据worker执行");
		List<SynModel> modelList = synService.queryModel(new HashMap<String, Object>());
		if (null == modelList || modelList.size() == 0) {
			return;
		}
		for (SynModel model : modelList) {
			try {
				SynConfig config = synService.getConfig(model.getTaskId());
				bizToken.setBizType(model.getTokenQueryKey());
				bizToken.setCallCode(model.getTokenCallCode());
				bizToken.setUuid(model.getTokenUuid());
				jaxWsProxyFactoryBean.setAddress(model.getAddress());
				BaseWebService bws = Simple.soaplMap.get(model.getTaskId());
				if (null != bws) {
					wms3MessageRpc.setClientWebServiceSoap(bws);
				} else {
					BaseWebService bws2 = (BaseWebService)jaxWsProxyFactoryBean.create();
					Simple.soaplMap.put(model.getTaskId(), bws2);
					wms3MessageRpc.setClientWebServiceSoap(bws2);
				}
				WorkerTaskQuery taskQuery = new WorkerTaskQuery();
				if (null == config || null == config.getMaxNum()) {
					taskQuery.setReDoQty(3);
				} else {
					taskQuery.setReDoQty(config.getMaxNum());
				}
				Result result = wms3MessageRpc.processWs(JsonUtil.toJson(bizToken), JsonUtil.toJson(taskQuery));
				if(null != result && result.getResultCode() == 1) {
					List<SynRecord> listWorkerData = JsonUtil.fromJson(result.getResultValue(), new TypeReference<List<SynRecord>>() {});
					if (null != listWorkerData && listWorkerData.size() > 0) {
						addData(listWorkerData, model);
					}
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void addData(List<SynRecord> listWorkerData, SynModel model ) {
		List<SynRecord> list = new ArrayList<SynRecord>();
		for (SynRecord record : listWorkerData) {
			record.setRecordId(model.getTaskId() + "|" + record.getBusinessNo() + "|" + record.getTaskNo());
			record.setRecordDesc(record.getBusinessName());
			record.setTaskId(model.getTaskId());
			record.setTaskType(model.getTaskType());
			list.add(record);
		}
		if (list.size() > 0) {
			synService.addRecord(list);
		}
	}
}
