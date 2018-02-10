package com.yzx.controller;

import java.io.UnsupportedEncodingException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yzx.domain.User;
import com.yzx.service.Service;

@Controller
public class AddScore {
	Service service = new Service();
	@RequestMapping("delete")
	public ModelAndView delete(@RequestParam("id")String id){
		try {
			service.delete(id);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		List<User> list = null;
		try {
			list = service.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    Map<String,Object> data = new HashMap<String,Object>();  
	    data.put("userlist",list);  
	    return new ModelAndView("manage",data);
	}
	@RequestMapping("update")
	public ModelAndView update(@RequestParam("id")String id,@RequestParam("newid")String newid,@RequestParam("username")String username,@RequestParam("score")String score,@RequestParam("sum")String sum){
		try {
			username = new String(username.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e2) {
			e2.printStackTrace();
		}
		User user = null;
		if(newid != null && !"".equals(newid.trim())){
			user = new User();
			user.setId(newid);
			user.setScore(score);
			user.setSum(sum);
			user.setUsername(username);
			try {
				service.add(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				user = service.getUser(id);
				if(score != null && !"".equals(score.trim())){
					user.setScore(score);
				}
				if(sum != null && !"".equals(sum.trim())){
					user.setSum(sum);
				}
				if(username != null && !"".equals(username.trim())){
					user.setUsername(username);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
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
//		java.util.Collections.sort(list, new Comparator<Object>() {
//
//			@Override
//			public int compare(Object o1, Object o2) {
//				int score1 = 0;
//				int score2 = 0;
//				try {
//					score1 = Integer.parseInt(((User)o1).getId());
//				} catch (Exception e) {
//				}
//				try {
//					score2 = Integer.parseInt(((User)o2).getId());
//				} catch (Exception e) {
//				}
//				return score1-score2;
//			}
//		});
	    Map<String,Object> data = new HashMap<String,Object>();  
	    data.put("userlist",list);  
	    return new ModelAndView("manage",data);
	}
	@RequestMapping("addScore")
	public ModelAndView addScore(String id,String point,String task){
//		if(id == null || "".equals(id.trim())){
//			Map<String,Object> data = new HashMap<String,Object>();  
//		    data.put("msg","您未选取您的用户名！");  
//			return new ModelAndView("error",data);
//		}
//		if(task == null || "".equals(task.trim())){
//			Map<String,Object> data = new HashMap<String,Object>();  
//		    data.put("msg","您未选择您要登记的任务！");  
//			return new ModelAndView("error",data);
//		}
//		if(point == null || "".equals(point.trim())){
//			Map<String,Object> data = new HashMap<String,Object>();  
//		    data.put("msg","您未选择您要登记的积分！");  
//			return new ModelAndView("error",data);
//		}
		int newPoint = 0;
		int oldScore = 0;
		int oldSum = 0;
		User user = null;
		try {
			user = service.getUser(id);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(user != null){
			try {
				newPoint = Integer.parseInt(point);
				oldScore = Integer.parseInt(user.getScore()) + newPoint;
				oldSum = Integer.parseInt(user.getSum()) + newPoint;
				task = new String(task.getBytes("ISO-8859-1"),"utf-8");				
				if(task != null && !"".equals(task.trim())){
					String remark = user.getRemark();
					if(remark == null || "".equals(remark)){
						user.setRemark(task);
					}else{
						user.setRemark(remark+","+task);
					}
				}
			} catch (Exception e) {
			}
			user.setScore(oldScore+"");
			user.setSum(oldSum+"");
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
		java.util.Collections.sort(list, new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				int score1 = 0;
				int score2 = 0;
				try {
					score1 = Integer.parseInt(((User)o1).getScore());
				} catch (Exception e) {
				}
				try {
					score2 = Integer.parseInt(((User)o2).getScore());
				} catch (Exception e) {
				}
				return score2-score1;
			}
		});
	    Map<String,Object> data = new HashMap<String,Object>();  
	    data.put("userlist",list);  
	    return new ModelAndView("rank",data);
	}
	@RequestMapping("nameList")
	public ModelAndView  login(){  
	    List<User> list = null;
		try {
			list = service.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		java.util.Collections.sort(list, new Comparator<Object>() {
//
//			@Override
//			public int compare(Object o1, Object o2) {
//				int score1 = 0;
//				int score2 = 0;
//				try {
//					score1 = Integer.parseInt(((User)o1).getId());
//				} catch (Exception e) {
//				}
//				try {
//					score2 = Integer.parseInt(((User)o2).getId());
//				} catch (Exception e) {
//				}
//				return score1-score2;
//			}
//		});
	    Map<String,Object> data = new HashMap<String,Object>();  
	    data.put("userlist",list);  
	    return new ModelAndView("index",data);  
	}
	@RequestMapping("refresh")
	public ModelAndView  refresh(){  
	    List<User> list = null;
		try {
			list = service.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (User user : list) {
			user.setScore("0");
			user.setRemark("");
		}
		try {
			service.updateList(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    Map<String,Object> data = new HashMap<String,Object>();  
	    data.put("userlist",list);  
	    return new ModelAndView("manage",data);  
	}
	@RequestMapping("rankList")
	public ModelAndView  rank(){  
	    List<User> list = null;
		try {
			list = service.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		java.util.Collections.sort(list, new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				int score1 = 0;
				int score2 = 0;
				try {
					score1 = Integer.parseInt(((User)o1).getScore());
				} catch (Exception e) {
				}
				try {
					score2 = Integer.parseInt(((User)o2).getScore());
				} catch (Exception e) {
				}
				return score2-score1;
			}
		});
	    Map<String,Object> data = new HashMap<String,Object>();  
	    data.put("userlist",list);  
	    return new ModelAndView("rank",data);  
	}
}
