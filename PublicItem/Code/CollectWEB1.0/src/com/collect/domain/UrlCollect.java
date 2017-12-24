package com.collect.domain;

import java.util.Arrays;


public class UrlCollect {
	private String kid;
	private String tid;
	private String href;
	private byte[] logo;
	private String title;
	private String urldescribe;
	private String field;
	private boolean candidate;
	private boolean childen;
	private boolean open;
	private String fid;
	
	public UrlCollect() {
		super();
	}

	public UrlCollect(String kid, String tid, String href, byte[] logo,
			String title, String urldescribe, String field, boolean candidate,
			boolean childen, boolean open, String fid) {
		super();
		this.kid = kid;
		this.tid = tid;
		this.href = href;
		this.logo = logo;
		this.title = title;
		this.urldescribe = urldescribe;
		this.field = field;
		this.candidate = candidate;
		this.childen = childen;
		this.open = open;
		this.fid = fid;
	}

	public String getKid() {
		return kid;
	}

	public void setKid(String kid) {
		this.kid = kid;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrldescribe() {
		return urldescribe;
	}

	public void setUrldescribe(String urldescribe) {
		this.urldescribe = urldescribe;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public boolean isCandidate() {
		return candidate;
	}

	public void setCandidate(boolean candidate) {
		this.candidate = candidate;
	}

	public boolean isChilden() {
		return childen;
	}

	public void setChilden(boolean childen) {
		this.childen = childen;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	@Override
	public String toString() {
		return "UrlCollect [kid=" + kid + ", tid=" + tid + ", href=" + href
				+ ", logo=" + Arrays.toString(logo) + ", title=" + title
				+ ", urldescribe=" + urldescribe + ", field=" + field
				+ ", candidate=" + candidate + ", childen=" + childen
				+ ", open=" + open + ", fid=" + fid + "]";
	}
	
	
}