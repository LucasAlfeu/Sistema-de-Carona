package DAO;

import connection.Conexao;
import model.SolicitacaoCarona;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class CaronaSolicitacaoDAO {
        public void registrarSolicitacaoCarona(SolicitacaoCarona solicitacao) {
        String insertRideRequestQuery = "INSERT INTO pedido (embarque, desembarque, data, vagasDesejadas, confirmado, fk_Usuario_ID_usuaria, fk_Carona_ID_Carona) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (
                PreparedStatement statement = Conexao.getConexao().prepareStatement(insertRideRequestQuery)) {
            statement.setString(1, solicitacao.getEmbarque());
            statement.setString(2, solicitacao.getDesembarque());
            statement.setObject(3, solicitacao.getData());
            statement.setInt(4, solicitacao.getVagasDesejadas());
            statement.setBoolean(5, false); // Inicialmente, a solicitação não está confirmada
            statement.setLong(6, solicitacao.getIdUsuario());
            statement.setLong(7, 0L); // Inicialmente, não há uma carona associada

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao registrar a solicitação de carona", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        }

    public List<SolicitacaoCarona> getAllRideRequests() {
        String selectRideRequestsQuery = "SELECT * FROM pedido";
        List<SolicitacaoCarona> solicitacoes = new ArrayList<>();

        try (
             PreparedStatement statement = Conexao.getConexao().prepareStatement(selectRideRequestsQuery);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int ID_Pedido = resultSet.getInt("ID_Pedido");
                String embarque = resultSet.getString("embarque");
                String desembarque = resultSet.getString("desembarque");
                LocalDateTime data = resultSet.getObject("data", LocalDateTime.class);
                int vagasDesejadas = resultSet.getInt("vagasDesejadas");
                boolean confirmado = resultSet.getBoolean("confirmado");
                int IdUsuario = resultSet.getInt("fk_Usuario_ID_usuaria");
                int IdCarona = resultSet.getInt("fk_Carona_ID_Carona");

                SolicitacaoCarona solicitacao = new SolicitacaoCarona(
                        ID_Pedido, embarque, desembarque, data, vagasDesejadas, confirmado, IdUsuario, IdCarona
                );
                solicitacoes.add(solicitacao);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar as solicitações de carona", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return solicitacoes;
    }
}
