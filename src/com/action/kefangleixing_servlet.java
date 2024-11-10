package com.action;

import com.dao.DB;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class kefangleixing_servlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String type = req.getParameter("type");
		if (type.endsWith("kefangleixingMana")) {
			kefangleixingMana(req, res);
		}
		if (type.endsWith("kefangleixingAdd")) {
			kefangleixingAdd(req, res);
		}
		if (type.endsWith("kefangleixingDel")) {
			kefangleixingDel(req, res);
		}
		if (type.endsWith("kefangleixingEdit")) {
			kefangleixingEdit(req, res);
		}
	}

	public void kefangleixingMana(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		List kefangleixingList = new ArrayList();
		String sql = "select * from t_kefangleixing where del='no'";
		Object[] params = new Object[0];
		DB mydb = new DB();
		try {
			mydb.doPstm(sql, params);
			ResultSet rs = mydb.getRs();
			while (rs.next()) {
				List kefangleixing = new ArrayList();
				kefangleixing.add(rs.getString("id"));
				kefangleixing.add(rs.getString("name"));
				kefangleixing.add(rs.getString("beizhu"));
				kefangleixing.add(rs.getString("del"));
				kefangleixingList.add(kefangleixing);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mydb.closed();

		req.setAttribute("kefangleixingList", kefangleixingList);
		req.getRequestDispatcher("admin/kefangleixing/kefangleixingMana.jsp").forward(req, res);
	}

	public void kefangleixingAdd(HttpServletRequest req, HttpServletResponse res) {
		String name = req.getParameter("name");
		String beizhu = "";
		String del = "no";
		String sql = "insert into t_kefangleixing(name,beizhu,del) values(?,?,?)";
		Object[] params = { name, beizhu, del };
		DB mydb = new DB();
		mydb.doPstm(sql, params);
		mydb.closed();

		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "kefangleixing?type=kefangleixingMana");

		String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void kefangleixingDel(HttpServletRequest req, HttpServletResponse res) {
		String sql = "update t_kefangleixing set del='yes' where id=" + Integer.parseInt(req.getParameter("id"));
		Object[] params = new Object[0];
		DB mydb = new DB();
		mydb.doPstm(sql, params);
		mydb.closed();

		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "kefangleixing?type=kefangleixingMana");

		String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void kefangleixingEdit(HttpServletRequest req, HttpServletResponse res) {
		String name = req.getParameter("name");
		String beizhu = "";
		String del = "no";
		String sql = "update t_kefangleixing set name=? where id=" + Integer.parseInt(req.getParameter("id"));
		Object[] params = { name };
		DB mydb = new DB();
		mydb.doPstm(sql, params);
		mydb.closed();

		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "kefangleixing?type=kefangleixingMana");

		String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void dispatch(String targetURI, HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(targetURI);
		try {
			dispatch.forward(request, response);
			return;
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void destroy() {
	}
}
