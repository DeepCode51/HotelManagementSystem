package com.dao;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {
	private Connection con;
	private PreparedStatement pstm;
	private String user = "root";
	private String password = "123456";
	private String className = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/graduation_58_db_jiudian?useUnicode=true&amp;amp;amp;amp;amp;amp;characterEncoding=utf-8";

	public DB() {
		try {
			Class.forName(this.className);
		} catch (ClassNotFoundException e) {
			System.out.println("加载数据库驱动失败！");
			e.printStackTrace();
		}
	}

	public Connection getCon() {
		try {
			this.con = DriverManager.getConnection(this.url, this.user, this.password);
		} catch (SQLException e) {
			System.out.println("创建数据库连接失败！");
			this.con = null;
			e.printStackTrace();
		}
		return this.con;
	}

	public void doPstm(String sql, Object[] params) {
		if ((sql != null) && (!sql.equals(""))) {
			if (params == null) {
				params = new Object[0];
			}
			getCon();
			if (this.con != null) {
				try {
					System.out.println(sql);
					this.pstm = this.con.prepareStatement(sql, 1004, 1007);
					for (int i = 0; i < params.length; i++) {
						this.pstm.setObject(i + 1, params[i]);
					}
					this.pstm.execute();
				} catch (SQLException e) {
					System.out.println("doPstm()方法出错！");
					e.printStackTrace();
				}
			}
		}
	}

	public ResultSet getRs() throws SQLException {
		return this.pstm.getResultSet();
	}

	public int getCount() throws SQLException {
		return this.pstm.getUpdateCount();
	}

	public void closed() {
		try {
			if (this.pstm != null) {
				this.pstm.close();
			}
		} catch (SQLException e) {
			System.out.println("关闭pstm对象失败！");
			e.printStackTrace();
		}
		try {
			if (this.con != null) {
				this.con.close();
			}
		} catch (SQLException e) {
			System.out.println("关闭con对象失败！");
			e.printStackTrace();
		}
	}
}
