package servlet;

import java.io.IOException;
import java.util.Enumeration;

import DAO.UsuarioDAO;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CadastrarUsuario
 */
@WebServlet("/Logar")
public class Logar extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public Logar() {
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
        String usuario = request.getParameter("username");
        String senha = request.getParameter("password");

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        Usuario u = usuarioDAO.buscarUsuario(usuario, senha);

        HttpSession session = request.getSession();

        session.setAttribute("user", u);
        response.sendRedirect("paginaPrincipal.jsp");



    }

}
