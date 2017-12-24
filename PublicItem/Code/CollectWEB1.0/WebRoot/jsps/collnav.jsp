<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/configuration.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <title>Coll导航</title>
	<s:include value="jspbase/headbase.jsp"></s:include>
  </head>
 <body style="overflow:-Scroll;overflow-y:hidden; height: 100%;">
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
	
	<!-- 引用UC导航 -->
	<div class="container-fluid" style="margin-top: 50px;">
		<s:include value="jspbase/UCnav.jsp"></s:include>
		<div>
			<s:include value="jspbase/fixedbtn.jsp"></s:include>
		</div>
	</div>
<script src="<c:url value="/js/tree.js"/>"></script>
<script>
$(document).ready(function(){
$("#_sendmessage").focus();
	rorlClick();
	importTree();
	$("#_collnav").addClass('active');
})

</script>
</body>
</html>