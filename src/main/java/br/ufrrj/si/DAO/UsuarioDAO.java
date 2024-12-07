package br.ufrrj.si.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	public Usuario buscarUsuario(String usuario, String senha) {
		String sql = "SELECT * FROM usuario WHERE usuario = ? AND senha = ?";
		try{
			PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
			ps.setString(1, usuario);
			ps.setString(2, senha);
			ResultSet rs = ps.executeQuery();
			Usuario u = new Usuario();
			rs.next();
			u.setIdUsuario(rs.getInt("ID_usuario"));
			u.setUsuario(rs.getString("usuario"));
			u.setSenha(rs.getString("senha"));
			u.setNome(rs.getString("nome"));
			u.setCpf(rs.getString("cpf"));
			u.setTelefone(rs.getString("telefone"));

			return u;
		}
		catch (Exception e){
			System.out.println("Erro ao buscar usuario: " + e.getMessage());
			return null;
		}
	}
}

