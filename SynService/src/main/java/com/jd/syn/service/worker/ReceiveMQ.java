//package com.jd.syn.service.worker;
//
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//
//import com.jd.syn.service.mysql.MySQLApplier;
//
//import taskengine_client.mq.Task;
//import taskengine_client.mq.TaskHandler;
//
//
///**
// * @类描述：从任务引擎中获取数据（拣货阶段）
// * 
// * @author bailu
// */
//public class ReceiveMQ implements TaskHandler {
//    
//	private static final Logger log = LogManager.getLogger(ReceiveMQ.class);
//    
//    private MySQLApplier<Object> mySQLApplier;
//
//	public boolean handleTask(Task task) {
//        boolean result = false;
//        log.debug("=============接收数据  start...... 节点名称：" + task.getFromNodeNo() + "=========================================");
//        log.error("MQ-data:" + task.getBusinessData());
//        log.debug("=============接收数据 end         节点名称：" + task.getFromNodeNo() + "=========================================");
//        mySQLApplier.receiveBeanLog(task.getBusinessData());
//        return result;
//    }
//
//    
//    
//}
