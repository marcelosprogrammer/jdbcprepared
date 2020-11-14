package br.com.jcavitreinamentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.jcavitreinamentos.conexao.Conexao;
import br.com.jcavitreinamentos.interfaces.IUsuario;

public class UsuarioDao extends Conexao implements IUsuario {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	Statement stmt;
	
	
	public UsuarioDao() throws ClassNotFoundException, SQLException {
		super();
		conn = Conexao.conectar();
	}

	@Override
	public void inserir() throws Exception {
		String sql = "INSERT INTO Users (username, password, fullname, email) VALUES (?, ?, ?, ?)";
		 
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "Pica Pau");
		pstmt.setString(2, "123456");
		pstmt.setString(3, "Roger Miland");
		pstmt.setString(4, "chamart@uol.com");
		 
		int inserido = pstmt.executeUpdate();
		if (inserido > 0) {
		    System.out.println("Usuário Inserido com Sucesso!");
		}

	}

	@Override
	public void excluir() throws Exception {
		String sql = "DELETE FROM Users WHERE username=?";
		 
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "bill");
		 
		int deletado = pstmt.executeUpdate();
		if (deletado > 0) {
		    System.out.println("Usuario deletado com sucesso!");
		}

	}

	@Override
	public void atualizar() throws Exception {
		String sql = "UPDATE Users SET password=?, fullname=?, email=? WHERE username=?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "123456789");
		pstmt.setString(2, "William Henry Bill Gates");
		pstmt.setString(3, "bill.gates@microsoft.com");
		pstmt.setString(4, "bill");
		
		int atualizado = pstmt.executeUpdate();
		if (atualizado > 0) {
		System.out.println("Dados Atualizados com Sucesso!");
		}

	}

	@Override
	public void listar() throws Exception {
		String sql = "SELECT * FROM Users";
		 
		pstmt = conn.prepareStatement("select * from users");
		rs = pstmt.executeQuery();
		 
		int count = 0;
		 
		while (rs.next()){
		    String name = rs.getString(2);
		    String pass = rs.getString(3);
		    String fullname = rs.getString("fullname");
		    String email = rs.getString("email");
		 
		    System.out.println(name);
		    System.out.println(pass);
		    System.out.println(fullname);
		    System.out.println(email);
		    System.out.println("****************************************");
		    
		}
	}

}
