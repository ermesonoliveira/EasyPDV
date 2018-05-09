package com.mycompany.varejo.dao;

import java.sql.Connection;
import java.sql.SQLException;


public class GenericDao {

	private Connection connection;

	protected GenericDao() {
		this.connection = ConnectionDataBase.getConnection();
	}

	public Connection getConnection() {
		return connection;
	}

	protected void save(String insertSql, Object... parametros) throws SQLException {
		          PreparedStatement pstmt = (PreparedStatement) getConnection().prepareStatement(insertSql);
		for (int i = 0; i < parametros.length; i++) {
			pstmt.setObject(i + 1, parametros[i]);
		}

		pstmt.execute();
		pstmt.close();
	}

	protected void update(String updateSql, Object id, Object... parametros) throws SQLException {
		PreparedStatement pstmt = (PreparedStatement) getConnection().prepareStatement(updateSql);

		for (int i = 0; i < parametros.length; i++) {
			pstmt.setObject(i + 1, parametros[i]);
		}
		pstmt.setObject(parametros.length + 1, id);
		pstmt.execute();
		pstmt.close();
	}

	protected void delete(String deleteSql, Object... parametros) throws SQLException {
		PreparedStatement pstmt = (PreparedStatement) getConnection().prepareStatement(deleteSql);

		for (int i = 0; i < parametros.length; i++) {
			pstmt.setObject(i + 1, parametros[i]);
		}

		pstmt.execute();
		pstmt.close();
	}

}