<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="description" content="Teste para Desenvolvedor Java">
    <meta name="author" content="Rodolfo Cruz - rodolfocruz.ti@gmail.com">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<title>Gestão de Protifólio de Projetos - Stack Spring</title>
	
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" type="text/css" href="<c:url value='/bootstrap/css/bootstrap.min.css' />" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/bootstrap/css/bootstrap-grid.min.css' />" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/bootstrap/css/bootstrap-reboot.min.css' />" />	
	<link rel="stylesheet" type="text/css" href="<c:url value='/bootstrap/css/starter-template.css' />" />	
</head>

<body>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
      <a class="navbar-brand" href="https://www.linkedin.com/in/rodolfocruzti/" target="_blank">Rodolfo Cruz</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="<c:url value='/' />">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Manter</a>
            <div class="dropdown-menu" aria-labelledby="dropdown01">
              <a class="dropdown-item" href="<c:url value='/projeto/' />">Projeto</a>
            </div>
          </li>
        </ul>        
      </div>
    </nav>

	<div class="container">

		<div class="starter-template">
			<h1>Listar Projetos <a class="btn btn-outline-primary" href="<c:url value='novo' />">Novo</a></h1>	
			<div><span class="error">${mensagemErro}</span></div>		
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th>ID</th>
			      <th>Nome</th>
			      <th>Gerente</th>
			      <th>Status</th>
			      <th>Orçamento</th>
			      <th>Ação</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach items="${projetos}" var="projeto">
				    <tr>
						<th scope="row">${projeto.id}</th>
						<td>${projeto.nome}</td>
						<td>${projeto.gerente.nome}</td>
						<td>${projeto.status.descricao}</td>
						<td>${projeto.orcamento}</td>
						<td colspan="2"><a class="btn btn-outline-info" href="<c:url value='editar-${projeto.id}-projeto' />">Editar</a> &nbsp; <button type="button" class="btn btn-outline-danger" onclick="confirmarExclusao(${projeto.id})">Excluir</button></td>
			    	</tr>
		    	</c:forEach>
			  </tbody>
			</table>
		</div>

	</div>
	<!-- /.container -->

	<script src="<c:url value='/jquery/slim/js/jquery-3.2.1.slim.min.js' />"></script>
	<script src="<c:url value='/popper/js/popper.min.js' />"></script>
	<script src="<c:url value='/bootstrap/js/bootstrap.min.js' />"></script>
	<script src="<c:url value='/bootbox/js/bootbox.min.js' />"></script>
	
	<script type="text/javascript">
		function confirmarExclusao(id){
			bootbox.confirm("Deseja excluir este registro?", function(result){
				if(result===true){
					location.href = "<c:url value='deletar-"+id+"-projeto' />";
				}
			})
		}
	</script>
</body>
</html>