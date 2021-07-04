package com.mindtree.entity;

public class Type {
	private String tid;
	private String tname;
	public Type() {
		super();
	}
	public Type(String tid, String tname) {
		super();
		this.tid = tid;
		this.tname = tname;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	@Override
	public String toString() {
		return "Type [tid=" + tid + ", tname=" + tname + "]";
	}
	
	

}
