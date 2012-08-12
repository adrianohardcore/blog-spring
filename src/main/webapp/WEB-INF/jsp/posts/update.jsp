<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
	<title>Atualizar</title>
</head>

<body>
	<div>
		<c:url var="url" value="/posts" />
		
		<form:form action="${url}" method="PUT" modelAttribute="post">
			<p>
				<label for="title">Título:</label>
				<form:errors path="title" cssClass="error" />
				<br />
				<form:input maxlength="30" path="title" size="20" />
			</p>
			
			<p>
				<label for="body">Texto:</label>
				<form:errors path="body" cssClass="error" />
				<br />
				<form:textarea path="body" rows="10" cols="20"/>
			</p>
			
			<p>
				<input id="atualizar" type="submit" value="Update" />
			</p>
			
			<form:hidden path="id" />
		</form:form>
		
		<div>
			<a href="<c:url value="/posts"/>">Ver todos</a>
			<a href="<c:url value="/posts/${post.id}/form"/>">Retornar</a>
		</div>
		
	</div>
</body>