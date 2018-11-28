<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE>
<html>
	<head>
		<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link href="<c:url value="/static/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css">
		<link href="<c:url value="/static/css/style.css"/>" rel="stylesheet" type="text/css">
		<link href="<c:url value="/static/css/eclass.css"/>" rel="stylesheet" type="text/css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
		
		<title>E-Class</title>
	</head>
	<body>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<nav class="navbar navbar-light bg-light">
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
							<span class="navbar-toggler-icon"></span>
						</button> <a class="navbar-brand" href="<c:url value="/"/>">E-Class</a>
					</nav>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="jumbotron">
					<h2>E-Class</h2>
					<p>Bem-vindo ao E-Class, esse é um projeto que procura aliar gamificação à educação com objetivo de melhorar o desempenho de alunos da educação básica.</p>
				</div>
				<div class="col-md-3">
					<div class="card center">
  						<div class="card-body">
    						<h5 class="card-title">Cadastro de Professor</h5>
    						<i class="fas fa-user-graduate fa-5x font-primary"></i>
    						<br><br>
    						<a href="<c:url value="/professor/cadastrar"/>" class="btn btn-primary btn-block">Cadastrar Professor</a>
  						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="card center">
  						<div class="card-body">
    						<h5 class="card-title">Cadastro de Aluno</h5>
    						<i class="fas fa-user fa-5x font-primary"></i>
    						<br><br>
    						<a href="<c:url value="/aluno/cadastrar"/>" class="btn btn-primary btn-block">Cadastrar Aluno</a>
  						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="card center">
  						<div class="card-body">
    						<h5 class="card-title">Cadastro de Responsável</h5>
    						<i class="fas fa-child fa-5x font-primary"></i>
    						<br><br>
    						<a href="<c:url value="/pai/cadastrar"/>" class="btn btn-primary btn-block">Cadastrar Responsável</a>
  						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="card center">
  						<div class="card-body">
    						<h5 class="card-title">Acessar Sistema</h5>
    						<i class="fas fa-sign-in-alt fa-5x font-primary"></i>
    						<br><br>
    						<a href="<c:url value="/usuario/login"/>" class="btn btn-primary btn-block">Acessar Sistema</a>
  						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
	
	<script src="<c:url value="static/js/jquery.min.js"/>"></script>
	<script src="<c:url value="static/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="static/js/scripts.js"/>"></script>
</html>