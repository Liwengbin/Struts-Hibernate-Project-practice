package com.collect.action;

import java.io.File;

import com.collect.domain.UserInfo;
import com.collect.service.CaptureUrlService;
import com.collect.service.CaptureUrlServiceImpl;

public class UserInfoAction extends BasicAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File importfile;
	private String importfileFileName;
	private String importfileContentType;


	public File getImportfile() {
		return importfile;
	}

	public void setImportfile(File importfile) {
		this.importfile = importfile;
	}

	public String getImportfileFileName() {
		return importfileFileName;
	}

	public void setImportfileFileName(String importfileFileName) {
		this.importfileFileName = importfileFileName;
	}

	public String getImportfileContentType() {
		return importfileContentType;
	}

	public void setImportfileContentType(String importfileContentType) {
		this.importfileContentType = importfileContentType;
	}

	public String ForImport() throws Exception {
		
		UserInfo user = (UserInfo) session.get("USER");
		if(importfile != null)
		{
		CaptureUrlService urlservice = new CaptureUrlServiceImpl();
		urlservice.importMenu(importfile,user.getUser_email());
		}
		return "successimport";
	}

}
