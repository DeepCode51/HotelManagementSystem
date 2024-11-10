package com.action;

import com.dao.DB;
import com.orm.Kefangruzhu;
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

public class kefangruzhu_servlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String type = req.getParameter("type");
		if (type.endsWith("kefangruzhuMana")) {
			kefangruzhuMana(req, res);
		}
		if (type.endsWith("kefangruzhuAdd")) {
			kefangruzhuAdd(req, res);
		}
		if (type.endsWith("kefangruzhuDel")) {
			kefangruzhuDel(req, res);
		}
	}

	public void kefangruzhuAdd(HttpServletRequest req, HttpServletResponse res) {
		int kefang_id = Integer.parseInt(req.getParameter("kefang_id"));
		String shijian = req.getParameter("shijian");
		String kehuname = req.getParameter("kehuname");
		String kehutel = req.getParameter("kehutel");
		String tianshu = req.getParameter("tianshu");
		String xiaofeijine = req.getParameter("xiaofeijine");
		String del = "no";
		String sql = "insert into t_kefangruzhu(kefang_id,shijian,kehuname,kehutel,tianshu,xiaofeijine,del) values(?,?,?,?,?,?,?)";
		Object[] params = { Integer.valueOf(kefang_id), shijian, kehuname, kehutel, tianshu, xiaofeijine, del };
		DB mydb = new DB();
		mydb.doPstm(sql, params);
		mydb.closed();

		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "kefangruzhu?type=kefangruzhuMana");

		String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void kefangruzhuDel(HttpServletRequest req, HttpServletResponse res) {
		String sql = "update t_kefangruzhu set del='yes' where id=" + Integer.parseInt(req.getParameter("id"));
		Object[] params = new Object[0];
		DB mydb = new DB();
		mydb.doPstm(sql, params);
		mydb.closed();

		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "kefangruzhu?type=kefangruzhuMana");

		String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void kefangruzhuMana(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List kefangruzhuList = new ArrayList();
		String sql = "select * from t_kefangruzhu where del='no'";
		Object[] params = new Object[0];
		DB mydb = new DB();
		try {
			mydb.doPstm(sql, params);
			ResultSet rs = mydb.getRs();
			while (rs.next()) {
				Kefangruzhu kefangruzhu = new Kefangruzhu();
				kefangruzhu.setId(rs.getInt("id"));
				kefangruzhu.setKefang_id(rs.getInt("kefang_id"));
				kefangruzhu.setShijian(rs.getString("shijian"));
				kefangruzhu.setKehuname(rs.getString("kehuname"));
				kefangruzhu.setKehutel(rs.getString("kehutel"));
				kefangruzhu.setTianshu(rs.getString("tianshu"));
				kefangruzhu.setXiaofeijine(rs.getInt("xiaofeijine"));
				kefangruzhu.setKefang_fanjianhao(liuService.getKefangFangjianhao(rs.getInt("kefang_id")));
				kefangruzhuList.add(kefangruzhu);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mydb.closed();

		req.setAttribute("kefangruzhuList", kefangruzhuList);
		req.getRequestDispatcher("admin/kefangruzhu/kefangruzhuMana.jsp").forward(req, res);
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
