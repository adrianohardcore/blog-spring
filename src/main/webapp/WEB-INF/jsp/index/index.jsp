<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<div class="article ohyear row">
	<div class="four col">
		<h1>2012</h1>
	</div>
	<div class="eight col">
		<c:forEach items="${posts}" var="post">
			<c:url var="url" value="/posts/${post.id}" />
			<h2>
				<!-- 				<a href="http://nathanstaines.com/articles/directional-buttons/">Directional buttons</a> -->
				<a href="${url}">${post.title}</a>
			</h2>
				${post.body}			
			<h3></h3>

			<p class="meta-data">
				<!-- 				<time datetime="2012-02-21T00:00:48+00:00" pubdate>February -->
				<!-- 					21, 2012</time> -->
				<!-- 				&bull; 150 words -->
				<time> ${post.dataCriacao} </time>
			</p>
		</c:forEach>		
		<div id="menu">
			<a href="<c:url value="/${proximo}"/>">Próximo</a>
			<a href="<c:url value="/${anterior}"/>">Anterior</a>
		</div>
	</div>
</div>