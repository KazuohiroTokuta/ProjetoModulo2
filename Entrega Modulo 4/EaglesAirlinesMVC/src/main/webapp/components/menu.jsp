<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<ul class="nav justify-content-center">
	<li class="nav-item"><a class="nav-link active"
		aria-current="page" href="<%=request.getParameter("home")%>">Home</a></li>
	<li class="nav-item"><a class="nav-link" href="<%=request.getParameter("passageiros")%>">Passageiros</a>
	</li>
	<li class="nav-item"><a class="nav-link" href="<%=request.getParameter("passagens")%>">Passagens</a></li>
	<li class="nav-item"><a class="nav-link" href="<%=request.getParameter("pedidos")%>">Pedidos</a></li>
</ul>