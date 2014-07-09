<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/commons/taglibs.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<!--[if IE 8]>
    <html class="no-js lt-ie9">
<![endif]-->
<!--[if gt IE 8]><!--> 
<html class="no-js"> 
<!--<![endif]-->
<head>
<title><sitemesh:title/></title>
<%@ include file="/WEB-INF/commons/clients.jsp"%>
<sitemesh:head/>
</head>
<body>
	 <!--[if lt IE 8]>
            <p class="browsehappy">您当前使用的是<strong>过时的</strong>浏览器。请<a href="http://browsehappy.com/">升级您的浏览器 </a>以提升您的体验。</p>
     <![endif]-->
	<sitemesh:body/>
	<script src="${ctx}/bundle/common.js" type="text/javascript"></script>
</body>
</html>