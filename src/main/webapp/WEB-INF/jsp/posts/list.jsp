<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ taglib prefix="form" uri= "http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri= "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri= "http://java.sun.com/jsp/jstl/functions" %>

<head>
	<title>Postagens</title>
</head>

<body>
  <div>
    <h2>Listing Posts</h2>
    
    <c:url var="urlPesquisa" value="/postsearch" />  
    

	<form:form action="/postsearch" commandName="searchCriteria" method="POST">
	    <fieldset>
	        <legend>Pesquisa</legend>
	        <div>
	            <form:label path="searchTerm">Termo da pesquisa</form:label>
	            <form:input path="searchTerm" type="text"/>
	        </div>
	        <div>
	            <input type="submit" value="Pesquisar"/>
	        </div>
	    </fieldset>
	</form:form>




	
    
    <c:if test="${not empty posts}">
      <table>
        <tr>
         <th>Código</th>                    
         <th>Título</th>         
         <th></th>
         <th></th>
          <th></th>
        </tr>
       	
        <c:forEach items="${posts}" var="post">
          <c:url var="url" value="/posts/${post.id}" />
          <tr>
            <td>${post.id}</td>                    
            <td>${post.title}</td>            
            <td >
                      
            <form:form action="${url}" method="GET">
            	<input alt="Exibir Post" src="<c:url value="/static/images/show.png"/>" 
                title="Exibir Post" type="image" value="Exibir Post"/>
            </form:form>            
            </td>
            
            <td>
              <form:form action="${url}/form" method="GET">
                <input alt="Atualizar Post" src="<c:url value="/static/images/update.png"/>" title="Atualizar Post"type="image" value="Atualizar Post"/>
              </form:form>
            </td>
            
            <td>
              <form:form action="${url}" method="DELETE">
                <input alt="Excluir Post" src="<c:url value="/static/images/delete.png"/>" title="Excluir Post" type="image" value="Excluir Post"/>
              </form:form>
            </td>
            
          </tr>
        </c:forEach>
      </table>
    </c:if>
    <c:if test="${empty posts}">Não há posts no momento.</c:if>
         
    <div id="menu">
      <a href="<c:url value="/posts/form"/>">Novo</a>       
    </div>
    
  </div>
</body>