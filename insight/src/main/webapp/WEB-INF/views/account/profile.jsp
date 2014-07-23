<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>资料修改</title>
</head>

<body>
	<div class="col-md-8">
	<form id="inputForm" action="${ctx}/profile" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${user.id}"/>
		<fieldset class="scheduler-border">
			<legend class="scheduler-border"><small>资料修改</small></legend>
			<div class="control-group">
				<label for="name" class="control-label">用户名:</label>
				<div class="controls">
					<input type="text" id="name" name="name" value="${user.name}" class="form-control input-sm required"/>
				</div>
			</div>
			<div class="control-group">
				<label for="plainPassword" class="control-label">密码:</label>
				<div class="controls">
					<input type="password" id="plainPassword" name="plainPassword" class="form-control input-sm" placeholder="不填则不会更新您的密码..."/>
				</div>
			</div>
			<div class="control-group">
				<label for="confirmPassword" class="control-label">确认密码:</label>
				<div class="controls">
					<input type="password" id="confirmPassword" name="confirmPassword" class="form-control input-sm" equalTo="#plainPassword" />
				</div>
			</div>
			<div class="form-actions form-actions-topfix">
				<input id="submit_btn" class="btn btn-default btn-primary" type="submit" value="提交"/>&nbsp;	
				<input id="cancel_btn" class="btn btn-default" type="button" value="返回" onclick="history.back()"/>
			</div>
		</fieldset>
	</form>
	</div>
	
	<script>
		$(document).ready(function() {
			//聚焦第一个输入框
			$("#name").focus();
			//为inputForm注册validate函数
			$("#inputForm").validate();
		});
	</script>
</body>
</html>
