<%@tag pageEncoding="UTF-8"%>
<%@ attribute name="page" type="com.jdonee.framework.util.pagehelper.PageInfo" required="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
int current =  page.getPageNum();
int begin = Math.max(1, current - page.getPageNum()/2);
int end = Math.min(begin + (page.getPageNum() - 1), page.getPages());

request.setAttribute("current", current);
request.setAttribute("begin", begin);
request.setAttribute("end", end);
%>

<ul class="pagination">
		 <% if (page.isHasPreviousPage()){%>
               	<li><a href="?page=1&sortType=${sortType}&${searchParams}">&lt;&lt;</a></li>
                <li><a href="?page=${current-1}&sortType=${sortType}&${searchParams}">&lt;</a></li>
         <%}else{%>
                <li class="disabled"><a href="javascript:void(0);">&lt;&lt;</a></li>
                <li class="disabled"><a href="javascript:void(0);">&lt;</a></li>
         <%} %>
 
		<c:forEach var="i" begin="${begin}" end="${end}">
            <c:choose>
                <c:when test="${i == current}">
                    <li class="active"><a href="?page=${i}&sortType=${sortType}&${searchParams}">${i}</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="?page=${i}&sortType=${sortType}&${searchParams}">${i}</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
	  
	  	 <% if (page.isHasNextPage()){%>
               	<li><a href="?page=${current+1}&sortType=${sortType}&${searchParams}">&gt;</a></li>
                <li><a href="?page=${page.pages}&sortType=${sortType}&${searchParams}">&gt;&gt;</a></li>
         <%}else{%>
                <li class="disabled"><a href="javascript:void(0);">&gt;</a></li>
                <li class="disabled"><a href="javascript:void(0);">&gt;&gt;</a></li>
         <%} %>
</ul>

