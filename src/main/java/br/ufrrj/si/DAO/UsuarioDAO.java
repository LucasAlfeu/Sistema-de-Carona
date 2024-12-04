package br.ufrrj.si.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.ufrrj.si.connection.Conexao;
import br.ufrrj.si.model.Usuario;

public class UsuarioDAO {
	public void cadastrarUsuario(Usuario u) {
		String sql = "INSERT INTO Usuario (usuario, senha, nome, cpf, telefone) VALUES (?,?,?,?,?)";
		PreparedStatement ps = null;
		try {
				try {
					ps = Conexao.getConexao().prepareStatement(sql);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	            
	            ps.setString(1, u.getUsuario());
	            ps.setString(2, u.getSenha());
	            ps.setString(3, u.getNome());
	            ps.setString(4, u.getCpf());
	            ps.setString(5, u.getTelefone());

	            ps.executeUpdate();
	            System.out.println("Usuário cadastrado com sucesso!");
	        } catch (SQLException e) {
	            System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
	            e.printStackTrace();
	        }
		}
}

