package br.ufrrj.si.DAO;

import br.ufrrj.si.connection.*;
import br.ufrrj.si.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CaronaSolicitacaoDAO {
        public void registrarSolicitacaoCarona(SolicitacaoCarona solicitacao) {
        String insertRideRequestQuery = "INSERT INTO pedido (embarque, desembarque, data, vagasDesejadas, confirmado, fk_Usuario_ID_usuario, fk_Carona_ID_Carona) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (
                PreparedStatement statement = Conexao.getConexao().prepareStatement(insertRideRequestQuery)) {
            statement.setString(1, solicitacao.getEmbarque());
            statement.setString(2, solicitacao.getDesembarque());
            statement.setObject(3, solicitacao.getData());
            statement.setInt(4, solicitacao.getVagasDesejadas());
            statement.setString(5, "Solicitada"); // Inicialmente, a solicitação não está confirmada
            statement.setLong(6, solicitacao.getIdUsuario());
            statement.setLong(7, solicitacao.getIdCarona()); // Inicialmente, não há uma carona associada

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
                String data = resultSet.getString("data");
                int vagasDesejadas = resultSet.getInt("vagasDesejadas");
                String confirmado = resultSet.getString("confirmado");
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
    
    public List<SolicitacaoCarona> buscarSolicitacoesPorIdIsiario(int id){
    	String sql = "SELECT * FROM pedido WHERE fk_Usuario_ID_usuario = ?";
        try {
            PreparedStatement ps = null;

            ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<SolicitacaoCarona> solicitacoes = new ArrayList<>();
            while (rs.next()) {
            	SolicitacaoCarona s = new SolicitacaoCarona();
                s.setID_Pedido(rs.getInt("ID_Pedido"));
                s.setEmbarque(rs.getString("embarque"));
                s.setDesembarque(rs.getString("desembarque"));
                s.setData(rs.getString("data"));
                s.setVagasDesejadas(rs.getInt("vagasDesejadas"));
                s.setConfirmado(rs.getString("confirmado"));
                s.setIdUsuario(rs.getInt("fk_Usuario_ID_usuario"));
                s.setIdCarona(rs.getInt("fk_Carona_ID_Carona"));
                solicitacoes.add(s);
            }
            return solicitacoes;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erro ao buscar carona: " + e.getMessage());
            return null;


        }
    }
    
    public List<SolicitacaoCarona> buscarSolicitacoesPorIdCarona(int id){
    	String sql = "SELECT * FROM pedido WHERE fk_Carona_ID_Carona = ?";
        try {
            PreparedStatement ps = null;

            ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<SolicitacaoCarona> solicitacoes = new ArrayList<>();
            while (rs.next()) {
            	SolicitacaoCarona s = new SolicitacaoCarona();
                s.setID_Pedido(rs.getInt("ID_Pedido"));
                s.setEmbarque(rs.getString("embarque"));
                s.setDesembarque(rs.getString("desembarque"));
                s.setData(rs.getString("data"));
                s.setVagasDesejadas(rs.getInt("vagasDesejadas"));
                s.setConfirmado(rs.getString("confirmado"));
                s.setIdUsuario(rs.getInt("fk_Usuario_ID_usuario"));
                s.setIdCarona(rs.getInt("fk_Carona_ID_Carona"));
                solicitacoes.add(s);
            }
            return solicitacoes;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erro ao buscar carona: " + e.getMessage());
            return null;


        }
    }
    
    public SolicitacaoCarona buscarSolicitacaoPorId(int idSolicitacao) {
    	String sql = "SELECT * FROM pedido WHERE ID_Pedido = ?";
    	try{
			PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
			ps.setInt(1, idSolicitacao);
			ResultSet rs = ps.executeQuery();
			SolicitacaoCarona c = new SolicitacaoCarona();
			rs.next();
			c.setID_Pedido(rs.getInt("ID_Pedido"));
			c.setEmbarque(rs.getString("embarque"));
			c.setDesembarque(rs.getString("desembarque"));
			c.setData(rs.getString("data"));
			c.setVagasDesejadas(rs.getInt("vagasDesejadas"));
			c.setConfirmado(rs.getString("confirmado"));
			c.setIdUsuario(rs.getInt("fk_Usuario_ID_usuario"));
			c.setIdCarona(rs.getInt("fk_Carona_ID_Carona"));

			return c;
		}
		catch (Exception e){
			System.out.println("Erro ao buscar usuario: " + e.getMessage());
			return null;
		}
    }
    
    public void atualizaStatusSolicitacao(int id, String status) throws ClassNotFoundException {
        String sql = "UPDATE pedido SET confirmado = ? WHERE ID_Pedido = ?";

        try {
        	PreparedStatement ps = null;

            ps = Conexao.getConexao().prepareStatement(sql);

            ps.setString(1, status);
            ps.setInt(2, id);
            
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar o número de vagas", e);
        }
    }
}
