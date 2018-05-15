package com.mycompany.varejo.dao;

import com.mycompany.varejo.util.ConfigBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDataBase {

	private static final String URL_MYSQL = "jdbc:firebirdsql:"+ConfigBD.lerArquivo()+"/3050:C:/easypdv/BANCO.FDB";
	
	private static final String DRIVER_CLASS = "org.firebirdsql.jdbc.FBDriver";
	
	private static final String USER = "SYSDBA";
	
	private static final String PASS = "masterkey";
	
	public static Connection getConnection(){
		try{
			Class.forName(DRIVER_CLASS);
			return DriverManager.getConnection(URL_MYSQL, USER, PASS);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
}
