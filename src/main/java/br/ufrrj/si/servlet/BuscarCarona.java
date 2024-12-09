package br.ufrrj.si.servlet;

import java.io.IOException;
import java.util.List;

import br.ufrrj.si.DAO.CaronaDAO;
import br.ufrrj.si.model.Carona;
import jakarta.servlet.RequestDispatcher;
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

       
        request.setAttribute("caronas", caronas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("paginaPrincipal.jsp");
        dispatcher.forward(request, response);


    }

}