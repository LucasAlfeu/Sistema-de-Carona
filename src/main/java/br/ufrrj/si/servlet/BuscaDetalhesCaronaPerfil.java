package br.ufrrj.si.servlet;

import java.io.IOException;
import java.util.List;

import br.ufrrj.si.DAO.CaronaDAO;
import br.ufrrj.si.DAO.UsuarioDAO;
import br.ufrrj.si.DAO.CaronaSolicitacaoDAO;
import br.ufrrj.si.model.Carona;
import br.ufrrj.si.model.SolicitacaoCarona;
import br.ufrrj.si.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BuscaDetalhesCaronaPerfil
 */
@WebServlet("/BuscaDetalhesCaronaPerfil")
public class BuscaDetalhesCaronaPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscaDetalhesCaronaPerfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int idCarona = Integer.parseInt(request.getParameter("id"));
            CaronaDAO caronaDAO = new CaronaDAO();
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            CaronaSolicitacaoDAO solCarDAO = new CaronaSolicitacaoDAO();

            List<Carona> caronas = caronaDAO.buscarCaronaPorId(idCarona);
            Carona c = caronas.getFirst();
            int idMotorista = c.getIdUsuario();
            Usuario u = usuarioDAO.buscarUsuarioPorId(idMotorista);
            List<SolicitacaoCarona> solicitacoes = solCarDAO.buscarSolicitacoesPorIdCarona(c.getIdCarona());
            
            if (caronas != null) {
                request.setAttribute("carona", c);
                request.setAttribute("motorista", u);
                request.setAttribute("solicitacoes", solicitacoes);
                request.getRequestDispatcher("detalheCarona.jsp").forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Carona não encontrada");
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao acessar os dados");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
