<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<head>
<script type='text/javascript'
	src='<c:url value="/resources/js/jquery-1.7.2.min.js"/>'></script>
</head>
<div>
	<c:forEach items="${posts}" var="post">
		<c:url var="url" value="/posts/${post.id}" />
		<h2>
			<a href="${url}">${post.title}</a>
		</h2>
				${post.body}			
			<h3></h3>

		<p class="meta-data">
			<time> ${post.dataCriacao} </time>
		</p>
	</c:forEach>
	<%-- 		<c:if test="${proximo != 0 }"> --%>
	<%-- 			<a href="<c:url value="/${proximo}"/>">Próximo</a> --%>
	<%-- 		</c:if> --%>
	<%-- 		<c:if test="${anterior != 0 }"> --%>
	<%-- 			<a href="<c:url value="/${anterior}"/>">Anterior</a> --%>
	<%-- 		</c:if> --%>
</div>