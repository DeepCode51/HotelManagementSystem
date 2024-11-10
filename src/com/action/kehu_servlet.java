package com.action;

import com.dao.DB;
import com.orm.kehu;
import java.io.IOException;
import java.io.PrintStream;
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

public class kehu_servlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String type = req.getParameter("type");
		if (type.endsWith("kehuAdd")) {
			kehuAdd(req, res);
		}
		if (type.endsWith("kehuMana")) {
			kehuMana(req, res);
		}
		if (type.endsWith("kehuDel")) {
			kehuDel(req, res);
		}
		if (type.endsWith("kehuEdit")) {
			kehuEdit(req, res);
		}
		if (type.endsWith("kehuSearch")) {
			kehuSearch(req, res);
		}
		if (type.endsWith("kehuXinxi")) {
			kehuXinxi(req, res);
		}
	}

	public void kehuAdd(HttpServletRequest req, HttpServletResponse res) {
		String mingcheng = req.getParameter("mingcheng");
		String dizhi = req.getParameter("dizhi");
		String lianxiren = req.getParameter("lianxiren");
		String dianhua = req.getParameter("dianhua");
		String youbian = req.getParameter("youbian");
		String chuanzhen = req.getParameter("chuanzhen");
		String youxiang = req.getParameter("youxiang");

		String sql = "insert into t_kehu(mingcheng,dizhi,lianxiren,dianhua,youbian,chuanzhen,youxiang,kahuhang,zhanghao,type,del) values(?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = { mingcheng, dizhi, lianxiren, dianhua, youbian, chuanzhen, youxiang, "", "", "kehu", "no" };
		DB mydb = new DB();
		mydb.doPstm(sql, params);
		mydb.closed();

		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "kehu?type=kehuMana");

		String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void kehuDel(HttpServletRequest req, HttpServletResponse res) {
		int id = Integer.parseInt(req.getParameter("id"));

		String sql = "update t_kehu set del='yes' where id=?";
		Object[] params = { Integer.valueOf(id) };
		DB mydb = new DB();
		mydb.doPstm(sql, params);
		mydb.closed();

		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "kehu?type=kehuMana");

		String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void kehuMana(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List kehuList = new ArrayList();
		String sql = "select * from t_kehu where type='kehu' and del='no'";
		Object[] params = new Object[0];
		DB mydb = new DB();
		try {
			mydb.doPstm(sql, params);
			ResultSet rs = mydb.getRs();
			while (rs.next()) {
				kehu kehu = new kehu();
				kehu.setId(rs.getInt("id"));
				kehu.setMingcheng(rs.getString("mingcheng"));
				kehu.setDizhi(rs.getString("dizhi"));
				kehu.setLianxiren(rs.getString("lianxiren"));
				kehu.setDianhua(rs.getString("dianhua"));
				kehu.setYoubian(rs.getString("youbian"));
				kehu.setChuanzhen(rs.getString("chuanzhen"));
				kehu.setYouxiang(rs.getString("youxiang"));
				kehuList.add(kehu);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mydb.closed();

		req.setAttribute("kehuList", kehuList);
		req.getRequestDispatcher("admin/kehu/kehuMana.jsp").forward(req, res);
	}

	public void kehuXinxi(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List kehuList = new ArrayList();
		String sql = "select * from t_kehu where type='kehu' and id=?";
		Object[] params = { Integer.valueOf(Integer.parseInt(req.getParameter("kehu_id"))) };
		DB mydb = new DB();
		try {
			mydb.doPstm(sql, params);
			ResultSet rs = mydb.getRs();
			while (rs.next()) {
				kehu kehu = new kehu();
				kehu.setId(rs.getInt("id"));
				kehu.setMingcheng(rs.getString("mingcheng"));
				kehu.setDizhi(rs.getString("dizhi"));
				kehu.setLianxiren(rs.getString("lianxiren"));
				kehu.setDianhua(rs.getString("dianhua"));
				kehu.setYoubian(rs.getString("youbian"));
				kehu.setChuanzhen(rs.getString("chuanzhen"));
				kehu.setYouxiang(rs.getString("youxiang"));
				kehuList.add(kehu);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mydb.closed();

		req.setAttribute("kehuList", kehuList);
		req.getRequestDispatcher("admin/kehu/kehuXinxi.jsp").forward(req, res);
	}

	public void kehuEdit(HttpServletRequest req, HttpServletResponse res) {
		int id = Integer.parseInt(req.getParameter("id"));
		String mingcheng = req.getParameter("mingcheng");
		String dizhi = req.getParameter("dizhi");
		String lianxiren = req.getParameter("lianxiren");
		String dianhua = req.getParameter("dianhua");
		String youbian = req.getParameter("youbian");
		String chuanzhen = req.getParameter("chuanzhen");
		String youxiang = req.getParameter("youxiang");

		String sql = "update t_kehu set mingcheng=?,dizhi=?,lianxiren=?,dianhua=?,youbian=?,chuanzhen=?,youxiang=? where id="
				+ id;
		Object[] params = { mingcheng, dizhi, lianxiren, dianhua, youbian, chuanzhen, youxiang };
		DB mydb = new DB();
		mydb.doPstm(sql, params);
		mydb.closed();

		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "kehu?type=kehuMana");

		String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void kehuSearch(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List kehuList = new ArrayList();
		String sql = "select * from t_kehu where type='kehu' and del='no' and mingcheng like '%"
				+ req.getParameter("mingcheng").trim() + "%'";

		System.out.println(sql);
		Object[] params = new Object[0];
		DB mydb = new DB();
		try {
			mydb.doPstm(sql, params);
			ResultSet rs = mydb.getRs();
			while (rs.next()) {
				kehu kehu = new kehu();
				kehu.setId(rs.getInt("id"));
				kehu.setMingcheng(rs.getString("mingcheng"));
				kehu.setDizhi(rs.getString("dizhi"));
				kehu.setLianxiren(rs.getString("lianxiren"));
				kehu.setDianhua(rs.getString("dianhua"));
				kehu.setYoubian(rs.getString("youbian"));
				kehu.setChuanzhen(rs.getString("chuanzhen"));
				kehu.setYouxiang(rs.getString("youxiang"));
				kehuList.add(kehu);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mydb.closed();

		req.setAttribute("kehuList", kehuList);
		req.getRequestDispatcher("admin/kehu/kehuMana.jsp").forward(req, res);
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
