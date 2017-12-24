/**
 * 
 */
package com.collect.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.util.NodeList;

import com.collect.domain.CollUrl;
import com.collect.domain.IDentification;
import com.collect.domain.UrlContent;
import com.collect.domain.UserInfo;

/**
 * @author ���ı�
 *
 */
public class CaptureUrlServiceImpl implements CaptureUrlService {

	/**
	 * ���ز������ҳ��Ϣ
	 * @return UrlCollect
	 */
	@Override
	public UrlContent GetUrlContent(String url)
	{
		String weburl=GetHtml(url,"UTF-8");
		UrlContent urlcontent = null;
		System.out.println("��ҳ����1��"+weburl);
		System.out.println("����Ϊ:"+CharSet(weburl));
		if("utf-8".trim().equalsIgnoreCase(CharSet(weburl))==false)
		{
			weburl=GetHtml(url,CharSet(weburl));
			System.out.println("��ҳ����2��"+weburl);
			System.out.println("���Ϊ");
			urlcontent=new UrlContent(GetTitle(weburl), GetImg(weburl,url), GetDescribe(weburl));
		}
		else
		{
			urlcontent=new UrlContent(GetTitle(weburl), GetImg(weburl,url), GetDescribe(weburl));
		}
		
		System.out.println(urlcontent.toString()); 
		return urlcontent;	
	}
	
	/**
	 * ����������ҳ������
	 * @return String
	 */
	public String GetHtml(String weburl,String charset)
	{
	   String result="";//���ʷ��ؽ��
	   BufferedReader read=null;//��ȡ���ʽ��
	    
	   try {
			    //����url
			    URL realurl=new URL(weburl);
			    //������
			    URLConnection connection=realurl.openConnection();
			     // ����ͨ�õ���������
		         connection.setRequestProperty("accept", "*/*");
		         connection.setRequestProperty("connection", "Keep-Alive");
		         connection.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
		         
		         //��������
		         connection.connect();
		         // ��ȡ������Ӧͷ�ֶ�
		         Map<String, List<String>> map = connection.getHeaderFields();
		         
		         // �������е���Ӧͷ�ֶΣ���ȡ��cookies��
		         for (String key : map.keySet()) {
		             System.out.println(key + "--->" + map.get(key));
		         }
		         
		         // ���� BufferedReader����������ȡURL����Ӧ
		         read = new BufferedReader(new InputStreamReader(connection.getInputStream(),charset));
		         
		         String line;
		         //ѭ����ȡ
		         while ((line = read.readLine()) != null) {
		             result += line;
		         }
		         
		   } catch (IOException e) {
		    e.printStackTrace();
		   }finally
		   		{
			   		if(read!=null){//�ر���
			   		try {
				      read.close();
				     }catch (IOException e) {
				      e.printStackTrace();
				       }
			   		}	
		   		}     
		   return result; 
	}
	
	/**
	 * ����������ʽ��ȡ���Ⲣ����
	 * @return String title
	 */
	private String GetTitle(String url_content)
	{
		  String regex;  
		  String title = "";  
		  final List<String> list = new ArrayList<String>();  
		  regex = "<title>.*?</title>";  
		  final Pattern pa = Pattern.compile(regex, Pattern.CANON_EQ);  
		  final Matcher ma = pa.matcher(url_content);  
		  
		  while (ma.find())  
		  {  
		   list.add(ma.group());  
		  }  
		  for (int i = 0; i < list.size(); i++)  
		  {  
		   title = title + list.get(i);  
		  }  
		  return OutTag(title);  
	}
	
	/**
	 * ����������ʽ��ȡ��ҳlogo�����أ�ע�⣺���ص��ǵ�ַ��
	 * @return String img
	 */
	private String GetImg(String url_content,String url){
		  String regex;  
		  String img = "";  
		  final List<String> list = new ArrayList<String>();  
		  regex = "<link.*?/>";  
		  final Pattern pa = Pattern.compile(regex, Pattern.CANON_EQ);  
		  final Matcher ma = pa.matcher(url_content);  
		  
		  while (ma.find())
		  {  
		   list.add(ma.group());  
		  }  
		  
		  for (int i = 0; i < list.size(); i++)  
		  {
		   if(GetIco(list.get(i),url) != null)
			   {
			   img = GetIco(list.get(i),url);
			   break;
		   }
		  }  
		  return img;
	}
	
