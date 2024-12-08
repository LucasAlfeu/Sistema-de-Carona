package servlet;

import DAO.AutomovelDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Automovel;
import model.Usuario;

import java.io.IOException;

/**
 * Servlet implementation class CadastrarAutomovel
 */
@WebServlet("/cadastrarAutomovel.do")
public class CadastrarAutomovel extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public CadastrarAutomovel() {
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
    String placa = request.getParameter("placa");
    String modelo = request.getParameter("modelo");
    String cor = request.getParameter("cor");
    String tipo = request.getParameter("tipo");


    HttpSession session = request.getSession(false);
    Usuario user = (Usuario) session.getAttribute("user");
    int userID = user.getIdUsuario();
    System.out.println("id do usuario: "+userID);

    Automovel a = new Automovel(placa, modelo, cor, tipo);
    AutomovelDAO dao = new AutomovelDAO();

    try{
        dao.cadastrarAutomovel(a, userID);
        response.sendRedirect("http://localhost:8080/Sistema-de-Carona/index.jsp");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        }
    }
}
