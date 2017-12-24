<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/configuration.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<s:textarea class="ckeditor" cols="80" id="editor1" name="feedback.feedcontent" rows="10">
		${feedback.feedcontent}
	</s:textarea>

