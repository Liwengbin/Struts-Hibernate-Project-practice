/**
 * 
 */
package com.coll.config;

/**
 * @author JOEYANG ONG
 * 
 */
public final class VersionInfo {
    //application info
	public final static String APP_NAME="Coll网址收藏";
    public final static String APP_VERSION="1.0";
    public final static String APP_STATUS="Beta";
    public final static String APP_BUILDATE="2017-5-5";
    public final static String APP_BUILDVER="#2";
    	
    //application author
    public final static String APP_AUTHOR="Coll开发团队";
    public final static String APP_WORKSTUDIO="互联网+时代";
    
    public final static String buildFooterStr()
    {
    	StringBuffer sb=new StringBuffer();

    	sb.append(APP_NAME);
    	sb.append(" "+"(版本:"+APP_STATUS+APP_VERSION);
    	sb.append(" &nbsp;&nbsp;Build:"+APP_BUILDVER);
    	sb.append(" "+APP_BUILDATE+")");
    	sb.append("&nbsp;&nbsp;&nbsp;&nbsp;开发团队:&nbsp;<a href=\"#\">"+APP_AUTHOR+"</a><br/>");
    	sb.append("©COLLECT MUX, powered by alimama THX.法律声明转载内容版权归作者及来源网站所有，本站原创内容转载请注明来源，请先联系：liwengbincoll@foxmail.com");
    	sb.append("(C)&nbsp;"+APP_WORKSTUDIO+"&nbsp;&nbsp;");

    	return sb.toString();	
    }
    
}
