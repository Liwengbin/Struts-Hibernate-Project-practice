<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/configuration.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
  	<title>Coll登录</title>
	<s:include value="jspbase/headbase.jsp"></s:include>
  </head>
 <body>
 	<!-- 导航栏 -->
	<div>
		<s:include value="jspbase/nav.jsp"></s:include>
	</div>
	<!-- 模态框（Modal） 登录注册-->
	<div>
	<s:include value="jspbase/mloginorsign.jsp"></s:include>
	</div>
	
	<!-- 模态框（Modal） 文件导入/导出-->
	<div>
	<s:include value="jspbase/importorexport.jsp"></s:include>
	</div>
	
	<s:if test="user.user_email!='null'">
	<div class="container top-nav">
	   <div class="jumbotron">
	        <h1>欢迎来到Coll网站</h1>
	        <p>您已经登录成功！</p>
	        
	        <button type="button" class="btn btn-primary btn-lg">
			            去Coll导航<i class="fa fa-paper-plane"></i>
			    	</button>
	   </div>
	</div>
	</s:if>
	<s:else>
	
	<div class="container top-nav">
	   <div class="jumbotron">
	        <h1>欢迎来到Coll网站</h1>
	        <p>您未登录请去登录或注册！</p>
	        
	        <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModallogin">
			            [登录/注册]<i class="fa  fa-lightbulb-o"></i>
			    	</button>
	   </div>
	</div>
	</s:else>
	
	<div>
		<s:include value="jspbase/fixedbtn.jsp"></s:include>
	</div>
	
	<s:include value="/jsps/jspbase/footer.jsp"></s:include>
<script src="<c:url value="/js/tree.js"/>"></script>
<script>
$(document).ready(function(){
$("#_sendmessage").focus();
	rorlClick();
	importTree();
})



</script>
</body>
</html>