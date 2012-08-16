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
<title>Regras</title>
</head>
<body>
	<div id="body">
		<h2>Regras</h2>
		<c:if test="${not empty regras}">
			<table>
				<tr>
					<th>Id</th>
					<th>Regra</th>
					<th>Descrição</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
				<c:forEach items="${regras}" var="regra">
					<c:url var="url" value="/regra/${regra.id}" />
					<tr>
						<td>${regra.id}</td>
						<td>${regra.regra}</td>
						<td>${regra.descricao}</td>

						<td align="center"><form:form action="${url}/exibir"
								method="GET">
								<input id="exibir" type="submit" value="Exibir" />
							</form:form></td>
						<td align="center"><form:form action="${url}/editar"
								method="GET">
								<input id="EDITAR" type="submit" value="Editar" />
							</form:form></td>
						<td align="center"><form:form action="${url}/deletar"
								method="POST">
								<input id="excluir" type="submit" value="Excluir" />
							</form:form></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty regras}">Não há regras cadastradas no momento.</c:if>
		<div id="menu">
			<a href="<c:url value=
       "/regra/novo"/>">Novo</a>
		</div>
	</div>
</body>
</html>