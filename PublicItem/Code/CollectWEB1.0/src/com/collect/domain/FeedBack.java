package com.collect.domain;

public class FeedBack {
	private String feedid;
	private String feedname;
	private String feedcontent;
	private Integer feednumber;
	
	public FeedBack(String feedname, String feedcontent, Integer feednumber,String feedid) {
		super();
		this.feedname = feedname;
		this.feedcontent = feedcontent;
		this.feednumber = feednumber;
		this.feedid = feedid;
	}

	public FeedBack() {
		super();
	}

	public String getFeedid() {
		return feedid;
	}

	public void setFeedid(String feedid) {
		this.feedid = feedid;
	}

	public String getFeedname() {
		return feedname;
	}

	public void setFeedname(String feedname) {
		this.feedname = feedname;
	}

	public String getFeedcontent() {
		return feedcontent;
	}

	public void setFeedcontent(String feedcontent) {
		this.feedcontent = feedcontent;
	}

	public Integer getFeednumber() {
		return feednumber;
	}

	public void setFeednumber(Integer feednumber) {
		this.feednumber = feednumber;
	}

	@Override
	public String toString() {
		return "FeedBack [feedname=" + feedname + ", feedcontent="
				+ feedcontent + ", feednumber=" + feednumber + "]";
	}
	
}
