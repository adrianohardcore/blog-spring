<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"     uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec"    uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 
<%@ page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" media="all"
	href='<c:url value="/resources/css/teste.css"/>' />
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/teste2.css"/>' />

<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body class="page page-id-7 page-template-default">
	<header id="head" class="clearfix" role="banner">
	<div class="wrapper">
		<tiles:insertAttribute name="header" />
		<nav id="nav-main" class="clearfix" role="navigation">
		
		<sec:authorize access="anonymous">
			<tiles:insertAttribute name="menu" />
		</sec:authorize>
		
		<sec:authorize access="hasRole('ADMINISTRADOR')">
			<tiles:insertAttribute name="menuAdministrador" />
		</sec:authorize> 
		
		<sec:authorize access="hasRole('USUARIO')">
			<tiles:insertAttribute name="menuUsuario" />
		</sec:authorize> </nav>


		</nav>
	</div>
	</header>

	<!--[if lt IE 7]><div class="wrapper"><div class="panel"><p>Your browser is <em>ancient!</em> <a href="http://browsehappy.com/">Upgrade to a different browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> for a better experience of this site.</p></div></div> <![endif]-->
	<div id="main" role="main" class="wrapper">
		<article id="post-7"
			class="post-7 page type-page status-publish hentry"> <tiles:insertAttribute
			name="body" /> </article>
	</div>
	<tiles:insertAttribute name="footer" />
</body>
</html>