/**
 * 
 */
package com.collect.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.collect.domain.CollList;
import com.collect.domain.CollUrl;
import com.collect.domain.FeedBack;
import com.collect.domain.IDentification;
import com.collect.domain.UrlContent;
import com.collect.domain.UserInfo;
import com.collect.exception.CollException;
import com.collect.service.CaptureUrlService;
import com.collect.service.CaptureUrlServiceImpl;
import com.collect.service.ToolService;
import com.collect.service.ToolServiceImpl;
import com.collect.service.UrlContentService;
import com.collect.service.UrlContentServiceImpl;
import com.collect.service.UserInfoServic;
import com.collect.service.UserInfoServicImpl;
import com.collect.util.JsonUtil;
import com.collect.util.Tools;
import com.opensymphony.xwork2.ActionSupport;

/**基本类
 * @author 李文兵
 * 控制基本的事物流
 */
public class BasicAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;
	Map<String, Object> session;
	public UserInfo user;
	private String menuJsondata;
	private String fileJsondata;
	private String urlJsondata;
	private String data;
	private String msg;
	private String infodata;
	private String removekid;
	private List<CollList> collnavlist;
	private List<FeedBack> feedbacklist;
	private FeedBack feedback;
	
	CollUrl collurl = new CollUrl();
	
	public List<CollList> getCollnavlist() {
		return collnavlist;
	}

	public void setCollnavlist(List<CollList> collnavlist) {
		this.collnavlist = collnavlist;
	}
	
	
	public List<FeedBack> getFeedbacklist() {
		return feedbacklist;
	}

	public void setFeedbacklist(List<FeedBack> feedbacklist) {
		this.feedbacklist = feedbacklist;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public String getMenuJsondata() {
		return menuJsondata;
	}

	public void setMenuJsondata(String menuJsondata) {
		this.menuJsondata = menuJsondata;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	public String getFileJsondata() {
		return fileJsondata;
	}

	public void setFileJsondata(String fileJsondata) {
		this.fileJsondata = fileJsondata;
	}

	public String getUrlJsondata() {
		return urlJsondata;
	}

	public void setUrlJsondata(String urlJsondata) {
		this.urlJsondata = urlJsondata;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getInfodata() {
		return infodata;
	}

	public void setInfodata(String infodata) {
		this.infodata = infodata;
	}
	



	//相当于servlet中session范围
	//private Map<String, Object> session = null;
	
	public String getRemovekid() {
		return removekid;
	}

	public void setRemovekid(String removekid) {
		this.removekid = removekid;
	}

	public String ReFresh() throws Exception{
		
		this.user = (UserInfo) session.get("USER");
		this.data="null";
		UrlContentService ser = new UrlContentServiceImpl();
		this.collnavlist=ser.loadCollLIST(user.getUser_email());
		return "getdata";
	}
	
	public String ToClient() throws Exception{
		this.user = (UserInfo) session.get("USER");
		return "toClient";
	}
	
	public String NoLogin() throws Exception{
		this.user = (UserInfo) session.get("USER");
		return "nologin";
	}
		
	public String ToLogout() throws Exception{
		session.remove("USER");
		return "successlogout";
	}
	
	public String ToIndex() throws Exception{
		this.user = (UserInfo) session.get("USER");
		return "toindex";
	}
	
	public String IsLogin() throws Exception{
		
		this.user=(UserInfo)JsonUtil.getObje4JsonString(this.infodata, UserInfo.class);
		System.out.println("login:"+user);
		try {
			UserInfoServic user_ser = new UserInfoServicImpl();
			System.out.println("CheckUser前");
			user_ser.CheckUser(user);
			System.out.println("CheckUser后");
			session.put("USER", user);
		} catch (CollException e) {
			this.msg=e.getMessage();
			return "loginfailure";
		}
		this.msg=null;
		return "loginsuccess";
	}
	
	public String IsSign() throws Exception{
		this.user=(UserInfo)JsonUtil.getObje4JsonString(this.infodata, UserInfo.class);
		user.setLastloction("0");
		System.out.println("login:"+user);
		try {
			UserInfoServic user_ser = new UserInfoServicImpl();
			user_ser.CheckSign(user);
		} catch (CollException e) {
			this.msg=e.getMessage();
			return "signfailure";
		}
		this.msg=null;
		return "signsuccess";
	}
	
	public String AddMenu() throws Exception{
		try {
		this.user = (UserInfo) session.get("USER");
		
		ToolService ts = new ToolServiceImpl();
		IDentification ident = new IDentification();
		ident = ts.loadIdentification();
		String kid = String.valueOf(Integer.valueOf(ident.getCollid())+1);
		
		UserInfoServic userser= new UserInfoServicImpl();
		UserInfo userloction = userser.getUserInfo(user.getUser_email());
		String loction = String.valueOf(Integer.valueOf(userloction.getLastloction())+1);
		
		collurl=(CollUrl)JsonUtil.getObje4JsonString(this.menuJsondata, CollUrl.class);
		collurl.setKid(kid);
		collurl.setFather(true);
		collurl.setFid(user.getUser_email());
		collurl.setLoction(loction);
		
		System.out.println(this.menuJsondata);
		System.out.println(collurl);
		UrlContentService collurlser = new UrlContentServiceImpl();
		collurlser.addCollUrl(collurl);
		
		
		userloction.setLastloction(loction);
		userser.updataUserInfo(userloction);
		
		ident.setCollid(kid);
		ts.updateIdentification(ident);
		
		this.data="success";
		
		} catch (Exception e) {
			this.data="failure";
		}
		return "addok";
	}
	
	public String AddFile() throws Exception{
		try {
			ToolService ts = new ToolServiceImpl();
			IDentification ident = new IDentification();
			ident = ts.loadIdentification();
			String kid = String.valueOf(Integer.valueOf(ident.getCollid())+1);
			
			this.user = (UserInfo) session.get("USER");
			collurl=(CollUrl)JsonUtil.getObje4JsonString(this.fileJsondata, CollUrl.class);
			collurl.setKid(kid);
			collurl.setFather(false);
			collurl.setFid(user.getUser_email());
			
			UrlContentService collurlser = new UrlContentServiceImpl();
			collurlser.addCollUrl(collurl);
			
			ident.setCollid(kid);
			ts.updateIdentification(ident);
			this.data="success";
			
			} catch (Exception e) {
				this.data="failure";
			}
			return "addok";
	}

	public String RemoveUrl() throws Exception{
		UrlContentService se=new UrlContentServiceImpl();
		
		try {	
			se.removeContent(this.removekid);
			this.data="success";
			} catch (Exception e) {
				this.data="failure";
			}
			return "removeok";
	}
	
	public String AjaxFindUrl() throws Exception{

		String URL;
		URL=this.urlJsondata;
		
		if(URL != null)
		{
			CaptureUrlService url=new CaptureUrlServiceImpl();
			UrlContent urlContent=url.GetUrlContent(URL);

			collurl.setTitle(urlContent.getTitle());
			collurl.setLogo(urlContent.getLogo_adderss());

			this.urlJsondata = JsonUtil.getJsonString4JavaPOJO(collurl);
			System.out.println(this.urlJsondata);
		}
		return "geturldata";
	}

	public String ToCollnav() throws Exception {
			this.user = (UserInfo) session.get("USER");
			return "tocollnav";
		}
	
	public String ToCollshow() throws Exception {
		return "tocollshow";
	}

	public String ToFeedBack() throws Exception {
		this.user = (UserInfo) session.get("USER");
		ToolService tool = new ToolServiceImpl();
		feedbacklist = tool.loadAllFeedBack();
		return "toFeedBack";
	}
	
	
	public String AddFeedBreak() throws Exception {
		this.user = (UserInfo) session.get("USER");
		ToolService tool = new ToolServiceImpl();
		feedback.setFeedid(Tools.creatUUID());
		feedback.setFeedname(user.getUser_name());
		feedback.setFeednumber(1);
		feedback.setFeedcontent(feedback.getFeedcontent().substring(3, feedback.getFeedcontent().length()-6));
		tool.addFeedBack(feedback);
		
		return "tofeedback";
	}
	
	
	public String AddFeedNumber() throws Exception {
		ToolService tool = new ToolServiceImpl();
		
		FeedBack feed = tool.getFeedBack(data);
		this.data = String.valueOf(feed.getFeednumber()+1);
		feed.setFeednumber(feed.getFeednumber()+1);
		
		tool.updateFeedBack(feed);
		
	    System.err.println("feednumber="+data);
		return "addok";
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;	
	}

	public FeedBack getFeedback() {
		return feedback;
	}

	public void setFeedback(FeedBack feedback) {
		this.feedback = feedback;
	}

}
