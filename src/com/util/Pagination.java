package com.util;

import java.util.List;

public class Pagination {
	private int totle;
	private int pageSize;
	private int totlePage;
	private int index;
	private List data;
	private String path;

	public void setTotle(int totle) {
		this.totle = totle;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getTotle() {
		return this.totle;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public int getTotlePage() {
		return (this.totle + this.pageSize - 1) / this.pageSize;
	}

	public int getIndex() {
		return this.index;
	}

	public List getData() {
		return this.data;
	}

	public void setData(List data) {
		this.data = data;
	}

	public String getPageDisplay() {
		StringBuffer displayInfo = new StringBuffer();
		if ((this.index == 0) || (this.pageSize == 0)) {
			displayInfo.append("没有分页的信息!");
		} else {
			displayInfo.append("<div>");
			displayInfo.append("共" + this.totle + "条记录&nbsp;&nbsp;&nbsp;&nbsp;每页<span style='color:#FF0000'>"
					+ this.pageSize + "</span>条&nbsp;&nbsp;&nbsp;&nbsp;");
			displayInfo.append("第<span style='color:#FF0000'>" + this.index + "</span>页/共" + getTotlePage()
					+ "页&nbsp;&nbsp;&nbsp;&nbsp;");
			if (this.index == 1) {
				displayInfo.append("首页&nbsp;&nbsp;&nbsp;&nbsp;");
				displayInfo.append("上一页&nbsp;&nbsp;&nbsp;&nbsp;");
			} else {
				displayInfo.append("<a href='" + this.path + "index=1'>首页&nbsp;&nbsp;&nbsp;&nbsp;</a>");
				displayInfo.append("<a href='" + this.path + "index=" + (this.index - 1)
						+ "'>上一页&nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;");
			}
			if (this.index >= getTotlePage()) {
				displayInfo.append("下一页&nbsp;&nbsp;&nbsp;&nbsp;");
				displayInfo.append("末页&nbsp;&nbsp;&nbsp;&nbsp;");
			} else {
				displayInfo.append(
						"<a href='" + this.path + "index=" + (this.index + 1) + "'>下一页&nbsp;&nbsp;&nbsp;&nbsp;</a>");
				displayInfo.append(
						"<a href='" + this.path + "index=" + getTotlePage() + "'>末页</a>&nbsp;&nbsp;&nbsp;&nbsp;");
			}
			displayInfo.append("</div>");
		}
		return displayInfo.toString();
	}
}
