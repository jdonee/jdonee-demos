<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.ExcessiveAttemptsException"%>
<%@ page import="org.apache.shiro.authc.IncorrectCredentialsException"%>
<%@ page import="org.slf4j.Logger,org.slf4j.LoggerFactory" %>
<%
	int status=Integer.valueOf(request.getAttribute("errorCode").toString());
	if(status==0){
		response.setStatus(200);
	}else{
		response.setStatus(status);
	}
	
	if(status==403){
		//记录日志
		Logger logger = LoggerFactory.getLogger("error.jsp");
		logger.error("用户权限不足", exception);
	}
	
	if(status==500){
		//记录日志
		Logger logger = LoggerFactory.getLogger("error.jsp");
		logger.error(exception.getMessage(), exception);
	}
	
%>

<!DOCTYPE html>
<html>
<head>
	<title>404 - 页面不存在</title>
</head>

<body>
	<h2>404 - 页面不存在.</h2>
	<p><a href="<c:url value="/"/>">返回首页</a></p>
</body>
</html>