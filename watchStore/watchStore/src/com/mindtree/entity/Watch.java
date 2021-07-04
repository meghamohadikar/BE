package com.mindtree.entity;

public class Watch {
	private int wid;
	private int wmodelNumber;
	private int wPrice;
	private String tid;
	public Watch() {
		super();
	}
	public Watch(int wid, int wmodelNumber, int wPrice, String tid) {
		super();
		this.wid = wid;
		this.wmodelNumber = wmodelNumber;
		this.wPrice = wPrice;
		this.tid = tid;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public int getWmodelNumber() {
		return wmodelNumber;
	}
	public void setWmodelNumber(int wmodelNumber) {
		this.wmodelNumber = wmodelNumber;
	}
	public int getwPrice() {
		return wPrice;
	}
	public void setwPrice(int wPrice) {
		this.wPrice = wPrice;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String string) {
		this.tid = string;
	}
	@Override
	public String toString() {
		return "Watch [wid=" + wid + ", wmodelNumber=" + wmodelNumber + ", wPrice=" + wPrice + ", tid=" + tid + "]";
	}
	
	
	

}
