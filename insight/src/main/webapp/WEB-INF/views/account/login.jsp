<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.ExcessiveAttemptsException"%>
<%@ page import="org.apache.shiro.authc.IncorrectCredentialsException"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>登录页</title>
</head>

<body>
	<div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">
	  <div class="modal-dialog">
	  <div class="modal-content">
	      <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	          <h1 class="text-center">Login</h1>
	      </div>
	      <div class="modal-body">
	          <form id="loginForm" action="${ctx}/login" method="post" class="form col-md-12 center-block">
	          	<%
					String error = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
					if(error != null){
				%>
						<div class="alert alert-danger alert-dismissible" role="alert">
							<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
							登录失败，请重试.
						</div>
				<%
					}
				%>
	            <div class="form-group">
	              <input type="text" class="form-control input-lg required" id="username" name="username" placeholder="名称" value="${username}" >
	            </div>
	            <div class="form-group">
	              <input type="password" class="form-control input-lg required" id="password" name="password" placeholder="密码">
	            </div>
	            <div class="form-group">
	             	 <div class="checkbox">
				        <label>
				          <input type="checkbox" id="rememberMe" name="rememberMe"/> 记住我
				        </label>
				      </div>
	            </div>
	            <div class="form-group">
	              <button type="submit" class="btn btn-primary btn-lg btn-block">登录</button>
	              <span class="pull-right"><a href="${ctx}/register">注册</a></span><span><a href="javascript:void(0);">需要帮助?</a></span>
	            </div>
	            <div class="form-group">
	              <span class="help-block">(管理员: <b>admin/admin</b>, 普通用户: <b>user/user</b>)</span>
	            </div>
	          </form>
	      </div>
	      <div class="modal-footer">
	          <div class="col-md-12">
	          <button class="btn btn-info" data-dismiss="modal" aria-hidden="true">取消</button>
			  </div>	
	      </div>
	  </div>
	  </div>
	</div>

	<script>
	$(document).ready(function() {
			$("#loginForm").validate();
		});
	</script>
</body>
</html>
