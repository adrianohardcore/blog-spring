<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<c:url value="/" var="homeUrl" />
<h1 id="logo">
	<a href="${homeUrl}" rel="home"><span class="circle"> </span>Blog
		AdrianoHardcore</a>
</h1>
<div>
	<sec:authorize access="authenticated">
		<%=SecurityContextHolder.getContext().getAuthentication().getName()%>
	</sec:authorize>
</div>  
