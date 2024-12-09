package br.ufrrj.si.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrrj.si.connection.Conexao;
import br.ufrrj.si.model.Automovel;
import br.ufrrj.si.model.Carona;

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
    
    public List<Automovel> buscaAutomoveisPorIdUsuario(int id){
    	String sql = "SELECT * FROM automovel WHERE fk_Usuario_ID_usuario = ?";
    	try {
            PreparedStatement ps = null;

            ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<Automovel> automoveis = new ArrayList<>();
            while (rs.next()) {
            	Automovel a = new Automovel();
                a.setIdAutomovel(rs.getInt("ID_automovel"));
                a.setPlaca(rs.getString("placa"));
                a.setModelo(rs.getString("modelo"));
                a.setCor(rs.getString("cor"));
                a.setTipo(rs.getString("tipo"));
                a.setIdUsuario(rs.getInt("fk_Usuario_ID_usuario"));
                automoveis.add(a);
            }
            return automoveis;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erro ao buscar carona: " + e.getMessage());
            return null;


        }
    }
}
