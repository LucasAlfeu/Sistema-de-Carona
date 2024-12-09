package br.ufrrj.si.servlet;

import java.io.IOException;
import java.util.List;

import br.ufrrj.si.DAO.CaronaDAO;
import br.ufrrj.si.DAO.CaronaSolicitacaoDAO;
import br.ufrrj.si.model.Carona;
import br.ufrrj.si.model.SolicitacaoCarona;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfirmaCarona
 */
@WebServlet("/ConfirmaCarona")
public class ConfirmaCarona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmaCarona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idSolicitacao = Integer.parseInt(request.getParameter("idSolicitacao")); 
		int idCarona = Integer.parseInt(request.getParameter("idCarona"));
		
		CaronaSolicitacaoDAO solicitacaoDAO = new CaronaSolicitacaoDAO();
		CaronaDAO caronaDAO = new CaronaDAO();
		
		SolicitacaoCarona solicitacao = solicitacaoDAO.buscarSolicitacaoPorId(idSolicitacao);
		
		List<Carona> lc = null;
		try {
			lc = caronaDAO.buscarCaronaPorId(idCarona);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Carona c = null;
		if(lc != null) {
			c = lc.getFirst();
		}
		
		if (c.getVagas() - solicitacao.getVagasDesejadas() < 0) {
			
		} else {
			try {
				caronaDAO.atualizaVagas(idCarona, solicitacao.getVagasDesejadas());
				solicitacaoDAO.atualizaStatusSolicitacao(idSolicitacao);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
