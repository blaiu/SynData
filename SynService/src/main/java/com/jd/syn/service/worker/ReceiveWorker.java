//package com.jd.syn.service.worker;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import com.jd.syn.utils.ConstantsUtil;
//import com.jd.wms.domain.ws.receivemessage.param.BizToken;
//
//import org.codehaus.jackson.type.TypeReference;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import taskengine_client.mq.ConsumerSettingConf;
//import taskengine_client.mq.DynamicConsumer;
//
//import com.jd.bk.common.util.json.JsonUtil;
//import com.jd.bk.common.web.result.Result;
//import com.jd.wms.rpc.wms3message.service.Wms3MessageRpc;
//import com.jd.wms.service.worker.DefaultBaseWorker;
//
//public class ReceiveWorker extends DefaultBaseWorker<Result>{
//	private static final long serialVersionUID = 1L;
//
//	private static final Logger logger = LoggerFactory.getLogger(ReceiveWorker.class);
//	@Resource
//	private DynamicConsumer dynamicConsumer;
//	@Resource
//	private Wms3MessageRpc taskEngineSendData;
//	@Resource
//    private BizToken taskEngineBizTokenReceive;
//	
//	private String orgNo;
//	private String destinationNo;
//	private String warehouseNo;
//	
//	public void setOrgNo(String orgNo) {
//		this.orgNo = orgNo;
//	}
//
//	public void setDestinationNo(String destinationNo) {
//		this.destinationNo = destinationNo;
//	}
//
//	public void setWarehouseNo(String warehouseNo) {
//		this.warehouseNo = warehouseNo;
//	}
//
//	@Override
//	public Result execute() {
//		
//		ConstantsUtil.getApplierMap();
//		
//		try {
//			List<ConsumerSettingConf> list = new ArrayList<ConsumerSettingConf>();
//			ConsumerSettingConf conf = new ConsumerSettingConf();
//			conf.setNodeNo("ao2.check");
//			conf.setOrgNo(orgNo);
//			conf.setDestination(destinationNo);
//			conf.setWarehouseNo(warehouseNo);
//			list.add(conf);
//			com.jd.wms.rpc.wms3message.clientbean.Result result = taskEngineSendData.processWs(JsonUtil.toJson(taskEngineBizTokenReceive),JsonUtil.toJson(list));
//			if(result.getResultCode()==1) {
//				list =JsonUtil.fromJson(result.getResultValue(),new TypeReference<List<ConsumerSettingConf>>(){});
//				dynamicConsumer.setListenerConsumerSetting(list);
//			} else {
//				logger.error("查询配置文件出错{}{}",result.getResultCode(),result.getResultMessage());
//				throw new Exception("cod:" +result.getResultCode()+" message:"+result.getResultMessage());
//			}
//		} catch(Exception e) {
//			logger.error("查询MQ配置文件出错" + e.getMessage(),e);
//		}
//		return null;
//	}
//	
//	public void init(){
//		logger.debug("((((((((((((((((((()))))))))))))))))))))");
//		this.execute();
//	}
//	
//}
