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
			<div class="card">
				<div class="card-header">
					<i class="fas fa-child"></i> Cadastro de Pai ou Responsável
				</div>
				<div class="card-body">
					<form action="<c:url value="/pai/cadastrar"/>" method="post">
						<div class="form-group col-md-12">
  							<label for="nome">Nome</label>
  							<input type="text" class="form-control" id="nome" name="pai.nome" placeholder="Seu Nome" required>
						</div>
						<div class="form-group col-md-12">
  							<label for="usuario">Usuário</label>
  							<input type="text" class="form-control" id="usuario" name="pai.usuario" placeholder="Usuário" required>
						</div>
						<div class="form-group col-md-12">
  							<label for="email">CPF</label>
  							<input type="text" class="form-control" id="email" name="pai.email" placeholder="Seu CPF" required>
						</div>
						<div class="form-group col-md-12">
  							<label for="senha">Senha</label>
  							<input type="password" class="form-control" id="senha" name="pai.senha" placeholder="Sua Senha" required>
						</div>
						<div class="form-group col-md-12">
  							<label for="confirmar_senha">Confirmar Senha</label>
  							<input type="password" class="form-control" id="confirmar_senha" name="confirmarSenha" placeholder="Sua Senha" required>
						</div>
						<div class="form-group col-md-12">
							<button type="submit" class="btn btn-primary btn-block">Cadastrar</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
	
	<script src="<c:url value="static/js/jquery.min.js"/>"></script>
	<script src="<c:url value="static/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="static/js/scripts.js"/>"></script>
</html>