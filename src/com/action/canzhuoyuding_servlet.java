package com.action;

import com.dao.DB;
import com.orm.Canzhuoyuding;
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

public class canzhuoyuding_servlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String type = req.getParameter("type");
		if (type.endsWith("canzhuoyudingMana")) {
			canzhuoyudingMana(req, res);
		}
		if (type.endsWith("canzhuoyudingAdd")) {
			canzhuoyudingAdd(req, res);
		}
		if (type.endsWith("canzhuoyudingDel")) {
			canzhuoyudingDel(req, res);
		}
	}

	public void canzhuoyudingAdd(HttpServletRequest req, HttpServletResponse res) {
		String shijian = req.getParameter("shijian");
		String kehuname = req.getParameter("kehuname");
		String zhuohao = req.getParameter("zhuohao");
		String del = "no";
		String sql = "insert into t_canzhuoyuding(shijian,kehuname,zhuohao,del) values(?,?,?,?)";
		Object[] params = { shijian, kehuname, zhuohao, del };
		DB mydb = new DB();
		mydb.doPstm(sql, params);
		mydb.closed();

		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "canzhuoyuding?type=canzhuoyudingMana");

		String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void canzhuoyudingDel(HttpServletRequest req, HttpServletResponse res) {
		String sql = "update t_canzhuoyuding set del='yes' where id=" + Integer.parseInt(req.getParameter("id"));
		Object[] params = new Object[0];
		DB mydb = new DB();
		mydb.doPstm(sql, params);
		mydb.closed();

		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "canzhuoyuding?type=canzhuoyudingMana");

		String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void canzhuoyudingMana(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		List canzhuoyudingList = new ArrayList();
		String sql = "select * from t_canzhuoyuding where del='no'";
		Object[] params = new Object[0];
		DB mydb = new DB();
		try {
			mydb.doPstm(sql, params);
			ResultSet rs = mydb.getRs();
			while (rs.next()) {
				Canzhuoyuding canzhuoyuding = new Canzhuoyuding();
				canzhuoyuding.setId(rs.getInt("id"));
				canzhuoyuding.setShijian(rs.getString("shijian"));
				canzhuoyuding.setKehuname(rs.getString("kehuname"));
				canzhuoyuding.setZhuohao(rs.getString("zhuohao"));
				canzhuoyudingList.add(canzhuoyuding);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mydb.closed();

		req.setAttribute("canzhuoyudingList", canzhuoyudingList);
		req.getRequestDispatcher("admin/canzhuoyuding/canzhuoyudingMana.jsp").forward(req, res);
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
