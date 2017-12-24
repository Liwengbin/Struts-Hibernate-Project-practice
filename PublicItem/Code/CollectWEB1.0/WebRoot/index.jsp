<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/configuration.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>Coll欢迎您</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<meta http-equiv="description" content="网址收藏，网站推荐，为你提供更方便的网页收藏服务，不在烦恼。">
	<link rel="shortcut icon" href="<c:url value="/ico/favicon.ico"/>"/>
	<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/font-awesome.min.css"/>">
	<link rel="stylesheet" href="<c:url value="/css/tree.css"/>">
	<script type="text/javascript" src="<c:url value="/js/jquery-3.2.0.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery-ui.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/bootstrap.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.shCircleLoader.js"/>"></script>
  </head>
 <body>
 	<!-- 导航栏 -->
	<div class="container-fluid">
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2" aria-expanded="false">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
		     	 </button>
		     	<a class="navbar-brand" href="#">Collect</a>
		    </div>
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
				<ul class="nav navbar-nav ulhove">
					<li id="_home" class=""><a href='<s:url action="coll" namespace="/userinfo"/>'><i class="fa fa-align-justify"></i>收藏</a></li>
					<li id=""><a href="#"><i class="fa fa-signal"></i>分析</a></li>
					<li id="_collnav"><a href='<s:url action ="tocollnav" namespace="/security"/>'><i class="fa fa-paper-plane"></i>Coll导航</a></li>
					<li id="_client" class=""><a href='<s:url action="client" namespace="/userinfo"/>'><i class="fa  fa-comments"></i>客服</a></li>
					<li id="_index" class=""><a href='<s:url action="index" namespace="/security"/>'><i class="fa fa-puzzle-piece"></i>关于</a></li>
				</ul>
			</div>
		</nav>
	<div class="container top-nav">
	   <div class="jumbotron">
	        <h1>欢迎来到Coll网站</h1>
	        <p>我是一个网址导航 网址收藏网 ! 您可以根据自己的需要调整导航排版 !</p>
	        <div class="alert alert-info">在当下的浏览器都有各自的收藏栏，但存在问题，使用收藏需要我们下载该浏览器，这样对我们用户来说非常的不方便。
	        	尤其有时候不使用自己电脑浏览器不同时，想找自己收藏的网站，自己也记不住网址的情况下是遭的。
	        	本网站可以有自己的网址导航，可以删除自己不需要的网址导航信息。使互联网生活更加轻松优越！  <a class="puul-right" href='<s:url action="tocollshow" namespace="/security"/>'><i class="fa fa-eye"></i>展示</a></div>
	        <div class="alert alert-danger">注：本站部分功能为测试阶段：用户名为:admin 密码:1230</div>
	        
	        <a type="button" href="<s:url action="coll" namespace="/userinfo"/>" class="btn btn-primary btn-lg">
			            登录了吗? <i class="fa  fa-lightbulb-o"></i>
			    	</a>
	   </div>
	</div>
	</div>
	
	<div>
		<s:include value="/jsps/jspbase/fixedbtn.jsp"></s:include>
	</div>
	<s:include value="/jsps/jspbase/footer.jsp"></s:include>

<script src="<c:url value="/js/tree.js"/>"></script>
<script>
$(document).ready(function(){
$("#_sendmessage").focus();
$("#_index").addClass('active');
	importTree();
})


</script>
</body>
</html>