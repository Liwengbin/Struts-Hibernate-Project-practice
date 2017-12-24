<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/configuration.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
  	<title>Coll展示</title>
	<s:include value="jspbase/headbase.jsp"></s:include>
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
	        <h1>欢迎来到Coll网站展示</h1>
	        <p>我是一个网址导航 网址收藏网 !</p>
	        <div class="alert alert-info">开始<img src="<c:url value="/showimg/show1.jpg"/>" class="img-responsive"></div>
			<div class="alert alert-info">欢迎<img src="<c:url value="/showimg/show2.jpg"/>" class="img-responsive"></div>
			<div class="alert alert-info">去登录<img src="<c:url value="/showimg/show3.jpg"/>" class="img-responsive"></div>
			<div class="alert alert-info">收藏栏<img src="<c:url value="/showimg/show4.jpg"/>" class="img-responsive"></div>
			<div class="alert alert-info">添加收藏<img src="<c:url value="/showimg/show5.jpg"/>" class="img-responsive"></div>
			<div class="alert alert-info">导入浏览器收藏<img src="<c:url value="/showimg/show6.jpg"/>" class="img-responsive"></div>
			<div class="alert alert-info">coll导航<img src="<c:url value="/showimg/show7.jpg"/>" class="img-responsive"></div>
			<div class="alert alert-info">coll客服<img src="<c:url value="/showimg/show8.jpg"/>" class="img-responsive"></div>
			<div class="alert alert-info row">
				<div class="col-md-4" style="margin-bottom: 10px;"><img src="<c:url value="/showimg/coll5.jpg"/>" class="img-responsive"></div>
				<div class="col-md-4" style="margin-bottom: 10px;"><img src="<c:url value="/showimg/coll6.jpg"/>" class="img-responsive"></div>
				<div class="col-md-4" style="margin-bottom: 10px;"><img src="<c:url value="/showimg/coll7.jpg"/>" class="img-responsive"></div>	
			</div>
			
	        <a type="button" href="<s:url action="coll" namespace="/userinfo"/>" class="btn btn-primary btn-lg">
			            登录了吗? <i class="fa  fa-lightbulb-o"></i>
			    	</a>
	   </div>
	</div>
	
	</div>
	
	<div>
		<s:include value="jspbase/fixedbtn.jsp"></s:include>
	</div>
	
	<s:include value="/jsps/jspbase/footer.jsp"></s:include>

<script src="<c:url value="/js/tree.js"/>"></script>

</body>
</html>