package com.collect.dao;

import java.util.List;

import com.collect.domain.CollUrl;
import com.collect.domain.UrlCollect;

public interface UrlContentDao {
	public void addUrlContent(UrlCollect coll);
	public void removeContent(String kid);
	public List<UrlCollect> loadAllUrlContent();
	public List<UrlCollect> loadUrlContent(UrlCollect coll);
	
	public void addCollUrl(CollUrl coll);
	public List<CollUrl> loadFIDCollUrl(String fid,boolean isfather);
	public List<CollUrl> loadLOCTIONCollUrl(String loction,boolean isfather,String email);
}
