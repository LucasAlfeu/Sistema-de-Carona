package br.ufrrj.si.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.ufrrj.si.connection.Conexao;
import br.ufrrj.si.model.Carona;

public class CaronaDAO {
	public void cadasatrarCarona(Carona c, int userId) throws ClassNotFoundException {
		String sql = "INSERT INTO carona (saida, chegada, dataCarona, horario, valor, vagas, carro, fk_Usuario_ID_usuario) VALUES (?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
			
			ps.setString(1, c.getSaida());
			ps.setString(2, c.getChegada());
			ps.setString(3, c.getDataCarona());
			ps.setString(4, c.getHorario());
			ps.setInt(5, c.getValor());
			ps.setInt(6, c.getVagas());
			ps.setString(7, c.getCarro());
			ps.setInt(8, userId);
			
            ps.executeUpdate();
            System.out.println("Carona cadastrado com sucesso!");
		} catch (SQLException e) {
            System.out.println("Erro ao cadastrar carona: " + e.getMessage());
            e.printStackTrace();
        }
		
	}
}
