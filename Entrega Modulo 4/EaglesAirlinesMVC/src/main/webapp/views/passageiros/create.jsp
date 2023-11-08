<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>		
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="icon" href="./assets/img/book-2-fill.svg" type="image/svg" />
<link rel="stylesheet" href="../../assets/css/style.css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
<title>Eagles Airlines | Cadastrar passageiro</title>
</head>
<body>

<header class="header">

		<nav class="navbar col-12 position-fixed navbar-expand-lg navbar-dark"
			style="background-color: #0b0744; z-index: 999;">
			<div class="container-fluid col-11 m-auto">
				<a class="navbar-brand" href="index.html"> <img
					src="../../assets/imagens/eagleslogo.PNG" alt="Bootstrap" width="150"
					height="70">
				</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<jsp:include page="../../components/menu.jsp">
		<jsp:param name="home" value="../../index.jsp" />
		<jsp:param name="passageiros" value="../../passageiro" />
		<jsp:param name="passagens" value="../../passagem" />
		<jsp:param name="pedidos" value="../../pedido" />
	</jsp:include>
			</div>
		</nav>
	</header>


	<main class="newsletter">
		
		
		<div class="container py-3">
            <form action="../../passageiro-create">
	            <h2 class="text-center">Cadastrar</h2>
	            <div class="form-group mb-3">
	                <label for="nome" class="form-label">
	                    Nome
	                </label>
	                <input type="text" id="nome" name="nome" class="form-control" value="" />
	            </div>
	            
	            <div class="form-group mb-3">
	                <label for="CPF" class="form-label">
	                    CPF
	                </label>
	                <input type="text" id="CPF" name="CPF" class="form-control" value="" />
	            </div>
	            
	            <div class="form-group mb-3">
	                <label for="passaporte" class="form-label">
	                    Passaporte
	                </label>
	                <input type="text" id="passaporte" name="passaporte" class="form-control" value="" />
	            </div>
	            
	            <div class="form-group mb-3">
	                <label for="email" class="form-label">
	                    Email
	                </label>
	                <input type="email" id="email" name="email" class="form-control" value="" />
	            </div>
	            
	            <div class="form-group mb-3">
	                <label for="telefone" class="form-label">
	                    Telefone
	                </label>
	                <input type="text" id="telefone" name="telefone" class="form-control" value="" />
	            </div>
	            
	
	            <button type="submit" class="btn btn-primary">
	                Cadastrar
	            </button>
	            <a href="../../passageiro" class="btn btn-danger" style="margin-left: 10px">
	                Cancelar
	            </a>
            </form>
        </div>
		
    </main>
    
	<footer class="footer">
		<div class="footer_container">
			<div class="newsletter">
				<h1>Pensou que acabou? Clique em "Destino" e confira todos os nossos pacotes de viagem!</h1>
			</div>
			<div class="footer_content_container">
				<div class="footer_content">
					<div class="contact">
						<h1>Eagles Airlines, onde os sonhos ganham asas e a liberdade encontra seu destino!</h1>
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
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>