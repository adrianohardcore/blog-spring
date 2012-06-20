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
<title>Cadastrar</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
	<div id="body">
		<h1>Cadastrar</h1>		
		<div id="ErroGeral">
			${mensagem}
		</div>		

		<c:url var="url" value="/usuario" />
		<form:form action="${url}" method="POST" modelAttribute="usuario">		
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
					size="30" />
			</p>

			<p>
				<label for="email">Email:</label>
				<form:errors path="email" cssClass="error" />
				<br />
				<form:input cssStyle="width:250px" maxlength="50" path="email"
					size="30" />
			</p>

			<p>
				<label for="senha">Senha:</label>
				<form:errors path="senha" cssClass="error" />
				<br />
				<form:input type='password' cssStyle="width:250px" maxlength="10" path="senha"
					size="30" />
			</p>
			<p>
				<input id="criar" type="submit" value="Cadastrar" />
			</p>
		</form:form>
	</div>
</body>
</html>