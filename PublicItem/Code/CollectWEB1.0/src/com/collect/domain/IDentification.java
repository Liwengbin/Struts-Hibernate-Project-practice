package com.collect.domain;

public class IDentification {
	private String id;
	private String userid;
	private String contentid;
	private String collid;
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getContentid() {
		return contentid;
	}

	public void setContentid(String contentid) {
		this.contentid = contentid;
	}

	public IDentification() {
		super();
	}

	public IDentification(String id, String userid, String contentid,
			String collid) {
		super();
		this.id = id;
		this.userid = userid;
		this.contentid = contentid;
		this.collid = collid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "IDentification [id=" + id + ", userid=" + userid
				+ ", contentid=" + contentid + "]";
	}

	public String getCollid() {
		return collid;
	}

	public void setCollid(String collid) {
		this.collid = collid;
	}
	
	
}
