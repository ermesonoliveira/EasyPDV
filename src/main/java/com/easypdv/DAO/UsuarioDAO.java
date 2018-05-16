/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easypdv.DAO;

import com.easypdv.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Ermeson
 */
public class UsuarioDAO extends GenericDAO<Usuario>{
    private static UsuarioDAO instance;

	public static synchronized UsuarioDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioDAO();
		}
		return instance;
	}
    
    public List<Usuario> buscar() {
        String sql = "select nome, cpf from usuario;";
		List<Usuario> lista = new ArrayList<>();
		try (Connection conexao = ConexaoJDBC.getInstance().getConnectionEasy();
				PreparedStatement stmt = conexao.prepareStatement(sql);) {
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				Usuario usuario = new Usuario();
				usuario.setNome(res.getString("nome"));
                                usuario.setCpf(res.getString("cpf"));
				lista.add(usuario);
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
      
        
    }
    
    
}
