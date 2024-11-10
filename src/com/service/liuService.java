package com.service;

import com.dao.DB;
import java.sql.ResultSet;

public class liuService {
	public static String getKefangleixingName(int id) {
		String name = "";

		String sql = "select * from t_kefangleixing where id=" + id;
		Object[] params = new Object[0];
		DB mydb = new DB();
		try {
			mydb.doPstm(sql, params);
			ResultSet rs = mydb.getRs();
			rs.next();
			name = rs.getString("name");
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mydb.closed();
		return name;
	}

	public static String getKefangFangjianhao(int id) {
		String fangjianhao = "";

		String sql = "select * from t_kefang where del='no' and id=" + id;
		Object[] params = new Object[0];
		DB mydb = new DB();
		try {
			mydb.doPstm(sql, params);
			ResultSet rs = mydb.getRs();
			rs.next();
			fangjianhao = rs.getString("fangjianhao");
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mydb.closed();
		return fangjianhao;
	}
}
