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
				<div class="col-md-4">
					<ul class="list-group">
  						<li class="list-group-item">
  							<a href="<c:url value="/disciplina/lista/professor/${usuarioLogado.usuario.id}"/>"><i class="fas fa-book"></i> Disciplinas</a>
  						</li>
  						<li class="list-group-item">
  							<a href=""><i class="fas fa-user"></i> Meu Perfil</a>
  						</li>
  						<li class="list-group-item">
  							<a href="<c:url value="/usuario/logout"/>"><i class="fas fa-sign-out-alt"></i> Sair</a>
  						</li>
					</ul>
				</div>
				<div class="col-md-8">
					<div class="pull-right">
						<a href="<c:url value="/prova/lista/disciplina/${disciplina.id}"/>" class="btn btn-warning">Voltar</a>
					</div>
					<br>
					<div class="card">
						<div class="card-header">
							Cadastrar Prova
						</div>
						<div class="card-body">
							<form action="<c:url value="/prova/cadastrar"/>" method="post">
								<div class="col-md-12">
									<div class="form-group">
	  									<label for="nome">Nome</label>
	  									<input type="text" class="form-control" id="nome" name="prova.nome" placeholder="Ex.: 1ª Avaliação" required>
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
	  									<label for="escola">Data de Realização</label>
	  									<input type="date" class="form-control" id="escola" name="data" required>
									</div>
								</div>
								<div class="col-md-12">
									<input type="hidden" name="id" value="${disciplina.id}" />
									<button type="submit" class="btn btn-success btn-block">Salvar</button>
								</div>
							</form>
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