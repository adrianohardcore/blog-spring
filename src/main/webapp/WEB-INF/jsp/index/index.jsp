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
		var proximo = 0;
		//Carregar()

		jQuery('#mais').click(function() {
			//Carregar()
			loadJson()
			//teste()

			return false;
		});

		function Carregar() {
			var dados = jQuery(this).serialize();
			proximo++

			jQuery.ajax({
				type : "get",
				url : "pagina/" + proximo,
				data : dados,
				success : function(data) {
					$('#conteudo').append(data);
				}
			});

			return false;
		}

		function teste() {
			alert("Teste");
			return false;
		}

		function loadJson() {

			jQuery.ajax({
				type : "get",
				dataType : 'json',
				url : "records2",
				data : dados,
				success : function(data) {
					$.each(data,function(){
						alert(this['title']);	
						//$('#title').append(this['title'])
					});	
				}
			});
			return false;
		}
	});
</script>

<form:form>
	<input id="mais" type="submit" name="enviar" value="Ver mais" />

	<div id="title"></div>
	<div id="body"></div>
	<div id="dataModificacao"></div>


</form:form>


<div id="conteudo"></div>

