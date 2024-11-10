package com.orm;

public class Goods {
	private int id;
	private String name1;
	private String miaoshu;
	private String pic;
	private int jiage;
	private String del;

	public String getDel() {
		return this.del;
	}

	public void setDel(String del) {
		this.del = del;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getJiage() {
		return this.jiage;
	}

	public void setJiage(int jiage) {
		this.jiage = jiage;
	}

	public String getMiaoshu() {
		return this.miaoshu;
	}

	public void setMiaoshu(String miaoshu) {
		this.miaoshu = miaoshu;
	}

	public String getName1() {
		return this.name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
}
