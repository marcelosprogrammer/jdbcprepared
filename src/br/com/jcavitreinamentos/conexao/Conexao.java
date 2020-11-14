package br.com.jcavitreinamentos.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/jcavi2020";
	static final String USER = "root";
	static final String PASS = "";

	static Connection conn = null;

	public Conexao() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
	}

	public static Connection conectar() {
		return conn;

	}
}
