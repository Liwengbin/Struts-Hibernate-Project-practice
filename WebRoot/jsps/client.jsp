<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/configuration.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>Coll客服</title>
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
	
	<div class="container-fluid row"></div>
	<div class="col-md-6 col-md-offset-3 top-nav" style="margin-bottom: 40px;">
		<div class="panel panel-default">
			<div class="panel-heading">
		        <h3 class="panel-title">
		                        聊天空间
		        </h3>
	    	</div>
		    <div class="panel-body client-spase">
		       <ul class="message-list">
		       		<li>
			       	   <div class="mes mes-left row">
			       	   	   <div class="mes-img col-xs-2 p0">
				       	   <img src="<c:url value="/ico/headimg6.png"/>" class="img-responsive img-circle">
				       	   </div>
				       	   
				       	   <div class="panel panel-info col-xs-8 p0 mes-conttent">
							    <div class="panel-heading" style="padding:5px 15px">
							        <h3 class="panel-title">now data</h3>
							    </div>
							    <div class="panel-body" style="padding:10px">
							    	<span>Welcome to Coll !</span> 	
							    </div>
							</div>
				       </div>
			       </li>
		       </ul>
		    </div>
		</div>

	 <div class="">
	 	<div class="input-group">
			<input id="_sendmessage" type="text" style="height: auto;" class="form-control">
			<span class="input-group-btn">
				<button id="_send" class="btn btn-default" type="button">
					send
				</button>
			</span>
		</div><!-- /input-group -->
	  	 <input type="hidden" id="_forid" value="root">
	  	 <input type="hidden" id="_id" value="colluser">   
     </div>
     
	</div>
	
	<div>
		<s:include value="jspbase/fixedbtn.jsp"></s:include>
	</div>

<script src="<c:url value="/js/tree.js"/>"></script>
<script>
$(document).ready(function(){
$("#_sendmessage").focus();
$("#_client").addClass('active');
	rorlClick();
	toClient(); 
	importTree();
})
</script>
</body>
</html>