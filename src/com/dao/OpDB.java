package com.dao;

import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OpDB {
	private DB mydb;

	public OpDB() {
		this.mydb = new DB();
	}

	public int OpUpdate(String sql, Object[] params) {
		int i = -1;
		this.mydb.doPstm(sql, params);
		try {
			i = this.mydb.getCount();
		} catch (SQLException e) {
			System.out.println("执行OpUpdate()方法失败！(更新数据库)");
			e.printStackTrace();
		} finally {
			this.mydb.closed();
		}
		return i;
	}

	public boolean LogOn(String sql, Object[] params) {
		this.mydb.doPstm(sql, params);
		try {
			ResultSet rs = this.mydb.getRs();
			boolean mark = (rs != null) && (rs.next());
			rs.close();
			return mark;
		} catch (SQLException e) {
			System.out.println("登录失败！");
			e.printStackTrace();
			return false;
		} finally {
			this.mydb.closed();
		}
	}
}
