<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css" media="screen">
@import url("<c:url value="/static/styles/style.css"/>");
</style>
<title>Usu�rios</title>
</head>
<body>
	<div id="body">
		<h2>Usu�rios</h2>
		<c:if test="${not empty usuarios}">
		
			<table width="600px">
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Usu�rio</th>
					<th>Email</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>				

				<c:forEach items="${usuarios}" var="usuario">
					<c:url var="url" value="/usuario/${usuario.id}" />
					<tr>
						<td>${usuario.id}</td>
						<td>${usuario.nome}</td>
						<td>${usuario.nomeUsuario}</td>
						<td>${usuario.email}</td>
						      
						<td align="center">
						<form:form action="${url}/exibir" method="GET">
							<input alt="Exibir Usu�rio" src="<c:url value="/static/images/show.png"/>"
									title="Exibir Usu�rio" type="image" value="Exibir Usu�rio" />
						</form:form></td>
						<td align="center">
							<form:form action="${url}/editar" method="GET">
								<input alt="Atualizar Usu�rio" src="<c:url value="/static/images/update.png"/>"
										title="Atualizar Usu�rio" type="image" value="Atualizar Usu�rio" />
							</form:form>
						</td>
						<td align="center">
							<form:form action="${url}/deletar" method="POST">
								<input alt="Excluir Usu�rio" src="<c:url value= "/static/images/delete.png"/>"
										title="Excluir Usu�rio" type="image" value="Excluir Usu�rio" />
							</form:form>
						</td>
						
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty usuarios}">N�o h� usu�rios cadastrados no momento.</c:if>
		<div id="menu">
			<a href="<c:url value=
       "/usuario/formulario"/>">Novo</a>
		</div>
	</div>
</body>
</html>