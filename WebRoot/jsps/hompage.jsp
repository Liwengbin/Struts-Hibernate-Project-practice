<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/configuration.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>Coll收藏</title> 
		<s:include value="jspbase/headbase.jsp"></s:include>
  </head>
 <body style="overflow:-Scroll;overflow-y:hidden">
	
	<!-- 导航栏 -->
	<div>
		<s:include value="jspbase/nav.jsp"></s:include>
	</div>	
	
	<div class="container-fluid top-nav">
		<ul class="nav selfnav nav-tabs isline" style="display:block;">
			<s:iterator value="collnavlist">
				<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#" data-hover="dropdown">
				<span class="fa  fa-folder"></span>
					<s:property value="collurl.title"/> 
				</a>
				<ul class="dropdown-menu selfnav-navul">
					<s:iterator value="colllist">
					<li class="navli"><a target="_blank" href="<s:property value="href"/>"><img src="<s:property value="logo"/>"><s:property value="title"/></a><span urlid-data="<s:property value="kid"/>" class="fa fa-trash-o"></span></li>
					</s:iterator>
					<li style="text-align: center;"><a class="fa fa-plus addfilebtn" loction-data="<s:property value="collurl.loction"/>"></a></li>
				</ul>
			</li>
			</s:iterator>
			<li><a id="_addmenubtn"><span class="fa fa-chevron-right" style="color: #337ab7;"></span>添加</a></li>
			</ul>
			<input id="_loction"type="hidden" value="">
	</div>
	
	<div class="container-fluid row treeall" style="display:none;">
		<!-- 默认树结构表格 -->
		<div id="default_tree" class="col-md-6 col-md-offset-1 tree"></div>
		
		<!-- 网址推荐列表 -->
		<div class="col-md-4">
			<button id="_linbtn" class="btn btn-info btn-ms"><span class="fa fa-chevron-circle-right"></span> 到条形收藏栏</button>
			<s:include value="jspbase/urltable.jsp"></s:include>
		</div>
	</div>
	
	<!-- 模态框（Modal） 登录/注册-->
	<div>
	<s:include value="jspbase/mloginorsign.jsp"></s:include>
	</div>

	<!-- 模态框（Modal） 文件/资料添加-->
	<div>
	<s:include value="jspbase/mfileormenu.jsp"></s:include>
	</div>
	
	<!-- 模态框（Modal） 文件导入/导出-->
	<div>
	<s:include value="jspbase/importorexport.jsp"></s:include>
	</div>
	
	<!-- 福利推荐 -->
	<div>
		<img src="<c:url value="/ico/home.png"/>" class="img-responsive">
	</div>
	
	<div>
		<s:include value="jspbase/fixedbtn.jsp"></s:include>
	</div>
	
	<s:include value="/jsps/jspbase/footer.jsp"></s:include>
<script src="<c:url value="/js/tree.js"/>"></script>
<script>

$(function () { $("[data-toggle='tooltip']").tooltip(); });


$(document).ready(function(){
	$("#_home").addClass('active');
	//监听操作按钮事件，触发时显示气泡
	$(function () { $(".popover-options i").popover({html : true });});
	addfileClick();
	addmenuClick();
	
	$("#morfbtn").attr('state','file');
	rorlClick();
	importTree();
	removeUrl();
})
</script>
</body>
</html>
