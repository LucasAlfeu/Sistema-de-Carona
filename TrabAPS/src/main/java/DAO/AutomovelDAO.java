package DAO;

import connection.Conexao;
import model.Automovel;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AutomovelDAO {
    public void cadastrarAutomovel(Automovel a, int userId) throws ClassNotFoundException {
        String sql = "INSERT INTO Automovel (placa,modelo,cor,tipo,fk_Usuario_ID_usuario) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setString(1, a.getPlaca());
            ps.setString(2, a.getModelo());
            ps.setString(3, a.getCor());
            ps.setString(4, a.getTipo());
            ps.setInt(5, userId);

            ps.executeUpdate();
            System.out.println("Automóvel cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar automóvel: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
