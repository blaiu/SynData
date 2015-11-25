/**
 * 
 */
package com.jd.ao1.syn.service.worker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.jd.wms.rpc.wms3message.clientbean.BaseWebService;

/**
 * @author bailu
 *
 */
public class Simple {

	public static ConcurrentMap<String, BaseWebService> soaplMap = new ConcurrentHashMap<String, BaseWebService>();
	
}
