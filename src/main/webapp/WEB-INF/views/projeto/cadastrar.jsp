<!DOCTYPE html>
<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ page contentType="text/html;charset=ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
	<!-- Required meta tags -->
	<meta charset="ISO-8859-1">
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
            <a class="nav-link dropdown-toggle" href="#" id="manterDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Manter</a>
            <div class="dropdown-menu" aria-labelledby="manterDropdown">
              <a class="dropdown-item" href="<c:url value='/projeto/' />">Projeto</a>
            </div>
          </li>
        </ul>        
      </div>
    </nav>

	<div class="container">

		<div>
			<h1>Manter Projeto</h1>
			
			
			<form:form method="POST" modelAttribute="projeto">
			<form:errors cssClass="error"/>
				
				<form:input type="hidden" path="id" id="id" />
				<div class="form-group">
					<label for="nomeInput">Nome</label>
				    <form:input type="text" class="form-control" id="nomeInput" path="nome" aria-describedby="nomeHelp" placeholder="Nome do projeto" maxlength="200" />
				    <form:errors path="nome" cssClass="error" />
				</div>
				
				<div class="form-group">
					<label for="descricaoInput">Descrição</label>
				    <form:textarea class="form-control" id="descricaoInput" path="descricao" cols="5" maxlength="5000"/>				    
		        	<form:errors path="descricao" cssClass="error" />
				</div>
				
				<div class="form-group">
					<label for="orcamentoInput">Orçamento</label>
				    <form:input type="number" step="0.01" class="form-control" path="orcamento" id="orcamentoInput"/>
		        	<form:errors path="orcamento" cssClass="error" />
				</div>
				
				<div class="form-group">
				    <label for="statusSelect">Status</label>
				    <form:select class="form-control" path="status" id="statusSelect">
				      <form:option value=""> --SELECIONE-- </form:option>
    					<form:options items="${statusList}" itemLabel="descricao"></form:options>
				    </form:select>				    
		        	<form:errors path="status" cssClass="error" />
				</div>
				
				<div class="form-group">
				    <label for="riscoSelect">Risco</label>
				    <form:select class="form-control" path="risco" id="riscoSelect">
				    	<form:option value=""> --SELECIONE-- </form:option>
    					<form:options items="${riscosList}"></form:options>
				    </form:select>
		        	<form:errors path="risco" cssClass="error" />
				</div>
				
				<div class="form-group">
				    <label for="gerenteSelect">Gerente</label>
				    <form:select class="form-control" path="gerente" items="${pessoasFuncionarioList}" id="gerenteSelect" itemLabel="nome" itemValue="id"/>
			      	<form:errors path="gerente" cssClass="error" />
				</div>
				
				<div class="form-group">
					<label for="dataInicioInput">Data início</label>
				    <form:input class="form-control" path="dataInicio" id="dataInicioInput" placeholder="Ex: dd/MM/yyyy" maxlength="10"/>
		        	<form:errors path="dataInicio" cssClass="error" />
				</div>

				<div class="form-group">
					<label for="dataPrevisaoFimInput">Data previsão fim</label>
				    <form:input class="form-control" path="dataPrevisaoFim" id="dataPrevisaoFimInput" placeholder="Ex: dd/MM/yyyy" maxlength="10"/>
		        	<form:errors path="dataPrevisaoFim" cssClass="error" />
				</div>
				
				<div class="form-group">
					<label for="dataFimInput">Data fim</label>
				    <form:input class="form-control" path="dataFim" id="dataFimInput" placeholder="Ex: dd/MM/yyyy" maxlength="10"/>
		        	<form:errors path="dataFim" cssClass="error" />
				</div>
				
				<!-- MEMBROS DO PROJETO -->
				<div class="form-group">
				    <label for="membroSelect">Membros</label>
				    <form:select class="form-control" path="membros" items="${pessoasFuncionarioList}" multiple="true" itemLabel="nome" itemValue="id"/>
					<form:errors path="membros" class="error" />
				</div>

				<a href="<c:url value='listar'/>" class="btn btn-danger" >Cancelar</a>
				<button class="btn btn-primary" type="submit">Enviar</button>
				
			</form:form>
		</div>

	</div>
	<!-- /.container -->

	<script src="<c:url value='/jquery/slim/js/jquery-3.2.1.slim.min.js' />"></script>
	<script src="<c:url value='/popper/js/popper.min.js' />"></script>
	<script src="<c:url value='/bootstrap/js/bootstrap.min.js' />"></script>
</body>
</html>