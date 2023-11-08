package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eaglesairlines.dao.PassagemDAO;
import com.eaglesairlines.dao.PedidosDAO;
import com.eaglesairlines.modelos.Passagem;
import com.eaglesairlines.modelos.Pedidos;

@WebServlet(urlPatterns = { "/passagem", "/passagem-create", "/passagem-getCreate", "/passagem-edit", "/passagem-update",
		"/passagem-delete" })
public class PassagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PassagemDAO psgmdao = new PassagemDAO();
	Passagem passagem = new Passagem();
	PedidosDAO pedidao = new PedidosDAO();
	Pedidos pedido = new Pedidos();

	public PassagemServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/passagem":
			read(request, response);
			break;
		case "/passagem-create":
			create(request, response);
			break;
		case "/passagem-getCreate":
			getCreate(request, response);
			break;
		case "/passagem-edit":
			edit(request, response);
			break;
		case "/passagem-update":
			update(request, response);
			break;
		case "/passagem-delete":
			delete(request, response);
			break;
		default:
			response.sendRedirect("index.html");
			break;

		}

	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Passagem> lista = psgmdao.read();

		request.setAttribute("listaPassagens", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/passagens/index.jsp");
		rd.forward(request, response);

	}
	
	protected void getCreate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Pedidos> listaPedidos = pedidao.read();
		request.setAttribute("listaPedidos", listaPedidos);
		RequestDispatcher rd = request.getRequestDispatcher("./views/passagens/create.jsp");
		rd.forward(request, response);
		
	}
	
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		int quantidade = (Integer.parseInt(request.getParameter("quantidade")));
		String origem =  request.getParameter("origem");
		String destino =  request.getParameter("destino");
		double valor_passagem = (Double.parseDouble(request.getParameter("valor_passagem")));
		Pedidos pedido = pedidao.readById(Integer.parseInt(request.getParameter("num_pedido")));
		
		passagem = new Passagem(quantidade, origem, destino, valor_passagem, pedido);
		
		psgmdao.create(passagem);
		response.sendRedirect("passagem");
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_passagem = Integer.parseInt(request.getParameter("id_passagem"));
		
		passagem = psgmdao.readById(id_passagem);
		
		request.setAttribute("passagem", passagem);
		
		List<Pedidos> listaPedidos = pedidao.read();
		request.setAttribute("listaPedidos", listaPedidos);

		RequestDispatcher rd = request.getRequestDispatcher("./views/passagens/update.jsp");
		rd.forward(request, response);
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		passagem.setId_passagem(Integer.parseInt(request.getParameter("id_passagem")));
		passagem.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
		passagem.setOrigem(request.getParameter("origem"));
		passagem.setDestino(request.getParameter("destino"));
		passagem.setValor_passagem(Double.parseDouble(request.getParameter("valor_passagem")));
		passagem.setPedido(pedidao.readById(Integer.parseInt(request.getParameter("num_pedido"))));

		psgmdao.update(passagem);
		response.sendRedirect("passagem");
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int Id_passagem = Integer.parseInt(request.getParameter("id_passagem"));
		psgmdao.delete(Id_passagem);
		response.sendRedirect("passagem");

	}

}
