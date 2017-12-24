/**
 * 
 */
package com.collect.domain;

/**
 * @author 李文兵
 * 网站信息类，用于储存捕获信息
 */
public class UrlContent {
	private String title;
	private String logo_adderss;
	private String describe;
	
	public UrlContent(String title, String logo_adderss, String describe) {
		super();
		this.title = title;
		this.logo_adderss = logo_adderss;
		this.describe = describe;
	}
	public UrlContent() {
		super();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLogo_adderss() {
		return logo_adderss;
	}
	public void setLogo_adderss(String logo_adderss) {
		this.logo_adderss = logo_adderss;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	@Override
	public String toString() {
		return "UrlContent [title=" + title + ", logo_adderss=" + logo_adderss
				+ ", describe=" + describe + "]";
	}
}
