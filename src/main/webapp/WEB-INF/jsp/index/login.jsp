<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
	<title>Login</title>
</head>

<body>
	<form action="j_spring_security_check" method="post" >
		<fieldset>
			<legend>Login Here</legend>
			
			<p>
			<label for="j_username">Usu�rio</label>:
			<input id="j_username" name="j_username" size="20" maxlength="50" type="text"/>
			</p>
			
			<p>
			<label for="j_password">Senha</label>:
			<input id="j_password" name="j_password" size="20" maxlength="50" type="password"/>
			</p>
			
			<p><input type="submit" value="Login"/></p>
		</fieldset>
	</form>
	<p class="message">${message}</p>
</body>
</html>