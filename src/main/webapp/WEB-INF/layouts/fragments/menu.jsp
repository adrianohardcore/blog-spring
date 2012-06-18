<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder"%>

<c:url value="/" var="homeUrl" />
<c:url value="/user" var="userUrl" />
<c:url value="/users" var="usersUrl" />
<c:url value="/admin" var="adminUrl" />
<c:url value="/logout" var="logoutUrl" />
<c:url value="/login" var="loginUrl" />
<c:url value="/posts" var="postsUrl" />
<c:url value="/usuarios" var="usuariosUrl" />
<c:url value="/cadastro" var="cadastroUrl" />

<div class="menu">
	<ul>
		<sec:authorize access="hasRole('ROLE_USER')">			
			<li><a href="${postsUrl}">Posts</a></li>
		</sec:authorize>

		
		
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href="${usersUrl}">Users</a></li>
			<li><a href="${usuariosUrl}">Usuários</a></li>
		</sec:authorize>
		
		<li><a href="${cadastroUrl}">Cadastrar</a></li>
		
		<sec:authorize access="authenticated">
			<li><a href="${logoutUrl}">Logout</a></li>			
		</sec:authorize>
		
		<sec:authorize access="anonymous">
			<li><a href="${loginUrl}">Login</a></li>
		</sec:authorize>
		

	</ul>
	<br style="clear: left" />
</div>