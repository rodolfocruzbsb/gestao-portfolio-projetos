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
			<h1>Gestão de Protifólio de Projetos - Stack Spring</h1>
			
			
			
			<p class="lead">
				Projeto para gestão de portifólios de projetos de uma empresa, utilizando a Stack Spring<br>
				<a href="https://github.com/rodolfocruzbsb" target="_blank">Github - rodolfocruzbsb</a><br>
				<a href="https://twitter.com/RodolfocruzTi" target="_blank">Twitter - @RodolfocruzTi</a><br>
			</p>
		</div>

	</div>
	<!-- /.container -->

	<script src="<c:url value='/jquery/slim/js/jquery-3.2.1.slim.min.js' />"></script>
	<script src="<c:url value='/popper/js/popper.min.js' />"></script>
	<script src="<c:url value='/bootstrap/js/bootstrap.min.js' />"></script>
</body>
</html>