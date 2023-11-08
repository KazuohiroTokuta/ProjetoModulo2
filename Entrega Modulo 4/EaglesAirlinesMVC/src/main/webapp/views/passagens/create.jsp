<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="icon" href="./assets/img/book-2-fill.svg" type="image/svg" />
<link rel="stylesheet" href="./assets/css/style.css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
<title>Eagles Airlines | Cadastrar passagens</title>
</head>
<body>

	<header class="header">

		<nav class="navbar col-12 position-fixed navbar-expand-lg navbar-dark"
			style="background-color: #0b0744; z-index: 999;">
			<div class="container-fluid col-11 m-auto">
				<a class="navbar-brand" href="index.html"> <img
					src="./assets/imagens/eagleslogo.PNG" alt="Bootstrap"
					width="150" height="70">
				</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<jsp:include page="../../components/menu.jsp">
					<jsp:param name="home" value="./index.jsp" />
					<jsp:param name="passageiros" value="./passageiro" />
					<jsp:param name="passagens" value="./passagem" />
					<jsp:param name="pedidos" value="./pedido" />
				</jsp:include>
			</div>
		</nav>
	</header>

	<main class="newsletter">

		<div class="container py-3">
			<form action="passagem-create">
				<h2 class="text-center">Dados da passagem</h2>

				<div class="form-group mb-3">
					<label for="quantidade" class="form-label"> Quantidade </label> <input
						type="number" id="quantidade" name="quantidade"
						class="form-control" value="" />
				</div>

				<div class="form-group mb-3">
					<label for="origem" class="form-label"> Origem </label> <input
						type="text" id="origem" name="origem" class="form-control"
						value="" />
				</div>

				<div class="form-group mb-3">
					<label for="destino" class="form-label"> Destino </label> <input
						type="text" id="destino" name="destino" class="form-control"
						value="" />
				</div>

				<div class="form-group mb-3">
					<label for="valor_passagem" class="form-label"> Valor </label> <input
						type="number" id="valor_passagem" step="0.01"
						name="valor_passagem" class="form-control" value="" />
				</div>

				<div class="form-group mb-3">
					<label for="num_pedido" class="form-label"> numero do
						pedido </label> <select id="num_pedido" name="num_pedido"
						class="form-control">
						<option value="DEFAULT">Escolha o numero do pedido</option>
						<jstl:forEach items="${listaPedidos}" var="a">
							<option value="${a.num_pedido}">${a.num_pedido}</option>
						</jstl:forEach>
					</select>
				</div>

				<button type="submit" class="btn btn-primary">Cadastrar</button>
				<a href="passagem" class="btn btn-danger" style="margin-left: 10px">
					Cancelar </a>
			</form>
		</div>

	</main>
	
	<footer class="footer">
		<div class="footer_container">
			<div class="newsletter">
				<h1>Pensou que acabou? Clique em "Destino" e confira todos os
					nossos pacotes de viagem!</h1>
			</div>
			<div class="footer_content_container">
				<div class="footer_content">
					<div class="contact">
						<h1>Eagles Airlines, onde os sonhos ganham asas e a liberdade
							encontra seu destino!</h1>
						<p class="txt_md_white">kazuohirotokuta@aluno.recode.org.br</p>
					</div>
					<ul class="footer_links">
						<li>
							<h3 class="txt_lg_white">Menu</h3>
						</li>
						<li><a href="#" class="nav__link">Home</a></li>
						<li><a href="#" class="nav__link">Destino</a></li>
						<li><a href="#" class="nav__link">Promoções</a></li>
						<li><a href="#" class="nav__link">Contato</a></li>
					</ul>

				</div>
			</div>
		</div>
	</footer>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>