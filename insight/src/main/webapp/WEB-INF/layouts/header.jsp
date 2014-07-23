<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="header">
	<div id="title">
	    <h1><a href="${ctx}"><small>任务清单</small></a>
	    <shiro:user>
			<div class="btn-group pull-right">
				<a class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#">
					<i class="glyphicon glyphicon-user"></i> <shiro:principal property="name"/>
					<span class="caret"></span>
				</a>
			
				<ul class="dropdown-menu">
					<shiro:hasRole name="admin">
						<li><a href="${ctx}/admin/user">管理用户</a></li>
						<li class="divider"></li>
					</shiro:hasRole>
					<li><a href="${ctx}/api">REST API</a></li>
					<li><a href="${ctx}/profile">用户中心</a></li>
					<li><a href="${ctx}/logout">登出系统</a></li>
				</ul>
			</div>
		</shiro:user>
		</h1>
	</div>
</div>