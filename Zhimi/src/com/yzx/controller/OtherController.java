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
 * ����ҳ����ת�÷�
 * @author swinglife
 *
 */
@Controller
public class OtherController {
	Service service = new Service();
	/***
	 * ��������ת������ͨ��String�ķ���ֵ����תҳ��
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
//		    data.put("msg","��δѡȡ�����û�����");  
//			return new ModelAndView("error",data);
//		}
//		if(level == null || "".equals(level.trim())){
//			Map<String,Object> data = new HashMap<String,Object>();  
//		    data.put("msg","��δѡ������Ӣ��ˮƽ��");  
//			return new ModelAndView("error",data);
//		}
//		if(skill == null || "".equals(skill.trim())){
//			Map<String,Object> data = new HashMap<String,Object>();  
//		    data.put("msg","��δѡ����Ҫ�����ļ��ܣ�");  
//			return new ModelAndView("error",data);
//		}
//		if(willing == null || "".equals(willing.trim())){
//			willing = "��Ը��";
//		}else if("true".equals(willing)){
//			willing = "Ը��";
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
	 * �����ʾ�ҳ��
	 * @return
	 */
	@RequestMapping(value="preSurvey")
	public String preSurvey(){
	    return "preSurvey";
	}
	/**
	 * �����ʾ�ҳ��
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
