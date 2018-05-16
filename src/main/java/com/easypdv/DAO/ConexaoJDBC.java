/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easypdv.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ermeson
 */
public class ConexaoJDBC {
    
    public static ConexaoJDBC getInstance() {
		return new ConexaoJDBC();
	}
    
    
    public Connection getConnectionEasy() throws SQLException {
		Connection connection = null;
		
		String driverName = "com.mysql.cj.jdbc.Driver";                        
		String serverName = "localhost:3306";    
		String mydatabase ="easypdv";        
		String url = "jdbc:mysql://" + serverName + "/" + mydatabase+"?useTimezone=true&serverTimezone=UTC";
		String username = "root";              
		String password = "root";  
		
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
		return connection;
		
	}
    
}
