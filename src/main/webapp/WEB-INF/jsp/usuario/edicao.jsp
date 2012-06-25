<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML
 4.01 Transitional//EN" "http://www.w3.org/
 TR/html4/loose.dtd">
<html>
<head>
<title>Alterar usuário - ${usuario.nomeUsuario}</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css" media="screen">
@import
url(
"<c:url value="
/
static
/styles/style.css"/>");
</style>

</head>
<body>
	<div id="body">
		<h1>Alterar usuário</h1>

		<div id="ErroGeral">${mensagem}</div>

		<c:url var="url" value="/usuario" />
		<form:form action="${url}/atualiza" method="POST"
			modelAttribute="usuario">
			<form:hidden path="id" />
			<form:hidden path="nomeUsuario" />
			<form:hidden path="email" />




			<p>
				<label for="nome">Nome:</label>
				<form:errors path="nome" cssClass="error" />
				<br />
				<form:input cssStyle="width:250px" maxlength="50" path="nome"
					size="30" />
			</p>
			<p>
				<label for="nomeUsuario">Usuário:</label>
				<form:errors path="nomeUsuario" cssClass="error" />
				<br />
				<form:input cssStyle="width:250px" maxlength="50" path="nomeUsuario"
					size="30" disabled="true" />
			</p>

			<p>
				<label for="email">Email:</label>
				<form:errors path="email" cssClass="error" />
				<br />
				<form:input cssStyle="width:250px" maxlength="50" path="email"
					size="30" disabled="true" />
			</p>

			<p>
				<label for="senha">Senha:</label>
				<form:errors path="senha" cssClass="error" />
				<br />
				<form:input type='password' cssStyle="width:250px" maxlength="10"
					path="senha" size="30" />
			</p>

			<!-- 			<p> -->
			<!-- 				<label for="regra">Regra:</label> -->
			<%-- 				<form:errors path="regra" cssClass="error" /> --%>
			<!-- 				<br /> -->
			<%-- 				<form:input cssStyle="width:50px" maxlength="1" path="regra" --%>
			<%-- 					size="30" /> --%>
			<!-- 			</p> -->

			<p>
				<form:label path="regra">Regra: 
        </form:label>
				<form:errors path="regra" cssClass="error" />
				<%-- 				<form:select path="regra"> --%>
				<%-- 					<c:forEach items="${regras}" var="regra"> --%>
				<%-- 						<c:choose> --%>
				<%-- 							<c:when test="${regra.id == usuario.regra}"> --%>
				<%-- 								<option value="${regra.id}" selected="true">${regra.regra}</option> --%>
				<%-- 							</c:when> --%>
				<%-- 							<c:otherwise> --%>
				<%-- 								<option value="${regras}">${regra.regra}</option> --%>
				<%-- 							</c:otherwise> --%>
				<%-- 						</c:choose> --%>
				<%-- 					</c:forEach> --%>
				<%-- 				</form:select> --%>


<%-- 				<form:form commandName="usuario"> --%>
					<form:select path="regra.id">
<%-- 						<form:option value="--SELECIONE--" <c:if test="${regra.id eq regras.id}">selected="selected"></c:if> ></form:option> --%>
							
						
						
<%-- 						<c:if test="${usuario.regra eq regra}">selected="selected"</c:if>>${regra.regra}</option> --%> --%>
						
						<option value="" selected="selected">--SELECIONAR--</option>
						
																						
						<form:options items="${regras}" itemValue="id" itemLabel="regra"/>						
					</form:select>
<%-- 				</form:form> --%>
  
<%-- 				<form:form commandName="generic"> --%>
<%-- 					<form:select path="server.id"> --%>
<%-- 						<form:options items="${servers}" itemValue="id" itemLabel="name" /> --%>
<%-- 					</form:select> --%>
<%-- 				</form:form> --%>











			</p>

			<!-- 			<p> -->
			<!-- 			<label for="regra">Regra:</label> -->
			<%-- 			<form:errors path="regra" cssClass="error" /> --%>
			<!-- 			<br /> -->
			<%-- 			<form:select path="regra" multiple="true" items="${regras}" itemLabel="regra" /> --%>


			<!-- 			<select name="usuario.regra"> -->
			<%-- 				<c:forEach items="${regras}" var="regra"> --%>
			<%-- 					<option value="${regra}" --%>
			<%-- 						<c:if test="${usuario.regra eq regra}">selected="selected"</c:if>>${regra.regra}</option> --%>
			<%-- 				</c:forEach> --%>
			<!-- 			</select> -->

			<!-- 			<select name="dusr.dusrstabl"> -->
			<%-- 				<c:forEach items="${UsuarioStatus}" var="status"> --%>
			<%-- 					<option value="${status}" --%>
			<%-- 						<c:if test="${dusr.dusrstabl eq status}">selected="selected"</c:if>>${status.label}</option> --%>
			<%-- 				</c:forEach> --%>
			<!-- 			</select> -->




			<p>
				<input id="criar" type="submit" value="Salvar" />
			</p>
		</form:form>
		<div id="menu">
			<a href="<c:url value="/usuarios"/>">Ver todos</a>
		</div>
	</div>
</body>
</html>