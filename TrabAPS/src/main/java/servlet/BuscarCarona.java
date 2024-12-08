package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import DAO.CaronaDAO;
import jakarta.servlet.http.HttpSession;
import model.Carona;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CadastrarUsuario
 */
@WebServlet("/BuscarCarona")
public class BuscarCarona extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public BuscarCarona() {
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
        String origem = request.getParameter("origem");
        String destino = request.getParameter("destino");
        String data = request.getParameter("data");





        CaronaDAO caronaDAO = new CaronaDAO();

        List<Carona> caronas = caronaDAO.buscarCarona(origem, destino, data);

        HttpSession session = request.getSession();
        session.setAttribute("caronas", caronas);
        response.sendRedirect("paginaPrincipal.jsp");


    }

}