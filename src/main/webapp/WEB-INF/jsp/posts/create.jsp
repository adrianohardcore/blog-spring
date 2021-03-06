<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"     uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec"    uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ page import="org.springframework.security.core.context.SecurityContextHolder"%>

<head>
	<title>Nova postagem</title>
</head>
<body>
	<div>
		<h1>Nova postagem</h1>
		<c:url var="url" value="/posts" />
		<form:form action="${url}" method="POST" modelAttribute="post">
			<p>
				<label for="title">T�tulo:</label>
				<form:errors path="title" cssClass="error" />
				<br />
				<form:input cssStyle="width:250px" maxlength="20" path="title" size="20" />
			</p>
			<p>
				<label for="body">Texto:</label>
				<form:errors path="body" cssClass="error" />
				<br />
				<form:textarea path="body" rows="10" cols="20" maxlength="255"
					cssStyle="width:250px" />
			</p>
			<p>
				<input id="criar" type="submit" value="Create" />
			</p>
		</form:form>
		
		<div>
			<a href="<c:url value="/posts"/>">Ver todos</a>
		</div>
		
	</div>
</body>
