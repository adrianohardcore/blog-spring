<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>

<c:url value="/" var="homeUrl" />
<c:url value="/login" var="loginUrl" />
<c:url value="/cadastro" var="cadastroUrl" />

<div class="menu">
	<ul>
		<sec:authorize access="anonymous">
			<li><a href="${cadastroUrl}">Cadastrar</a></li>
			<li><a href="${loginUrl}">Login</a></li>
		</sec:authorize>
	</ul>
	<br style="clear: left" />
</div>