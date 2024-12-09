package br.ufrrj.si.servlet;

import java.io.IOException;

import br.ufrrj.si.DAO.CaronaSolicitacaoDAO;
import br.ufrrj.si.model.SolicitacaoCarona;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SolicitarCarona")
public class SolicitarCarona extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
    public void init() {
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse respons) throws IOException{
    	doPost(request, respons);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        String embarque = request.getParameter("embarque");
        String desembarque = request.getParameter("desembarque");
        String data = request.getParameter("data");
        int vagasDesejadas = Integer.parseInt(request.getParameter("vagas"));
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        int idCarona = Integer.parseInt(request.getParameter("idCarona"));

        CaronaSolicitacaoDAO solicitacaCaronaDAO = new CaronaSolicitacaoDAO();
        
        SolicitacaoCarona solicitacao = new SolicitacaoCarona(embarque, desembarque, data, vagasDesejadas, idUsuario, idCarona);
        
        solicitacaCaronaDAO.registrarSolicitacaoCarona(solicitacao);
        
        System.out.println(vagasDesejadas);
        response.sendRedirect("http://localhost:8080/Sistema-de-Carona/paginaPrincipal.jsp");
    }
}
