package com.collect.service;

import java.io.File;

public class Test {

	public static void main(String[] args) {
		CaptureUrlService cap =new CaptureUrlServiceImpl();	
		File fi = new File("html/bookmarks.html");
		cap.importMenu(fi,"admin");
}
}
