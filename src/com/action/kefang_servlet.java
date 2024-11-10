package com.action;

import com.dao.DB;
import com.orm.Kefang;
import com.service.liuService;
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

public class kefang_servlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String type = req.getParameter("type");
		if (type.endsWith("kefangMana")) {
			kefangMana(req, res);
		}
		if (type.endsWith("kefangAdd")) {
			kefangAdd(req, res);
		}
		if (type.endsWith("kefangDel")) {
			kefangDel(req, res);
		}
	}

	public void kefangMana(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List kefangList = new ArrayList();
		String sql = "select * from t_kefang where del='no' order by kefangleixingId";
		Object[] params = new Object[0];
		DB mydb = new DB();
		try {
			mydb.doPstm(sql, params);
			ResultSet rs = mydb.getRs();
			while (rs.next()) {
				Kefang kefang = new Kefang();
				kefang.setId(rs.getInt("id"));
				kefang.setFangjianhao(rs.getString("fangjianhao"));
				kefang.setFangjianmianji(rs.getString("fangjianmianji"));
				kefang.setFangjianjianjie(rs.getString("fangjianjianjie"));
				kefang.setFujian(rs.getString("fujian"));
				kefang.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				kefang.setKefangleixingId(rs.getInt("kefangleixingId"));
				kefang.setKefangleixingName(liuService.getKefangleixingName(rs.getInt("kefangleixingId")));
				kefangList.add(kefang);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mydb.closed();

		req.setAttribute("kefangList", kefangList);
		req.getRequestDispatcher("admin/kefang/kefangMana.jsp").forward(req, res);
	}

	public void kefangAdd(HttpServletRequest req, HttpServletResponse res) {
		String fangjianhao = req.getParameter("fangjianhao");
		String fangjianmianji = req.getParameter("fangjianmianji");
		String fangjianjianjie = req.getParameter("fangjianjianjie");
		String fujian = req.getParameter("fujian");
		String fujianYuanshiming = req.getParameter("fujianYuanshiming");
		String kefangleixingId = req.getParameter("kefangleixingId");
		String del = "no";
		String sql = "insert into t_kefang(fangjianhao,fangjianmianji,fangjianjianjie,fujian,fujianYuanshiming,kefangleixingId,del) values(?,?,?,?,?,?,?)";
		Object[] params = { fangjianhao, fangjianmianji, fangjianjianjie, fujian, fujianYuanshiming,
				Integer.valueOf(Integer.parseInt(kefangleixingId)), del };
		DB mydb = new DB();
		mydb.doPstm(sql, params);
		mydb.closed();

		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "kefang?type=kefangMana");

		String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void kefangDel(HttpServletRequest req, HttpServletResponse res) {
		String sql = "update t_kefang set del='yes' where id=" + Integer.parseInt(req.getParameter("id"));
		Object[] params = new Object[0];
		DB mydb = new DB();
		mydb.doPstm(sql, params);
		mydb.closed();

		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "kefang?type=kefangMana");

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