	 /**
	  * ��һ��Link���ҵ�����Ϊrel="shortcut ico"��href�����ݲ��ж�·�����Ƿ�����������
	  * @param link
	  * @param url
	  * @return
	  */
	 private String GetIco(String link,String url)
	 {
		  String regex;  
		  String ico = "";
		  if(link.contains("shortcut icon") || link.contains("icon"))
		  {
			  regex = "href=\"(.*?)\"";
			  final Pattern pat = Pattern.compile(regex, Pattern.CANON_EQ);  
			  final Matcher mat = pat.matcher(link);
			  mat.find();
			  ico=mat.group(1);
			  if(ico.startsWith("http:"))
			  {
				  return ico;
			  }
			  else if(ico.startsWith("//"))
			  {
				  return "http:"+ico;
			  }
			  else
			  {
				  try {
						URL host=new URL(url);
						ico="http://"+host.getHost()+ico;
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
				  return ico;
			  }
		  }
		  else
		  {
		  return null;
		  }
	 }
	 
	/**
	 * ����������ʽ��ȡ��ҳ�����ؼ��ʲ����أ�ע�⣺���ص��ǵ�ַ��
	 * @return String describe
	 */
	private String GetDescribe(String url_content)
	{
		String regex;  
		  String describe = "";  
		  final List<String> list = new ArrayList<String>();  
		  regex = "<meta.*?>";  
		  final Pattern pa = Pattern.compile(regex, Pattern.CANON_EQ);  
		  final Matcher ma = pa.matcher(url_content);  
		  
		  while (ma.find())
		  {  
		   list.add(ma.group());  
		  }  
		  
		  for (int i = 0; i < list.size(); i++)  
		  {
		   if(GetMate(list.get(i)) != null)
			   {
			   describe = GetMate(list.get(i));
			   break;
		   }
		  }  
		  return describe;
	}
	
	/**
	 * ��һ��meta���ҵ�����Ϊname="description"��content������
	 * @param mate
	 * @return
	 */
	private String GetMate(String mate)
	{
		  String regex;  
		  String describe = "";
		  if(mate.contains("name=\"description\"") || mate.contains("http-equiv=\"description\""))
		  {
			  regex = "content=\"(.*?)\"";
			  final Pattern pat = Pattern.compile(regex, Pattern.CANON_EQ);  
			  final Matcher mat = pat.matcher(mate);
			  mat.find();
			  describe=mat.group(1);
			  return describe;
		  }
		  else
		  {
		  return null;
		  }
	}
	/**
	 * ȥ�����
	 * @return ��ǩ�е�����
	 */
	 private static String OutTag(String ret)  
	 {  
	  return ret.replaceAll("<.*?>", "");  
	 }
	 
	 private String CharSet(String url_content)
	 {
		 String regex;  
		  String charset ="utf-8";  
		  final List<String> list = new ArrayList<String>();  
		  regex = "<meta.*?>";  
		  final Pattern pa = Pattern.compile(regex, Pattern.CANON_EQ);  
		  final Matcher ma = pa.matcher(url_content);  
		  
		  while (ma.find())
		  {  
		   list.add(ma.group());  
		  }  
		  
		  for (int i = 0; i < list.size(); i++)  
		  {
		  System.out.println(i+"+"+GetCharSet(list.get(i)));
		   if(GetCharSet(list.get(i)) != null)
			   {
			   charset = GetCharSet(list.get(i));
			   //��Ϊnull˵������ȡ��һ�ֱ����ʽ
			   break;
		   }
		  }  
		  return charset;
	 }
	 
	 /**
	  * ���ظ���ʲô�����ʽȡ������ҳ
	  * @param mate
	  * @return
	  */
	 private String GetCharSet(String mate)
		{ 
			  String charset = null;
			  if(mate.contains("charset="))
			  {
				  if(mate.contains("utf-8") ||mate.contains("UTF-8"))
				  {
					  charset="utf-8";
				  }
				  else if(mate.contains("gbk") || mate.contains("GBK"))
				  {
					  charset="gbk";
				  }
				  else if(mate.contains("gb2312") || mate.contains("GB2312"))
				  {
					  charset="gb2312";
				  }
				  return charset;	  
			  }
			  else
			  {
			  return charset;
			  }
		}

	@Override
	public void importMenu(File file,String email) {
		String HTML = openFile(file);
		List<CollUrl> colllist = new ArrayList<CollUrl>();
		System.out.println(HTML);
		try{  
            Parser parser = new Parser( HTML );  
           
            NodeFilter filter = new HasAttributeFilter("ADD_DATE");

            NodeList nodes = parser.extractAllNodesThatMatch(filter);

            
            if(nodes!=null) {
            	for (int i = 0; i < nodes.size(); i++) {
            	Node textnode = (Node) nodes.elementAt(i);
            	CollUrl collurlf= null;
            	collurlf=Browser(parser,textnode.toHtml());
            	if(collurlf != null)
            	colllist.add(collurlf);
            	}
            }
        }  
        catch( Exception e ) {              
        }
		UserInfoServic userser= new UserInfoServicImpl();
		
		UserInfo userloction = userser.getUserInfo(email);
		String loction = userloction.getLastloction()+1;
		int action = Integer.valueOf(loction);
		
		//ToolService tool = new ToolServiceImpl();
		//IDentification ID = tool.loadIdentification();
		//int collid = Integer.valueOf(ID.getCollid());
		
		UrlContentService collservice = new UrlContentServiceImpl();
		for(CollUrl coll:colllist)
		{
			System.out.println(coll.toString());
			if(coll.getTitle() != null )
			{
			//collid=collid+1;
			if(coll.isFather()==true)
			{
				action=action+1;
			}
			coll.setLoction(String.valueOf(action));
			//coll.setKid(String.valueOf(collid));
			coll.setFid(email);//�û�id
			
			collservice.addCollUrl(coll);
			}
		}
		
		userloction.setLastloction(String.valueOf(action));
		
		//userser.updataUserInfo(userloction);
		
		//ID.setCollid(String.valueOf(collid));
		//tool.updateIdentification(ID);
		
	}
	
	
	/**
	 * ��ÿһ����ҳת��Ϊurlcollect����
	 * @param parser
	 * @param textnode
	 * @return
	 */
	private static CollUrl Browser(Parser parser, String textnode)
	{
		  String regex360[] ={"LAST_MODIFIED=\"(.*?)\"","HREF=\"(.*?)\"","ADD_DATE=\"(.*?)\"","ICON=\"(.*?)\""};
		  CollUrl urlcoll = new CollUrl();
		  for(int i=0;i<regex360.length;i++)
		  {
			  String regex =regex360[i] ;  
			  final Pattern pa = Pattern.compile(regex, Pattern.CANON_EQ);  
			  final Matcher ma = pa.matcher(textnode);
			  while (ma.find())  
			  { 
			   String str=null;
			   str= ma.group(1);
			   if(i==0)
			   {
					  urlcoll.setFather(true);
					  final Pattern pa1 = Pattern.compile(">(.*?)</H3>", Pattern.CANON_EQ);  
					  final Matcher ma1 = pa1.matcher(textnode);
					  while (ma1.find())  
					  { 
						  urlcoll.setTitle(ma1.group(1)); 
					  }
			   }
			   else if(i==1)
			   {
				   urlcoll.setHref(str);
			   }
			   else if(i==2)
			   {
			   }
			   else
			   {
				   if(str !=null)
				   {
				      urlcoll.setFather(false);
				   	  final Pattern pa1 = Pattern.compile(">(.*?)</A>", Pattern.CANON_EQ);  
					  final Matcher ma1 = pa1.matcher(textnode);
					  while (ma1.find())  
					  { 
						  urlcoll.setTitle(ma1.group(1)); 
					  }

					  urlcoll.setLogo(str);
				   }
				   else
				   {
					  urlcoll=null;
					  break;
				   }
			   	 }
			  }  
		  }
		  System.out.println(urlcoll);
		  System.out.println();
		  return urlcoll;
	}
	
	private static String ENCODE = "UTF-8";
	
	/**
	 * ��ȡ��ҳ����
	 * @param szFileName
	 * @return
	 */
	public static String openFile(File file ) {
        try {  
            BufferedReader bis = new BufferedReader(new InputStreamReader(new FileInputStream(file), ENCODE) );  
            String szContent="";  
            String szTemp;  
              
            while ( (szTemp = bis.readLine()) != null) {  
                szContent+=szTemp+"\n";  
            }  
            bis.close();  
            return szContent;  
        }  
        catch( Exception e ) {  
        	System.out.println(e);
            return "";  
        }  
	}
	
	
	/** 
     * ����·�� ����ͼƬ Ȼ�� ���浽��Ӧ��Ŀ¼�� [20170514��ʱ�ò���]
     * @param urlString 
     * @param filename 
     * @param savePath 
     * @return 
     * @throws Exception 
     */  
    public static void download(String urlString) throws Exception {  
        // ����URL  
        URL url = new URL(urlString);  
        // ������  
        URLConnection con = url.openConnection();  
        //���������·��  
        con.setConnectTimeout(5*1000);  
        // ������  
        InputStream is = con.getInputStream();  
      
        // �̶�ȡ�����ݴ���ico��  
        byte[] ico=new byte[(is.available())];
        is.read(ico);
        String str = new String(ico, "utf-8");
        System.out.println(str);
        is.close();  
    }
    
}