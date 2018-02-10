package com.yzx.service;

import java.util.List;

import com.yzx.dao.Dao;
import com.yzx.dao.impl.DaoImpl;
import com.yzx.domain.User;

public class Service {
	Dao dao = new DaoImpl();
	public List<User> getList() throws Exception{
		return dao.getList();
	}
	public List<User> getListAll() throws Exception{
		return dao.getListAll();
	}
	public void add(User user) throws Exception {
		dao.add(user);
	}
	public void update(User user) throws Exception {
		dao.update(user);
	}
	public void updateList(List<User> list) throws Exception {
		dao.updateList(list);
	}
	
	public void delete(String id) throws Exception {
		dao.delete(id);
	}
	public User getUser(String id) throws Exception {
		return dao.getUser(id);
	}
	public List<User> getOralList() throws Exception {
		return dao.getOralList();
	}
	public List<User> getUserList() throws Exception {
		return dao.getUserList();
	}
	public void updateOralList(List<User> list) throws Exception {
		dao.updateOralList(list);
	}
}
