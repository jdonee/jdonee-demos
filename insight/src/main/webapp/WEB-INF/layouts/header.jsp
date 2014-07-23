<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<header role="banner" id="top" class="navbar navbar-green navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button data-target=".bs-navbar-collapse" data-toggle="collapse" type="button" class="navbar-toggle collapsed">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${ctx}/">任务清单</a>
    </div>
    <nav role="navigation" class="collapse navbar-collapse bs-navbar-collapse">
      <ul class="nav navbar-nav">
		<li id="tasks"><a href="${ctx}/task">任务管理</a></li>
        <shiro:hasRole name="admin">
			<li id="users"><a href="${ctx}/admin/user">用户管理</a></li>
		</shiro:hasRole>
        <li>
          <a href="${ctx}/api">REST API</a>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li>
        <shiro:user>
			<div class="btn-group pull-right pull-position">
				<a class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#">
					<i class="glyphicon glyphicon-user"></i> <shiro:principal property="name"/>
					<span class="caret"></span>
				</a>
				<ul class="dropdown-menu">
					<li><a href="${ctx}/profile">个人中心</a></li>
					<li><a href="${ctx}/logout">登出</a></li>
				</ul>
			</div>
		</shiro:user>
		</li>
      </ul>
    </nav>
  </div>
</header>