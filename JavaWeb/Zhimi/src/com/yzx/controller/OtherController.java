package com.yzx.controller;

import java.io.UnsupportedEncodingException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yzx.domain.User;
import com.yzx.service.Service;

/***
 * 其他页面跳转用法
 * @author swinglife
 *
 */
@Controller
public class OtherController {
	Service service = new Service();
	/***
	 * 其他的跳转方法，通过String的返回值来跳转页面
	 * @return
	@RequestMapping("survey")
	public String survey(){
		return "survey";
	}
	 */
	@RequestMapping("addSurvey")
	public ModelAndView addSurvey(String id,String level,String skill, String willing){
//		if(id == null || "".equals(id.trim())){
//			Map<String,Object> data = new HashMap<String,Object>();  
//		    data.put("msg","您未选取您的用户名！");  
//			return new ModelAndView("error",data);
//		}
//		if(level == null || "".equals(level.trim())){
//			Map<String,Object> data = new HashMap<String,Object>();  
//		    data.put("msg","您未选择您的英语水平！");  
//			return new ModelAndView("error",data);
//		}
//		if(skill == null || "".equals(skill.trim())){
//			Map<String,Object> data = new HashMap<String,Object>();  
//		    data.put("msg","您未选择您要锻炼的技能！");  
//			return new ModelAndView("error",data);
//		}
//		if(willing == null || "".equals(willing.trim())){
//			willing = "不愿意";
//		}else if("true".equals(willing)){
//			willing = "愿意";
//		}
		User user = null;
		String content = "";
		try {
			level = new String(level.getBytes("ISO-8859-1"),"utf-8");
			skill = new String(skill.getBytes("ISO-8859-1"),"utf-8");
			willing = new String(willing.getBytes("ISO-8859-1"),"utf-8");
			content = level+"|"+skill+"|"+willing;
			user = service.getUser(id);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(user != null){
			try {
				user.setSurvey1(content);
			} catch (Exception e) {
			}
			try {
				service.update(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		List<User> list = null;
		try {
			list = service.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    Map<String,Object> data = new HashMap<String,Object>();  
	    data.put("userlist",list);  
	    return new ModelAndView("surveyResult",data);
	}
	/**
	 * 调查问卷页面
	 * @return
	 */
	@RequestMapping(value="preSurvey")
	public String preSurvey(){
	    return "preSurvey";
	}
	/**
	 * 调查问卷页面
	 * @return
	 */
	@RequestMapping(value="survey")
	public ModelAndView survey(){
		List<User> list = null;
		try {
			list = service.getUserList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		java.util.Collections.sort(list, new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				int score1 = Integer.parseInt(((User)o1).getId());
				int score2 = Integer.parseInt(((User)o2).getId());
				return score1-score2;
			}
		});
	    Map<String,Object> data = new HashMap<String,Object>();  
	    data.put("userlist",list);  
	    return new ModelAndView("survey",data);
	}
}
