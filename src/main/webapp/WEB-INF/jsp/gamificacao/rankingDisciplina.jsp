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
  							<a href=""><i class="fas fa-book"></i> Disciplinas</a>
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
						<a href="<c:url value="/disciplina/aluno/detalha/${idDisciplina}"/>" class="btn btn-warning">Voltar</a>
					</div>
					<br>
					<div class="card">
						<div class="card-header">
							<i class="fas fa-trophy"></i> Líder do Ranking
						</div>
						<div class="card-body">
							<b>${lider.nome}</b>
						</div>
					</div>
					<br>
					<div class="card">
						<div class="card-header">
							<i class="fas fa-trophy"></i> Ranking
						</div>
						<div class="card-body">
							<table style="width:100%">
								<c:forEach items="${ranking}" var="rank">
									<tr>
										<td width="10%" align="center"><img width="60%" class="rounded-circle" src="<c:url value="/static/user-img.jpg"/>"></img></td>
										<td width="60%" align="left" class="vertical-align"><b>${rank.nome}</b></td>
										<td width="20%" align="right" class="vertical-align"><h5><span class="badge badge-success span-xp">${rank.xp} XP</span></h5></td>
									</tr>
								</c:forEach>
							</table>
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