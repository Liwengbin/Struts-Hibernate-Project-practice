package com.collect.service;

import java.util.ArrayList;
import java.util.List;

import com.collect.dao.UrlContentDao;
import com.collect.dao.UrlContentDaoImpl;
import com.collect.domain.CollList;
import com.collect.domain.CollUrl;
import com.collect.domain.UrlCollect;

public class UrlContentServiceImpl implements UrlContentService {

	@Override
	public void addUrlContent(UrlCollect coll) {
		UrlContentDao condao=new UrlContentDaoImpl();
		condao.addUrlContent(coll);

	}

	@Override
	public String loadAllUrlContent() {
		UrlContentDao condao=new UrlContentDaoImpl();
		UrlCollect coll = new UrlCollect("admin","0", null, null, null, null, null, false, false, false, null);
		String str=collect(condao.loadUrlContent(coll),condao);
		return str.substring(1,str.length()-2);
	}
	
	private String collect(List<UrlCollect> collList,UrlContentDao condao)
	{
		String str2 = "]}";
		int i=1;
		int len =collList.size();
		System.out.println(len);
		for(UrlCollect col:collList)
		{
			String fo="";
			if(i != len)
			{
				fo=",";
			}
			if(col.isChilden())
			{	
				str2=fo+"{tid:\""+col.getTid()+"\",title: \""+col.getTitle()+"\", open:"+col.isOpen()+", children:"+collect(condao.loadUrlContent(col),condao)+str2;
			}
			else
			{
				str2=fo+"{tid:\""+col.getTid()+"\",title: \""+col.getTitle()+"\",logo: \""+col.getLogo()+"\", field: \""+col.getField()+"\", href:\""+col.getHref()+"\", candidate: "+col.isCandidate()+",childrenf:"+col.isChilden()+",open: "+col.isOpen()+",urldescribe: \""+col.getUrldescribe()+"\",fid: \""+col.getFid()+"\"}"+str2;
			}
			i++;
		}
		return "["+str2;
	}

	@Override
	public void addCollUrl(CollUrl coll) {
		UrlContentDao condao=new UrlContentDaoImpl();
		condao.addCollUrl(coll);
		
	}

	@Override
	public List<CollUrl> loadFIDCollUrl(String fid,boolean isfather) {
		UrlContentDao condao=new UrlContentDaoImpl();
		
		return condao.loadFIDCollUrl(fid,isfather);
	}

	@Override
	public List<CollUrl> loadLOCTIONCollUrl(String loction,boolean isfather,String email) {
		UrlContentDao condao=new UrlContentDaoImpl();
		
		return condao.loadLOCTIONCollUrl(loction,isfather,email);
	}

	@Override
	public List<CollList> loadCollLIST(String email) {
		UrlContentDao condao=new UrlContentDaoImpl();
		List<CollUrl> fatherlist = new ArrayList<CollUrl>();
		List<CollList> colllist = new ArrayList<CollList>();
		
		fatherlist=condao.loadFIDCollUrl(email, true);
		
		if(fatherlist != null){
			
		for(CollUrl coll:fatherlist)
		{
			System.out.println("¸¸Ç×="+coll.toString());
			CollList Colllistdomain = new CollList();
			Colllistdomain.setCollurl(coll);
			
			Colllistdomain.setColllist(condao.loadLOCTIONCollUrl(coll.getLoction(), false, email));
			
			colllist.add(Colllistdomain);
		}
		}
		else {
			System.out.println("¸¸Ç×Îª¿Õ£¡");
		}
		return colllist;
	}

	@Override
	public void removeContent(String kid) {
		UrlContentDao condao=new UrlContentDaoImpl();
		condao.removeContent(kid);
	}

}
