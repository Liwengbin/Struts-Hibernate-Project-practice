package com.collect.service;

import java.util.List;

import com.collect.dao.ToolDao;
import com.collect.dao.ToolDaoImpl;
import com.collect.domain.FeedBack;
import com.collect.domain.IDentification;

public class ToolServiceImpl implements ToolService {

	@Override
	public void updateIdentification(IDentification ident) {
		ToolDao tool_dao = new ToolDaoImpl();
		
		tool_dao.updateIdentification(ident);
	}

	@Override
	public IDentification loadIdentification() {
		ToolDao tool_dao = new ToolDaoImpl();
		
		return tool_dao.loadIdentification();
	}

	@Override
	public void addFeedBack(FeedBack feed) {
		ToolDao tool_dao = new ToolDaoImpl();
		
		tool_dao.addFeedBack(feed);
	}

	@Override
	public void updateFeedBack(FeedBack feed) {
		ToolDao tool_dao = new ToolDaoImpl();
		
		tool_dao.updateFeedBack(feed);
	}

	@Override
	public List<FeedBack> loadAllFeedBack() {
		ToolDao tool_dao = new ToolDaoImpl();
		
		return tool_dao.loadAllFeedBack();
	}

	@Override
	public FeedBack getFeedBack(String feedid) {
        ToolDao tool_dao = new ToolDaoImpl();
		
		return tool_dao.getFeedBack(feedid);
	}

}
