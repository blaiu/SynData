/**
 * 
 */
package com.jd.ao1.web;

import java.util.Date;
import java.util.Properties;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author bailu
 *
 */
@Controller
public class LoginController {

	@RequestMapping(value = "/toLogin.do")
    public ModelAndView toLogin(String username, String password) {
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/login");
		modelAndView.addObject("username", "admin");
		modelAndView.addObject("password", "admin");
		return modelAndView;
    }
	
	@RequestMapping(value = "/login.do")
    public ModelAndView login(String username, String password) {
		ModelAndView modelAndView = new ModelAndView();
		if (null != username && null !=password) {
        	if (username.equals(password)) {
        		modelAndView.setViewName("/index");
        	}
        } else {
        	modelAndView.setViewName("/login");
        }
		modelAndView.addObject("username", username);
		modelAndView.addObject("password", password);
		setProperties (modelAndView);
		return modelAndView;
    }
	
	@RequestMapping(value = "/toIndex.do")
    public ModelAndView toIndex() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/index");
		setProperties (modelAndView);
		return modelAndView;
    }
	
	private void setProperties (ModelAndView modelAndView) {
		Properties props=System.getProperties(); //获得系统属性集  
		String osName = props.getProperty("os.name"); //操作系统名称  
		String osArch = props.getProperty("os.arch"); //操作系统构架  
		String osVersion = props.getProperty("os.version"); //操作系统版本  
		String javaVersion = props.getProperty("java.version"); //操作系统版本  
		String javaVendor = props.getProperty("java.vendor"); //操作系统版本  
		modelAndView.addObject("osName", osName);
		modelAndView.addObject("osArch", osArch);
		modelAndView.addObject("osVersion", osVersion);
		modelAndView.addObject("javaVersion", javaVersion);
		modelAndView.addObject("javaVendor", javaVendor);
		modelAndView.addObject("date", new Date());
	}
}
