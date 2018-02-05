package com.yzx.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.yzx.dao.Dao;
import com.yzx.domain.DbConn;
import com.yzx.domain.User;

public class DaoImpl implements Dao{
	DbConn dbConn = null;
	public DaoImpl() {
		dbConn = new DbConn();
		dbConn.init();
	}
	@Override
	public void add(User user) throws Exception {
		dbConn.openConnection();
		Connection conn = dbConn.getConn();
		PreparedStatement pst = null;
		StringBuilder sb = new StringBuilder();
		sb.append("insert into userinfo (id,username,score,sum,remark) values (?,?,?,?,?)");
		pst = conn.prepareStatement(sb.toString());
		pst.setString(1, user.getId());
		pst.setString(2, user.getUsername());
		pst.setString(3, user.getScore());
		pst.setString(4, user.getSum());
		pst.setString(5, user.getRemark());
		pst.executeUpdate();
		if(pst!=null){
			pst.close();
			pst = null;
		}
		dbConn.close();
	}
	@Override
	public void delete(String id) throws Exception {
		dbConn.openConnection();
		Connection conn = dbConn.getConn();
		PreparedStatement pst = null;
		StringBuilder sb = new StringBuilder();
		sb.append("delete from userinfo where id = ?");
		pst = conn.prepareStatement(sb.toString());
		pst.setString(1, id);
		pst.executeUpdate();
		if(pst!=null){
			pst.close();
			pst = null;
		}
		dbConn.close();
	}
	@Override
	public void update(User user) throws Exception {
		dbConn.openConnection();
		Connection conn = dbConn.getConn();
		PreparedStatement pst = null;
		StringBuilder sb = new StringBuilder();
		sb.append("update userinfo set score=?,sum=?,remark=?,oraltime=?,survey1=? where id=?");
		pst = conn.prepareStatement(sb.toString());
		pst.setString(1, user.getScore());
		pst.setString(2, user.getSum());
		pst.setString(3, user.getRemark());
		pst.setString(4, user.getOraltime());
		pst.setString(5, user.getSurvey1());
		pst.setString(6, user.getId());
		pst.executeUpdate();
		if(pst!=null){
			pst.close();
			pst = null;
		}
		dbConn.close();
	}
	@Override
	public List<User> getList() throws Exception {
		dbConn.openConnection();
		Connection conn = dbConn.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<User> list = new LinkedList<User>();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from userinfo");
		pst = conn.prepareStatement(sb.toString());
		rs = pst.executeQuery();
		User user = null;
		while(rs.next()){
			user = new User();
			user.setId(rs.getString(1));
			user.setUsername(rs.getString(2));
			user.setScore(rs.getString(3));
			user.setSum(rs.getString(4));
			user.setRemark(rs.getString(5));
			user.setOraltime(rs.getString(6));
			user.setSurvey1(rs.getString(7));
			list.add(user);
		}
		if(rs!=null){
			rs.close();
			rs = null;
		}
		if(pst!=null){
			pst.close();
			pst = null;
		}
		dbConn.close();
		return list;
	}
	@Override
	public List<User> getOralList() throws Exception {
		dbConn.openConnection();
		Connection conn = dbConn.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<User> list = new LinkedList<User>();
		StringBuilder sb = new StringBuilder();
		sb.append("select id,username,oraltime from userinfo");
		pst = conn.prepareStatement(sb.toString());
		rs = pst.executeQuery();
		User user = null;
		while(rs.next()){
			user = new User();
			user.setId(rs.getString(1));
			user.setUsername(rs.getString(2));
			user.setOraltime(rs.getString(3));
			list.add(user);
		}
		if(rs!=null){
			rs.close();
			rs = null;
		}
		if(pst!=null){
			pst.close();
			pst = null;
		}
		dbConn.close();
		return list;
	}
	@Override
	public List<User> getUserList() throws Exception {
		dbConn.openConnection();
		Connection conn = dbConn.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<User> list = new LinkedList<User>();
		StringBuilder sb = new StringBuilder();
		sb.append("select id,username from userinfo");
		pst = conn.prepareStatement(sb.toString());
		rs = pst.executeQuery();
		User user = null;
		while(rs.next()){
			user = new User();
			user.setId(rs.getString(1));
			user.setUsername(rs.getString(2));
			list.add(user);
		}
		if(rs!=null){
			rs.close();
			rs = null;
		}
		if(pst!=null){
			pst.close();
			pst = null;
		}
		dbConn.close();
		return list;
	}
	@Override
	public User getUser(String id) throws Exception {
		dbConn.openConnection();
		Connection conn = dbConn.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		sb.append("select * from userinfo where id = ?");
		pst = conn.prepareStatement(sb.toString());
		pst.setString(1, id);
		rs = pst.executeQuery();
		User user = null;
		while(rs.next()){
			user = new User();
			user.setId(rs.getString(1));
			user.setUsername(rs.getString(2));
			user.setScore(rs.getString(3));
			user.setSum(rs.getString(4));
			user.setRemark(rs.getString(5));
			user.setOraltime(rs.getString(6));
			user.setSurvey1(rs.getString(7));
		}
		if(rs!=null){
			rs.close();
			rs = null;
		}
		if(pst!=null){
			pst.close();
			pst = null;
		}
		dbConn.close();
		return user;
	}
	@Override
	public void updateList(List<User> list) throws Exception {
		dbConn.openConnection();
		Connection conn = dbConn.getConn();
		conn.setAutoCommit(false);
		PreparedStatement pst = null;
		StringBuilder sb = new StringBuilder();
		sb.append("update userinfo set score=?,remark=? where id=?");
		pst = conn.prepareStatement(sb.toString());
		for (User user : list) {
			pst.setString(1, user.getScore());
			pst.setString(2, user.getRemark());
			pst.setString(3, user.getId());
			pst.addBatch();
		}
		pst.executeBatch();
		conn.commit();
		if(pst!=null){
			pst.close();
			pst = null;
		}
		dbConn.close();
	}
	@Override
	public List<User> getListAll() throws Exception {
		dbConn.openConnection();
		Connection conn = dbConn.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<User> list = new LinkedList<User>();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from userinfo");
		pst = conn.prepareStatement(sb.toString());
		rs = pst.executeQuery();
		User user = null;
		while(rs.next()){
			user = new User();
			user.setId(rs.getString(1));
			user.setUsername(rs.getString(2));
			user.setScore(rs.getString(3));
			user.setSum(rs.getString(4));
			user.setRemark(rs.getString(5));
			user.setOraltime(rs.getString(6));
			user.setSurvey1(rs.getString(7));
			list.add(user);
		}
		if(rs!=null){
			rs.close();
			rs = null;
		}
		if(pst!=null){
			pst.close();
			pst = null;
		}
		dbConn.close();
		return list;
	}
	@Override
	public void updateOralList(List<User> list) throws Exception {
		dbConn.openConnection();
		Connection conn = dbConn.getConn();
		conn.setAutoCommit(false);
		PreparedStatement pst = null;
		StringBuilder sb = new StringBuilder();
		sb.append("update userinfo set oraltime=? where id=?");
		pst = conn.prepareStatement(sb.toString());
		for (User user : list) {
			pst.setString(1, user.getOraltime());
			pst.setString(2, user.getId());
			pst.addBatch();
		}
		pst.executeBatch();
		conn.commit();
		if(pst!=null){
			pst.close();
			pst = null;
		}
		dbConn.close();
	}
	
}
