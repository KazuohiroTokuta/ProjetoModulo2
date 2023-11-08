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
import com.eaglesairlines.modelos.Passageiros;

@WebServlet(urlPatterns = { "/passageiro", "/passageiro-create", "/passageiro-edit", "/passageiro-update",
		"/passageiro-delete" })
public class PassageiroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PassageiroDAO pdao = new PassageiroDAO();
	Passageiros passageiro = new Passageiros();

	public PassageiroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/passageiro":
			read(request, response);
			break;
		case "/passageiro-create":
			create(request, response);
			break;
		case "/passageiro-edit":
			edit(request, response);
			break;
		case "/passageiro-update":
			update(request, response);
			break;
		case "/passageiro-delete":
			delete(request, response);
			break;
		default:
			response.sendRedirect("index.html");
			break;

		}

	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Passageiros> lista = pdao.read();

		request.setAttribute("listaPassageiros", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/passageiros/index.jsp");
		rd.forward(request, response);

	}
	
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		passageiro.setCPF(request.getParameter("CPF"));
		passageiro.setnome_passageiro(request.getParameter("nome"));
		passageiro.setPassaporte(request.getParameter("passaporte"));
		passageiro.setemail(request.getParameter("email"));
		passageiro.setTelefone(request.getParameter("telefone"));

		pdao.create(passageiro);
		response.sendRedirect("passageiro");
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String CPF = request.getParameter("CPF");
		
		passageiro = pdao.readById(CPF);
		
		request.setAttribute("passageiro", passageiro);

		RequestDispatcher rd = request.getRequestDispatcher("./views/passageiros/update.jsp");
		rd.forward(request, response);
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		passageiro.setCPF(request.getParameter("CPF"));
		passageiro.setnome_passageiro(request.getParameter("nome"));
		passageiro.setPassaporte(request.getParameter("passaporte"));
		passageiro.setemail(request.getParameter("email"));
		passageiro.setTelefone(request.getParameter("telefone"));

		pdao.update(passageiro);
		response.sendRedirect("passageiro");
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String CPF = request.getParameter("CPF");
		pdao.delete(CPF);
		response.sendRedirect("passageiro");

	}

}
