/**
 * 
 */
package com.jd.ao1.syn.service.worker;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.TriggerBuilder;
import org.quartz.impl.JobDetailImpl;

/**
 * @author bailu
 *
 */
public class SchedulerServiceImpl implements SchedulerService {

	@Resource
	private Scheduler scheduler;
	@Resource
	private JobDetailImpl jobDetailImpl;

	@Override
	public boolean schedule(String jobName, String cronExpression) {
		if(!StringUtils.isEmpty(jobName)) {
			try {
				if(!scheduler.checkExists(getJobKey(jobName))) {
					jobDetailImpl.setKey(getJobKey(jobName));
					CronTrigger trigger = (CronTrigger) TriggerBuilder.newTrigger()
							.withIdentity(getTriggerName(jobName), Scheduler.DEFAULT_GROUP)
							.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
							.build();
					scheduler.scheduleJob(jobDetailImpl, trigger);
				}
				return true;
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean schedule(String jobName, Date startTime) {
		return schedule(jobName, startTime, null);
	}

	@Override
	public boolean schedule(String jobName, Date startTime, Date endTime) {
		return schedule(jobName, startTime, endTime, 0);
	}

	@Override
	public boolean schedule(String jobName, Date startTime, Date endTime, int repeatCount) {
		return schedule(jobName, startTime, endTime, repeatCount, 0);
	}

	@Override
	public boolean schedule(String jobName, Date startTime, Date endTime, int repeatCount, int repeatInterval) {
		if(!StringUtils.isEmpty(jobName)) {
			try {
				jobDetailImpl.setKey(getJobKey(jobName));
				CronTrigger trigger = (CronTrigger) TriggerBuilder.newTrigger()
						.withIdentity(getTriggerName(jobName), Scheduler.DEFAULT_GROUP)
						.startAt(startTime)
						.endAt(endTime)
						.withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(repeatCount, repeatInterval))
						.build();
				scheduler.scheduleJob(jobDetailImpl, trigger);
				return true;
			} catch (SchedulerException e) {
				throw new RuntimeException(e);
			}
		}
		return false;
	}

	@Override
	public boolean pauseJob(String jobName) {
		try {
			scheduler.pauseJob(getJobKey(jobName));
			return true;
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean resumeJob(String jobName) {
		try {
			scheduler.resumeJob(getJobKey(jobName));
			return true;
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteJob(String jobName) {
		try {
			if(scheduler.checkExists(getJobKey(jobName))) {
				return scheduler.deleteJob(getJobKey(jobName));
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private String getTriggerName(String jobName) {
		return "trigger_" + jobName;
	}
	
	private JobKey getJobKey(String jobName) {
		return new JobKey(jobName, Scheduler.DEFAULT_GROUP);
	}

}
