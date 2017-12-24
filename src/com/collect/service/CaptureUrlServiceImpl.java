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
 * @author 李文兵
 *
 */
public class CaptureUrlServiceImpl implements CaptureUrlService {

	/**
	 * 返回捕获的网页信息
	 * @return UrlCollect
	 */
	@Override
	public UrlContent GetUrlContent(String url)
	{
		String weburl=GetHtml(url,"UTF-8");
		UrlContent urlcontent = null;
		System.out.println("网页内容1："+weburl);
		System.out.println("编码为:"+CharSet(weburl));
		if("utf-8".trim().equalsIgnoreCase(CharSet(weburl))==false)
		{
			weburl=GetHtml(url,CharSet(weburl));
			System.out.println("网页内容2："+weburl);
			System.out.println("结果为");
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
	 * 返回整个网页的数据
	 * @return String
	 */
	public String GetHtml(String weburl,String charset)
	{
	   String result="";//访问返回结果
	   BufferedReader read=null;//读取访问结果
	    
	   try {
			    //创建url
			    URL realurl=new URL(weburl);
			    //打开连接
			    URLConnection connection=realurl.openConnection();
			     // 设置通用的请求属性
		         connection.setRequestProperty("accept", "*/*");
		         connection.setRequestProperty("connection", "Keep-Alive");
		         connection.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
		         
		         //建立连接
		         connection.connect();
		         // 获取所有响应头字段
		         Map<String, List<String>> map = connection.getHeaderFields();
		         
		         // 遍历所有的响应头字段，获取到cookies等
		         for (String key : map.keySet()) {
		             System.out.println(key + "--->" + map.get(key));
		         }
		         
		         // 定义 BufferedReader输入流来读取URL的响应
		         read = new BufferedReader(new InputStreamReader(connection.getInputStream(),charset));
		         
		         String line;
		         //循环读取
		         while ((line = read.readLine()) != null) {
		             result += line;
		         }
		         
		   } catch (IOException e) {
		    e.printStackTrace();
		   }finally
		   		{
			   		if(read!=null){//关闭流
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
	 * 利用正则表达式获取标题并返回
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
	 * 利用正则表达式获取网页logo并返回（注意：返回的是地址）
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
	  * 在一个Link中找到属性为rel="shortcut ico"的href的内容并判断路径名是否完整并返回
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
	 * 利用正则表达式获取网页描述关键词并返回（注意：返回的是地址）
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
	 * 在一个meta中找到属性为name="description"的content的内容
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
	 * 去除标记
	 * @return 标签中的内容
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
			   //不为null说明至少取到一种编码格式
			   break;
		   }
		  }  
		  return charset;
	 }
	 
	 /**
	  * 返回该用什么编码格式取解析网页
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
			coll.setFid(email);//用户id
			
			collservice.addCollUrl(coll);
			}
		}
		
		userloction.setLastloction(String.valueOf(action));
		
		//userser.updataUserInfo(userloction);
		
		//ID.setCollid(String.valueOf(collid));
		//tool.updateIdentification(ID);
		
	}
	
	
	/**
	 * 将每一个网页转换为urlcollect对象
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
	 * 读取网页内容
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
     * 根据路径 下载图片 然后 保存到对应的目录下 [20170514暂时用不到]
     * @param urlString 
     * @param filename 
     * @param savePath 
     * @return 
     * @throws Exception 
     */  
    public static void download(String urlString) throws Exception {  
        // 构造URL  
        URL url = new URL(urlString);  
        // 打开连接  
        URLConnection con = url.openConnection();  
        //设置请求的路径  
        con.setConnectTimeout(5*1000);  
        // 输入流  
        InputStream is = con.getInputStream();  
      
        // 教读取的数据存在ico中  
        byte[] ico=new byte[(is.available())];
        is.read(ico);
        String str = new String(ico, "utf-8");
        System.out.println(str);
        is.close();  
    }
    
}