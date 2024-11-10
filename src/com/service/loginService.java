package com.service;

import com.dao.DB;
import com.orm.Kefang;
import com.orm.Kefangleixing;
import com.orm.TAdmin;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

public class loginService {
	public String login(String userName, String userPw, int userType) {
		System.out.println("userType" + userType);
		try {
			Thread.sleep(700L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String result = "no";
		if (userType == 0) {
			String sql = "select * from t_admin where userName=? and userPw=?";
			Object[] params = { userName, userPw };
			DB mydb = new DB();
			mydb.doPstm(sql, params);
			try {
				ResultSet rs = mydb.getRs();
				boolean mark = (rs != null) && (rs.next());
				if (!mark) {
					result = "no";
				} else {
					result = "yes";
					TAdmin admin = new TAdmin();
					admin.setUserId(rs.getInt("userId"));
					admin.setUserName(rs.getString("userName"));
					admin.setUserPw(rs.getString("userPw"));
					WebContext ctx = WebContextFactory.get();
					HttpSession session = ctx.getSession();
					session.setAttribute("userType", Integer.valueOf(0));
					session.setAttribute("admin", admin);
				}
				rs.close();
			} catch (SQLException e) {
				System.out.println("µÇÂ¼Ê§°Ü£¡");
				e.printStackTrace();
			} finally {
				mydb.closed();
			}
		}
		return result;
	}

	public String adminPwEdit(String userPwNew) {
		System.out.println("DDDD");
		try {
			Thread.sleep(700L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebContext ctx = WebContextFactory.get();
		HttpSession session = ctx.getSession();
		TAdmin admin = (TAdmin) session.getAttribute("admin");

		String sql = "update t_admin set userPw=? where userId=?";
		Object[] params = { userPwNew, Integer.valueOf(admin.getUserId()) };
		DB mydb = new DB();
		mydb.doPstm(sql, params);

		return "yes";
	}

	public List kefangleixingSelect() {
		List kefangleixingList = new ArrayList();
		String sql = "select * from t_kefangleixing where del='no'";
		Object[] params = new Object[0];
		DB mydb = new DB();
		try {
			mydb.doPstm(sql, params);
			ResultSet rs = mydb.getRs();
			while (rs.next()) {
				Kefangleixing kefangleixing = new Kefangleixing();
				kefangleixing.setId(rs.getInt("id"));
				kefangleixing.setName(rs.getString("name"));
				kefangleixingList.add(kefangleixing);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mydb.closed();
		return kefangleixingList;
	}

	public List kefangSelect() {
		List kefangList = new ArrayList();
		String sql = "select * from t_kefang where del='no'";
		Object[] params = new Object[0];
		DB mydb = new DB();
		try {
			mydb.doPstm(sql, params);
			ResultSet rs = mydb.getRs();
			while (rs.next()) {
				Kefang kefang = new Kefang();
				kefang.setId(rs.getInt("id"));
				kefang.setFangjianhao(rs.getString("fangjianhao"));
				kefangList.add(kefang);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mydb.closed();
		return kefangList;
	}
}
