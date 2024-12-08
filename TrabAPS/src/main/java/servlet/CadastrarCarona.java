package servlet;

import java.io.IOException;

import DAO.CaronaDAO;
import DAO.UsuarioDAO;
import jakarta.servlet.http.HttpSession;
import model.Carona;
import model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CadastrarUsuario
 */
@WebServlet("/cadastrarCarona")
public class CadastrarCarona extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public CadastrarCarona() {
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
        String saida = request.getParameter("saida");
        String chegada = request.getParameter("chegada");
        String dataCarona = request.getParameter("data");
        String horario = request.getParameter("horario");
        float valor = Float.parseFloat(request.getParameter("valor"));
        int vagas = Integer.parseInt(request.getParameter("vagas"));
        String carro = request.getParameter("veiculo");

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("http://localhost:8080/Sistema-de-Carona/index.jsp");
            return;
        }
        Usuario user = (Usuario) session.getAttribute("user");
        int usuarioID = user.getIdUsuario();
        System.out.println("id do usuario: "+usuarioID);

        Carona c = new Carona(saida, chegada, horario, (int) valor, vagas, carro, dataCarona);
        CaronaDAO caronaDAO = new CaronaDAO();

        try {
            caronaDAO.cadasatrarCarona(c, usuarioID);
            response.sendRedirect("http://localhost:8080/Sistema-de-Carona/paginaPrincipal.jsp");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
