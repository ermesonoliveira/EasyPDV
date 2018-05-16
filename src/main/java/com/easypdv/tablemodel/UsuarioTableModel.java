package com.easypdv.tableModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.easypdv.entidades.Usuario;

public class UsuarioTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private final int COL_NOME = 0;
	private final int COL_CPF = 1;
	
	private final String[] colunas = { "Nome", "Cpf"};

	private List<Usuario> usuario;

	public UsuarioTableModel(List<Usuario> usuarios) throws SQLException {
		this();
		usuario.addAll(usuarios);
		fireTableStructureChanged();
	}

	public UsuarioTableModel() {
		usuario = new ArrayList<>();
	}

	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return usuario.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Usuario u = usuario.get(rowIndex);
		if (columnIndex == COL_NOME) {
			return u.getNome().toUpperCase();
		} else if (columnIndex == COL_CPF) {
			return u.getCpf();
		} 
		return "";
	}

}
