package com.yzx.controller;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yzx.domain.User;
import com.yzx.service.Service;

/***
 * 用户控制器
 * @author swinglife
 *
 */
@Controller
public class UserController {
	Service service = new Service();
	/***
	 * 用户登陆
	 * <p>注解配置，只允许POST提交到该方法
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	public ModelAndView login(String password){
		//验证传递过来的参数是否正确，否则返回到登陆页面。
		if(this.checkParams(new String[]{password})){
			List<User> list = null;
			try {
				list = service.getListAll();
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
		    return new ModelAndView("manage",data);
		}
		return new ModelAndView("home");
	}
	@RequestMapping(value="refreshOral")
	public ModelAndView refreshOral(){
		List<User> list = null;
		try {
			list = service.getListAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (User user : list) {
			user.setOraltime("");
		}
		try {
			service.updateOralList(list);
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
	    return new ModelAndView("manage",data);
	}
	@RequestMapping(value="addOral",method=RequestMethod.POST)
	public String addOral(String id,String oraltime){
		try {
			User user = service.getUser(id);
			if(oraltime != null && !"".equals(oraltime.trim())){
				oraltime = new String(oraltime.getBytes("ISO-8859-1"),"utf-8");
			}
			user.setOraltime(oraltime);
			service.update(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return "succ";
	}
	@RequestMapping(value="oralOrder")
	public ModelAndView oralOrder(){
		List<User> list = null;
		try {
			list = service.getOralList();
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
	    return new ModelAndView("oral",data);
	}
//	/***
//	 * 另一种参数传递的形式
//	 * 通过request来处理请求过来的参数。
//	 * @param username
//	 * @param password
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping(value="login",method=RequestMethod.POST)
//	public ModelAndView login(String username,String password,HttpServletRequest request){
//		request.setAttribute("username", username);
//		request.setAttribute("password", password);
//		return new ModelAndView("succ");
//	}
	
	/***
	 * 验证参数
	 * @param params
	 * @return
	 */
	private boolean checkParams(String[] params){
		for(String param:params){
			if("zhimiworld".equals(param)){
				return true;
			}
		}
		return false;
	}
}
