<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style type="text/css">
	body {background: #555; width: 400px; border: 1px solid #fff; padding: 0px;}
    div {padding: 5px; margin: 0px;}
    h1, h2, p {padding: 0px; margin: 0px;}
	#banner-style {background: #3B3E37;}
	#title-style {background: #665845;}
	#subtitle-style {background: #9F8158;}
	#primary-style {background: #EBC785;}
	#footer-style {background: #733027;}
</style>

<title>Insert title here</title>
</head>
<body style="background: #555;">

<div id="banner-style"><tiles:insertAttribute name="header" /></div>
<div id="title-style"><h2><tiles:insertAttribute name="menu" /></h2></div>
<div id="primary-style"><tiles:insertAttribute name="body" /></div>
<div id="footer-style"><tiles:insertAttribute name="footer" /></div>

</body>
</html>