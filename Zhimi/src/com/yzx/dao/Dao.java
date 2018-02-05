package com.yzx.dao;

import java.util.List;

import com.yzx.domain.User;

public interface Dao {
	public void add(User user) throws Exception;
	
	public void update(User user) throws Exception;
	
	public List<User> getList() throws Exception;

	public void delete(String id) throws Exception;

	public User getUser(String id) throws Exception;

	public void updateList(List<User> list) throws Exception;

	public List<User> getOralList() throws Exception;

	public List<User> getListAll() throws Exception;

	public void updateOralList(List<User> list) throws Exception;

	public List<User> getUserList() throws Exception;
}
