package br.senai.sp.cfp127.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static Connection con;
	
	public static Connection getConexao(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbURL ="jdbc:mysql://localhost:3306/db_inf2ta?useTimezone=true&serverTimezone=UTC";
			String user = "root";
			String pass = "123456";
			con = DriverManager.getConnection(dbURL, user, pass);
			System.out.println("Banco conectado");
		}catch(Exception e){
			System.out.println("ocorreu um erro");
			e.printStackTrace();
		}
		return con;
	}
	
	public static void fecharConexao() {
		try {
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}