<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/configuration.jsp" %>
	<!-- 弹出Modal的按钮 文件资料添加-->
	<button id="modaladdfilebtn" data-toggle="modal" data-target="#myModalfile" style="display: none;"></button>
	<!-- 模态框（Modal） 文件资料添加-->
	<div class="modal fade" id="myModalfile" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						<i class="fa fa-times-circle-o"></i>
					</button>
					<h4 class="modal-title" id="myModalLabel">
						New File
					</h4>
				</div>

				<div class="addfile">
					<div class="modal-body">
						<div class="form-group row">
							<div class="logoclass col-sm-1 pull-right" style="padding-left: 0px;"><img id="_logo" src="" class="img-responsive" style="max-width: 26;
    height: 26;margin-top: 3px;"></div>
							<div class="col-sm-11">
							<s:textfield class="form-control" id="_url" placeholder="URL" name="url_collect.url"></s:textfield>
							</div>
						</div>
						<div class="form-group">
							<s:textfield class="form-control" id="_title" placeholder="Title" name="url_collect.title"></s:textfield>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default btn-sm" id="_geturl"><span class="fa fa-refresh"></span>自动获取URL信息</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						<button type="button" id="_submiturl" class="btn btn-primary">
							提交
						</button>
					</div>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>
	
	<button id="modaladdmenubtn" data-toggle="modal" data-target="#myModalmenu" style="display: none;"></button>
	<div class="modal fade" id="myModalmenu" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="addmenu">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							<i class="fa fa-times-circle-o"></i>
						</button>
						<h4 class="modal-title" id="myModalLabel">
							New Menu
						</h4>
				    </div>
				
					<div class="modal-body">
						<input type="text" id="_menuname" class="form-control" placeholder="name">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						<button id="_submitmenu" type="button" class="btn btn-primary">
							创建
						</button>
					</div>
				</div>
			</div>
		</div><!-- /.modal -->
	</div>
