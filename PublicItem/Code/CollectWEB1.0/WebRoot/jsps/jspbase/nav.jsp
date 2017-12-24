<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/configuration.jsp" %>

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
				<div class="pull-right nav-btn">
			    	<s:if test="user.user_email!='null'">
			    			<input type="hidden" id="_cname" value=<s:property value="user.user_email"/>>
							<div class="btn-group">
								<button type="button" class="btn btn-primary dropdown-toggle btn-sm" data-toggle="dropdown">
								    <span class="fa fa-user"></span>
								        <s:property value="user.user_email"/>
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu state-menu" role="menu">
									<li><a href="#">个人空间</a></li>
									
									<li class="divider" style="margin: 0;"></li>
									<li><a id="_logout" href='<s:url action="logout" namespace="/userinfo"/>'><span class="fa fa-power-off" style="color: red;"></span>注销</a></li>
								</ul>
							</div>
					</s:if>
					<s:else>
					      <button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#myModallogin">
			              [登录/注册]<i class="fa  fa-lightbulb-o"></i>
			    		  </button>
					</s:else>
			    	<button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#importorexport">
			            [导入/导出]<i class="fa fa-spinner"></i>
			    	</button>
				</div>
			</div>
		</nav>
	</div>
		<script>
		$(document).ready(function(){
		
		$("#_logout").click(function(){
			setCookie("login_password", "", 1);
		});
		if($("#_cname").val()==undefined)
		{
			checkLogin();
			}
		})
</script>