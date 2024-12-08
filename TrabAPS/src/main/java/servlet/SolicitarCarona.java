package servlet;

import DAO.CaronaSolicitacaoDAO;
import DAO.UsuarioDAO;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import model.SolicitacaoCarona;
import model.Usuario;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;


public class SolicitarCarona extends HttpServlet {
    private CaronaSolicitacaoDAO solicitacaoCaronaDAO;
    private UsuarioDAO usuarioDAO;

    @Override
    public void init() {
        solicitacaoCaronaDAO = new CaronaSolicitacaoDAO();
        usuarioDAO = new UsuarioDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Obter os dados do formulário
        String embarque = request.getParameter("embarque");
        String desembarque = request.getParameter("desembarque");
        String data = request.getParameter("data");
        int vagasDesejadas = Integer.parseInt(request.getParameter("vagasDesejadas"));

        // Converter a data/hora de partida
        LocalDateTime departureTime = LocalDateTime.parse(data);

        // Obter o usuário
        HttpSession session = request.getSession(false);
        Usuario user = (Usuario) session.getAttribute("user");

        // Criar a solicitação de carona
        SolicitacaoCarona solicitacao = new SolicitacaoCarona(
                embarque, desembarque, departureTime, vagasDesejadas, false, user.getIdUsuario()
        );

        // Registrar a solicitação de carona
        solicitacaoCaronaDAO.registrarSolicitacaoCarona(solicitacao);

        // Redirecionar o usuário para uma página de confirmação
        response.sendRedirect("http://localhost:8080/Sistema-de-Carona/paginaPrincipal.jsp");
    }
}
