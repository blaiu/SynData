package com.jd.ao1.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jd.ao1.syn.service.worker.SchedulerService;


public class SynWorkTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext springContext = new ClassPathXmlApplicationContext(new String[]{"classpath:spring-config.xml"});
		SchedulerService schedulerService = (SchedulerService)springContext.getBean("schedulerService");
//		JobDetailImpl jobDetailFactory = (JobDetailImpl)springContext.getBean("jobDetailFactoryBean");
//		jobDetailFactory.setName("ccc");
//		JobDetail jb = jobDetailFactory.getObject().getJobBuilder().withIdentity("ccc").build();
		schedulerService.schedule("ccc", "0/3 * * * * ?");
		
		try {
			Thread.sleep(1000*10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		schedulerService.pauseJob(jobDetailFactory.getKey().getName());
//		schedulerService.resumeJob(jobDetail.getName());
		
//		schedulerService.deleteJob(jobDetail.getName());
		
//		schedulerService.schedule(jobDetail, "0/1 * * * * ?");
		
//		schedulerService.schedule("ssss","0/3 * * * * ?");
//		Date startTime = parse("2009-06-01 22:16:00");
//		Date endTime =  parse("2009-06-01 22:20:00");
//		schedulerService.schedule("ssss", startTime);
	}
	
//	private static Date parse(String dateStr) {  
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
//		try {  
//			return format.parse(dateStr);  
//		} catch (ParseException e) {  
//			throw new RuntimeException(e);  
//		}  
//	}  

	
}
