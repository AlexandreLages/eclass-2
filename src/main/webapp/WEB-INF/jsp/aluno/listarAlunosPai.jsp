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
  							<a href="<c:url value="/aluno/lista/pai/${usuarioLogado.usuario.id}"/>"><i class="fas fa-child"></i> Filhos</a>
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
					<div class="align-rigth">
						<a href="<c:url value="/pai/relacionar/${usuarioLogado.usuario.id}"/>" class="btn btn-primary">Adicionar Filho</a>
					</div>
					<br>
					<br>
					<div class="row">
						<c:forEach items="${filhos}" var="filho" varStatus="item">
							<div class="col-md-6">
								<div class="card center">
		  							<div class="card-body">
		    							<a href="<c:url value="/disciplina/lista/filho/${filho.id}"/>"><img width="30%" class="rounded-circle" src="<c:url value="/static/user-img.jpg"/>"></img></a>
		    							<h5 class="card-title">${filho.nome}</h5>
		    							<h6 class="card-subtitle">${filho.email}</h6>
		  							</div>
	  							</div>
	  							<c:if test="${item.index mod 2 == 0}">
	  								<br>
	  							</c:if>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</body>
	
	<script src="<c:url value="static/js/jquery.min.js"/>"></script>
	<script src="<c:url value="static/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="static/js/scripts.js"/>"></script>
</html>