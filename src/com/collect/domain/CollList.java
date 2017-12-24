package com.collect.domain;

import java.util.List;

public class CollList {
	private CollUrl collurl;
	private List<CollUrl> colllist;

	public CollList() {
		super();
	}

	public CollList(CollUrl collurl, List<CollUrl> colllist) {
		super();
		this.collurl = collurl;
		this.colllist = colllist;
	}

	public CollUrl getCollurl() {
		return collurl;
	}

	public void setCollurl(CollUrl collurl) {
		this.collurl = collurl;
	}

	public List<CollUrl> getColllist() {
		return colllist;
	}

	public void setColllist(List<CollUrl> colllist) {
		this.colllist = colllist;
	}

	@Override
	public String toString() {
		return "CollList [collurl=" + collurl.toString() + ", colllist=" + colllist.toString() + "]";
	}

}
