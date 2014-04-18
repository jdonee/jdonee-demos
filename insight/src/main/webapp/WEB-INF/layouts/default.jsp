<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<!--[if lt IE 7]>      
	<html class="no-js lt-ie9 lt-ie8 lt-ie7"> 
<![endif]-->
<!--[if IE 7]>
	<html class="no-js lt-ie9 lt-ie8"> 
<![endif]-->
<!--[if IE 8]>
    <html class="no-js lt-ie9">
<![endif]-->
<!--[if gt IE 8]><!--> 
	<html class="no-js"> 
<!--<![endif]-->
<head>
<title>Insight示例:<sitemesh:title/></title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta name="viewport" content="width=device-width, initial-scale=1">
       
<link type="image/x-icon" href="${ctx}/static/images/favicon.ico" rel="shortcut icon">
<!-- 
<link rel="stylesheet" href="${ctx}/static/css/normalize.css">
<link rel="stylesheet" href="${ctx}/static/css/main.css">
 -->
<link href="${ctx}/bundle/default.css" type="text/css" rel="stylesheet">
<link href="${ctx}/bundle/common.css" type="text/css" rel="stylesheet">
<script src="${ctx}/bundle/global.js" type="text/javascript"></script>
<%-- 
<link href="${ctx}/static/bootstrap/2.3.2/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/jquery-validation/1.11.1/validate.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/styles/default.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/static/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery-validation/1.11.1/jquery.validate.min.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery-validation/1.11.1/messages_bs_zh.js" type="text/javascript"></script>
 --%>
<sitemesh:head/>
</head>
<body>
	 <!--[if lt IE 7]>
            <p class="browsehappy">您当前使用的是<strong>过时的</strong>浏览器。请<a href="http://browsehappy.com/">升级您的浏览器 </a>以提升您的体验。</p>
     <![endif]-->
	<div class="container">
		<%@ include file="/WEB-INF/layouts/header.jsp"%>
		<div id="content">
			<sitemesh:body/>
		</div>
		<%@ include file="/WEB-INF/layouts/footer.jsp"%>
	</div>
	<script src="${ctx}/bundle/common.js" type="text/javascript"></script>
	
</body>
</html>