<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>

<c:url value="/" var="homeUrl" />
<c:url value="/logout" var="logoutUrl" />


<div class="menu">
	<ul>
		<sec:authorize access="hasRole('USUARIO')">
			<li><a href="${logoutUrl}">Logout</a></li>
		</sec:authorize>
	</ul>
	<br style="clear: left" />
</div>