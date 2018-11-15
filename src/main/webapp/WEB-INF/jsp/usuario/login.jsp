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
			<div class="row justify-content-md-center">
				<div class="col-md-6">
					<div class="card">
						<div class="card-header">
							<i class="fas fa-users"></i> Acessar o Sistema
						</div>
						<div class="card-body">
							<form action="<c:url value="/usuario/login"/>" method="post">
								<div class="form-group col-md-12">
  									<label for="email">Email</label>
  									<input type="email" class="form-control" id="email" name="email" placeholder="Email" required>
								</div>
								<div class="form-group col-md-12">
  									<label for="senha">Senha</label>
  									<input type="password" class="form-control" id="senha" name="senha" placeholder="Senha" required>
								</div>
								<div class="form-group col-md-12">
									<button type="submit" class="btn btn-primary btn-block">Acessar Sistema</button>
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