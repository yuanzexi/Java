package com.yzx.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConn {
	private String username = null;
	private String password = null;
	private String url = null;
	private String driver = null;
	private Connection conn = null;
	
	
	
	public Connection getConn() {
		return conn;
	}

	public void init() {
		try {
			username = Config.DB_USERNAME;
			password = Config.DB_PASSWORD;
			url = Config.DB_URL;
			driver = Config.DB_DRIVER;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openConnection() throws Exception{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, username, password);
	}
	
	public void close(){
		if(conn != null){
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
