/**
 * 
 */
package com.collect.service;

import java.util.List;

import com.collect.domain.FeedBack;
import com.collect.domain.IDentification;

/**
 * @author ÀîÎÄ±ø
 *
 */
public interface ToolService {
	public void updateIdentification(IDentification ident);
	public IDentification loadIdentification();
	
	public void addFeedBack(FeedBack feed);
	public void updateFeedBack(FeedBack feed);
	public List<FeedBack> loadAllFeedBack();
	public FeedBack getFeedBack(String feedid);
}
