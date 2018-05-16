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
    
    public List<Usuario> buscar() {
        String sql = "select codigo, nome from usuario;";
		List<Usuario> lista = new ArrayList<>();
		try (Connection conexao = ConexaoJDBC.getInstance().getConnectionEasy();
				PreparedStatement stmt = conexao.prepareStatement(sql);) {
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				Usuario usuario = new Usuario();
				usuario.setCodigo(res.getLong("codigo"));
                                usuario.setNome(res.getString("nome"));
				lista.add(usuario);
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
      
        
    }
    
    
}
