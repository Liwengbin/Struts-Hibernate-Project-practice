package com.collect.domain;

/**
 * @author 李文兵
 *
 */
public class CollUrl {
	private String kid;
	private String href;
	private String title;
	private String logo;
	private Boolean father;//是父亲吗
	private String loction;//网址所在的位置
	private String fid;//外键对应用户id
	
	public CollUrl() {
		super();
	}
	public String getKid() {
		return kid;
	}
	public void setKid(String kid) {
		this.kid = kid;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getLoction() {
		return loction;
	}
	public void setLoction(String loction) {
		this.loction = loction;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public CollUrl(String kid, String href, String title, String logo,
			Boolean father, String loction, String fid) {
		super();
		this.kid = kid;
		this.href = href;
		this.title = title;
		this.logo = logo;
		this.father = father;
		this.loction = loction;
		this.fid = fid;
	}
	public Boolean isFather() {
		return father;
	}
	public void setFather(Boolean father) {
		this.father = father;
	}

	@Override
	public String toString() {
		return "CollUrl [kid=" + kid + ", href=" + href + ", title=" + title
				+ ", logo=" + logo + ", father=" + father + ", loction="
				+ loction + ", fid=" + fid + "]";
	}
}
