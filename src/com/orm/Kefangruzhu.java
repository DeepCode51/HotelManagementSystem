package com.orm;

public class Kefangruzhu {
	private int id;
	private int kefang_id;
	private String shijian;
	private String kehuname;
	private String kehutel;
	private String tianshu;
	private int xiaofeijine;
	private String del;
	private String kefang_fanjianhao;

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

	public String getKefang_fanjianhao() {
		return this.kefang_fanjianhao;
	}

	public void setKefang_fanjianhao(String kefang_fanjianhao) {
		this.kefang_fanjianhao = kefang_fanjianhao;
	}

	public int getXiaofeijine() {
		return this.xiaofeijine;
	}

	public void setXiaofeijine(int xiaofeijine) {
		this.xiaofeijine = xiaofeijine;
	}

	public int getKefang_id() {
		return this.kefang_id;
	}

	public void setKefang_id(int kefang_id) {
		this.kefang_id = kefang_id;
	}

	public String getKehuname() {
		return this.kehuname;
	}

	public void setKehuname(String kehuname) {
		this.kehuname = kehuname;
	}

	public String getKehutel() {
		return this.kehutel;
	}

	public void setKehutel(String kehutel) {
		this.kehutel = kehutel;
	}

	public String getShijian() {
		return this.shijian;
	}

	public void setShijian(String shijian) {
		this.shijian = shijian;
	}

	public String getTianshu() {
		return this.tianshu;
	}

	public void setTianshu(String tianshu) {
		this.tianshu = tianshu;
	}
}
