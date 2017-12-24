<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/configuration.jsp" %>
<!-- 模态框（Modal） 文件导入导出-->
	<div class="modal fade" id="importorexport" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						<i class="fa fa-times-circle-o"></i>
					</button>
					<h4 class="modal-title" id="myModalLabel">
						Import or Export
					</h4>
				</div>
				
				<s:form action="import" namespace="/userinfo" method="post" enctype="multipart/form-data">
				<div class="iore" style="display: block;">
					<div class="modal-body chimport form-inline">
						<div class="container-fluid row importtom">
						  <div class="col-md-2">
							<button type="button" id="_importbtn" class="btn btn-info" style="width: 100%;">选择</button>
						  </div>
						  <div class="col-md-4 form-group">
							<input type="text" id="_namespan" class="form-control" style="width: 100%;">
						  </div>
						  
							<s:file class="filei-mport" name="importfile"></s:file>
						  <div class="col-md-2">
							<s:submit id="_submitimport" class="btn btn-info" value="导入" style="width: 100%;"></s:submit>
						  </div>
						  
						  <div class="col-md-2">
							<button class="btn btn-info" style="width: 100%;">导出</button>
						  </div>
						  
						  <div class="col-md-2">
							<button type="button" class="btn btn-default" data-dismiss="modal" style="width: 100%;">关闭
							</button>
						  </div>
						</div>
					</div>
				</div>
				</s:form>
				
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>

