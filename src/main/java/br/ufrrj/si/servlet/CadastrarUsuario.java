package br.ufrrj.si.servlet;

import java.io.IOException;

import br.ufrrj.si.DAO.UsuarioDAO;
import br.ufrrj.si.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CadastrarUsuario
 */
@WebServlet("/cadastrarUsuario.do")
public class CadastrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CadastrarUsuario() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String telefone = request.getParameter("telefone");
		
		Usuario u = new Usuario();
		
		u.setUsuario(usuario);
		u.setSenha(senha);
		u.setNome(nome);
		u.setCpf(cpf);
		u.setTelefone(telefone);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		usuarioDAO.cadastrarUsuario(u);
		
		response.sendRedirect("http://localhost:8080/Sistema-de-Carona/");
	}

}
