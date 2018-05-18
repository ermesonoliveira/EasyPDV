/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easypdv.DAO;
import com.easypdv.entidades.Cliente;
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
public class ClienteDAO extends GenericDAO<Cliente>{
    
    private static ClienteDAO instance;

	public static synchronized ClienteDAO getInstance() {
		if (instance == null) {
			instance = new ClienteDAO();
		}
		return instance;
	}
    
    public List<Cliente> buscar() {
        String sql = "select codigo, nome, cpf_cnpj, from cliente;";
		List<Cliente> lista = new ArrayList<>();
		try (Connection conexao = ConexaoJDBC.getInstance().getConnectionEasy();
				PreparedStatement stmt = conexao.prepareStatement(sql);) {
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				Cliente cliente = new Cliente();    
				cliente.setNome(res.getString("nome"));
                                cliente.setCodigo(res.getLong("codigo"));
                                cliente.setCpf_cnpj(res.getString("cpf_cnpj"));
				lista.add(cliente);
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
      
        
    }
    
}
