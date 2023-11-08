package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eaglesairlines.dao.PassageiroDAO;
import com.eaglesairlines.dao.PedidosDAO;
import com.eaglesairlines.modelos.Passageiros;
import com.eaglesairlines.modelos.Pedidos;


@WebServlet(urlPatterns = { "/pedido", "/pedido-create", "/pedido-getCreate", "/pedido-edit", "/pedido-update",
"/pedido-delete" })
public class PedidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PedidosDAO pedidao = new PedidosDAO();
	Pedidos pedido = new Pedidos();
	PassageiroDAO pdao = new PassageiroDAO();
	Passageiros passageiro = new Passageiros();
    
    public PedidoServlet() {
        super();
       
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/pedido":
			read(request, response);
			break;
		case "/pedido-create":
			create(request, response);
			break;
		case "/pedido-getCreate":
			getCreate(request, response);
			break;
		case "/pedido-edit":
			edit(request, response);
			break;
		case "/pedido-update":
			update(request, response);
			break;
		case "/pedido-delete":
			delete(request, response);
			break;
		default:
			response.sendRedirect("index.html");
			break;

		}

	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Pedidos> lista = pedidao.read();

		request.setAttribute("listaPedidos", lista);
		
		List<Passageiros> listaPassageiros = pdao.read();
		request.setAttribute("listaPassageiros", listaPassageiros);

		RequestDispatcher rd = request.getRequestDispatcher("./views/pedidos/index.jsp");
		rd.forward(request, response);

	}
	
	protected void getCreate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Passageiros> listaPassageiros = pdao.read();
		request.setAttribute("listaPassageiros", listaPassageiros);
		RequestDispatcher rd = request.getRequestDispatcher("./views/pedidos/create.jsp");
		rd.forward(request, response);;
		
	}
	
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String dt_pedido = request.getParameter("dt_pedido");
		String forma_pgmto = request.getParameter("forma_pgmto");
		Passageiros passageiro = pdao.readById(request.getParameter("CPF"));
		pedido = new Pedidos(dt_pedido, forma_pgmto, passageiro);
	
		pedidao.create(pedido);
		response.sendRedirect("pedido");
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num_pedido = Integer.parseInt(request.getParameter("num_pedido"));
		
		pedido = pedidao.readById(num_pedido);
		
		request.setAttribute("pedido", pedido);
		
		List<Passageiros> listaPassageiros = pdao.read();
		request.setAttribute("listaPassageiros", listaPassageiros);

		RequestDispatcher rd = request.getRequestDispatcher("./views/pedidos/update.jsp");
		rd.forward(request, response);
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		pedido.setNum_pedido(Integer.parseInt(request.getParameter("num_pedido")));
		pedido.setDt_pedido(request.getParameter("dt_pedido"));
		pedido.setForma_pgmto(request.getParameter("forma_pgmto"));
		pedido.setPassageiro(pdao.readById(request.getParameter("CPF")));

		pedidao.update(pedido);
		response.sendRedirect("pedido");
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int num_pedido = Integer.parseInt(request.getParameter("num_pedido"));
		pedidao.delete(num_pedido);
		response.sendRedirect("pedido");

	}

}

