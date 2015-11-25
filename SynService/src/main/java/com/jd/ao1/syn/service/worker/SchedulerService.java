/**
 * 
 */
package com.jd.ao1.syn.service.worker;

import java.util.Date;

/**
 * @author bailu
 *
 */
public interface SchedulerService {

	public boolean schedule(String jobName, String cronExpression);
	
	public boolean schedule(String jobName, Date startTime);
	
	public boolean schedule(String jobName, Date startTime, Date endTime);
	
	public boolean schedule(String jobName, Date startTime, Date endTime, int repeatCount);
	
	public boolean schedule(String jobName, Date startTime, Date endTime, int repeatCount, int repeatInterval);
	
	public boolean pauseJob(String jobName);
	
	public boolean resumeJob(String jobName);
	
	public boolean deleteJob(String jobName);
	
}
