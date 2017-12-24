package com.collect.service;

import java.util.List;

import com.collect.domain.CollList;
import com.collect.domain.CollUrl;
import com.collect.domain.UrlCollect;

public interface UrlContentService {
	public void addUrlContent(UrlCollect coll);
	public void removeContent(String kid);
	public String loadAllUrlContent();
	
	public void addCollUrl(CollUrl coll);
	public List<CollUrl> loadFIDCollUrl(String fid,boolean isfather);
	public List<CollUrl> loadLOCTIONCollUrl(String loction,boolean isfather,String email);
	
	public List<CollList> loadCollLIST(String email);
}
