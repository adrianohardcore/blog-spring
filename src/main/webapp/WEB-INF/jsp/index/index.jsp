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

$(function() {
	var dados = jQuery(this).serialize();
	var proximo = 1;

	jQuery.ajax({
		type : "get",
		url : "pagina/1",
		data : dados,
		success : function(data) {
			$('#conteudo').append( data);
			//alert(data);
		}
	});

	return false;
	
	jQuery('#ajax_form').submit(function() {
		var dados = jQuery(this).serialize();
		var proximo = 2;
		

		jQuery.ajax({
			type : "get",
			url : "pagina/" + proximo,
			data : dados,
			success : function(data) {
				$('#conteudo').append( data);
				//alert(data);
			}
		});

		return false;
	});


	    
});
	jQuery(document).ready(function() {		
			});
</script>



<div id="conteudo"></div>

<form method="post" action="" id="ajax_form">
	<label><input type="submit" name="enviar" value="Mais" /></label>
</form>





