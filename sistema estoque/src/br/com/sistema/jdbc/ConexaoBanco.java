package br.com.sistema.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoBanco {

	final private String url = "jdbc:mysql://localhost/sistemaestoque";
	final private String usuario = "root";
	final private String senha = "";

	public Connection pegarConexao() {
		try {
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro ao se conectar com o banco de dados " + e);
		}
		return null;
	}

}
