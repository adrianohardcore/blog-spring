<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<head>
<title>Blog do Adriano</title>
<script type='text/javascript'
	src='<c:url value="/resources/js/jquery-1.7.2.min.js"/>'></script>
</head>


<script type="text/javascript">
		var pagina = 0;
		
		function load(){
			pagina ++;		
			$.getJSON('page',{page:pagina},function(x){
			//$.getJSON('page/1',function(x){
				$.each(x,function(){
					$('ul#lista').append('<li>' + this['title'] + '</li>');
					$('ul#lista').append('<li>' + this['body'] + '</li>');
					$('ul#lista').append('<li>' + this['dataCiacao'] + '</li>');
				});				
			});
		};
		
		$(function() {
			load();	
		
			
			$('#mais').click(function() {				
				//pagina ++;
				load();				
				return false;
			});
			
			$(window).scroll(function(){
				if ($(window).scrollTop() + $(window).height() >= ($(document).height())){
					load();						
				}			
			});			
		});		
</script>

<form:form>
	<input id="mais" type="submit" name="enviar" value="Ver mais" />

	<p>
	<div id="title"></div>
	<p>
	<div id="body"></div>
	<p>
	<div id="dataCriacao"></div>
	
	<ul id="lista" style="width:300px;"></ul>


</form:form>


<div id="conteudo"></div>

