/**
 * 
 */
package com.jd.ao1.syn.service.worker;


import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.jd.syn.utils.ConstantsUtil;

/**
 * @author bailu
 *
 */
@DisallowConcurrentExecution
public class MyQuartzJobBean extends QuartzJobBean {

	private SimpleService simpleService;
	
	public void setSimpleService(SimpleService simpleService) {
		this.simpleService = simpleService;
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		if (ConstantsUtil.QUERY_WORKER_TASK_ID.equals(context.getJobDetail().getKey().getName())) {
			simpleService.executeQuery();
		} else {
			simpleService.execute(context.getJobDetail().getKey().getName());
		}
	}

}
