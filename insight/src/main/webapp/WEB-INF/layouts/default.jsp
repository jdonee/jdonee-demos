<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/commons/taglibs.jsp"%>
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
<%@ include file="/WEB-INF/commons/clients.jsp"%>
<sitemesh:head/>
</head>
<body>
	 <!--[if lt IE 7]>
            <p class="browsehappy">您当前使用的是<strong>过时的</strong>浏览器。请<a href="http://browsehappy.com/">升级您的浏览器 </a>以提升您的体验。</p>
     <![endif]-->
     <%@ include file="/WEB-INF/layouts/header.jsp"%>
	<main class="container" role="main">
		<div id="content" class="row">
			<sitemesh:body/>
		</div>
	</main>
	<%@ include file="/WEB-INF/layouts/footer.jsp"%>
	<script src="${ctx}/bundle/common.js" type="text/javascript"></script>
</body>
</html>