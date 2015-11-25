/**
 * 
 */
package com.jd.ao1.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jd.ao1.domain.SynConfig;
import com.jd.ao1.domain.SynModel;
import com.jd.ao1.syn.service.SynService;
import com.jd.ao1.syn.service.worker.SchedulerService;
import com.jd.ao1.syn.service.worker.Simple;
import com.jd.syn.utils.ConstantsUtil;
import com.jd.syn.utils.page.PageParam;

/**
 * @author bailu
 *
 */
@Controller
public class ContentController {

	@Resource
	private SchedulerService schedulerService;
	
	
	@Resource
	private SynService synService;
	
	@RequestMapping(value = "/queryModel.do")
    public ModelAndView queryModel(PageParam pageParam) {
		ModelAndView modelAndView = new ModelAndView();
		Map<String, Object> map = new HashMap<String, Object>();
		int pageNo = 1;
		if (null != pageParam) {
			map.put("taskId", pageParam.getTaskId());
			map.put("taskType", pageParam.getTaskType());
			map.put("taskName", pageParam.getKeyWord());
			map.put("modelType", pageParam.getModelType());
			map.put("path", "/queryModel.do");
			pageNo = (null != pageParam.getPageNo()) ? pageParam.getPageNo() : 1;
		}
		modelAndView.addObject("pagination", synService.queryModelPage(map, pageNo, ConstantsUtil.PAGE_SIZE));
		modelAndView.addObject("pageParam", pageParam);
        modelAndView.setViewName("/model");
		return modelAndView;
    }
	
	@RequestMapping(value = "/queryRecord.do")
    public ModelAndView queryRecord(PageParam pageParam) {
		ModelAndView modelAndView = new ModelAndView();
		Map<String, Object> map = new HashMap<String, Object>();
		int pageNo = 1;
		if (null != pageParam) {
			map.put("taskId", pageParam.getTaskId());
			map.put("taskType", pageParam.getTaskType());
			map.put("maxTimes", pageParam.getMaxTimes());
			map.put("recordId", pageParam.getRecordId());
			map.put("path", "/queryRecord.do");
			pageNo = (null != pageParam.getPageNo()) ? pageParam.getPageNo() : 1;
		}
		modelAndView.addObject("pagination", synService.queryRecordPage(map, pageNo, ConstantsUtil.PAGE_SIZE));
		modelAndView.addObject("pageParam", pageParam);
        modelAndView.setViewName("/record");
		return modelAndView;
    }
	
	@RequestMapping(value = "/toAddModel.do")
    public ModelAndView toAddModel() {
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/addModel");
		return modelAndView;
    }
	
	@RequestMapping(value = "/addModel.do")
    public ModelAndView addModel(SynModel synModel) {
		ModelAndView modelAndView = new ModelAndView();
		synModel.setTaskId(System.currentTimeMillis() + "" + synModel.getTaskType());
		if(synService.addModel(synModel)) {
			modelAndView.setViewName("redirect:/queryModel.do");
		} else {
			modelAndView.addObject("m", synModel);
			modelAndView.setViewName("/addModel");
		}
		return modelAndView;
    }
	
	@RequestMapping(value = "/removeModel.do")
	@ResponseBody
    public Object romveModel(String taskId) {
		Simple.soaplMap.remove(taskId);
		schedulerService.deleteJob(taskId);
		return synService.removeModel(taskId);
    }
	
	@RequestMapping(value = "/toConfig.do")
    public ModelAndView toConfig(String taskId, String taskType, String flag) {
		ModelAndView modelAndView = new ModelAndView();
		SynConfig config = null;
		if (null != taskId) {
			config = synService.getConfig(taskId);
		}
		modelAndView.addObject("taskId", taskId);
		modelAndView.addObject("taskType", taskType);
		modelAndView.addObject("flag", flag);
		modelAndView.addObject("cfg", config);
        modelAndView.setViewName("/addConfig");
		return modelAndView;
    }
	
	@RequestMapping(value = "/addConfig.do")
    public ModelAndView addConfig(SynConfig config) {
		ModelAndView modelAndView = new ModelAndView();
		if (null == config.getMaxNum()) {
			config.setMaxNum(ConstantsUtil.QUERY_MAX_NUM);
		}
		modelAndView.addObject("cfg", config);
		if(synService.addConfig(config)) {
			modelAndView.addObject("flag", true);
			modelAndView.setViewName("redirect:/toConfig.do?taskId="+config.getTaskId()+"&taskType="+config.getTaskType());
		} else {
			modelAndView.setViewName("/addConfig");
		}
		return modelAndView;
    }
	
	@RequestMapping(value = "/toView.do")
    public ModelAndView toView(String taskId) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("cfg", synService.getConfig(taskId));
		modelAndView.addObject("model", synService.getModel(taskId));
		modelAndView.setViewName("/view");
		return modelAndView;
    }
	
	@RequestMapping(value = "/toGrabWorker.do")
	public ModelAndView toGrabWorker() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("taskId", ConstantsUtil.QUERY_WORKER_TASK_ID);
		modelAndView.addObject("flag", ConstantsUtil.QUERY_TOKEN_START);
		String cronExpssion = ConstantsUtil.QUERY_WORKER_CUSTOM_CRON_EXPRESSION;
		if (StringUtils.isEmpty(cronExpssion)) {
			cronExpssion = ConstantsUtil.QUERY_WORKER_CRON_EXPRESSION;
		}
		modelAndView.addObject("cronExpssion", cronExpssion);
		modelAndView.setViewName("/grapWorker");
		return modelAndView;
	}
	
	@RequestMapping(value = "/startStop.do")
	@ResponseBody
    public Object startStop(String id, String taskId, String isStart) {
		if (!StringUtils.isEmpty(id) && !StringUtils.isEmpty(taskId) && !StringUtils.isEmpty(isStart)) {
			SynModel synModel = new SynModel();
			synModel.setId(Integer.valueOf(id));
			synModel.setIsStart(Integer.valueOf(isStart));
			if(synService.modifyModel(synModel)) {
				SynConfig config = synService.getConfig(taskId);
				if (!StringUtils.isEmpty(config.getCronExpression())) {
					if ("1".equals(isStart.trim())) {
						return schedulerService.schedule(config.getTaskId(), config.getCronExpression());
					} else {
						Simple.soaplMap.remove(taskId);
						return schedulerService.deleteJob(config.getTaskId());
					}
				}
			}
		}
		return false;
    }
	
	@RequestMapping(value = "/grapWorkerStartStop.do")
	@ResponseBody
	public Object grapWorkerStartStop(String taskId, String isStart, String cronExpression) {
		if (!StringUtils.isEmpty(taskId) && !StringUtils.isEmpty(isStart)) {
			if (StringUtils.isEmpty(cronExpression)) {
				cronExpression = ConstantsUtil.QUERY_WORKER_CRON_EXPRESSION;
			}
			ConstantsUtil.QUERY_WORKER_CUSTOM_CRON_EXPRESSION = cronExpression;
			if ("1".equals(isStart.trim())) {
				ConstantsUtil.QUERY_TOKEN_START = true;
				return schedulerService.schedule(taskId, cronExpression);
			} else {
				ConstantsUtil.QUERY_TOKEN_START = false;
				return schedulerService.deleteJob(taskId);
			}
		}
		return false;
	}
	
}
