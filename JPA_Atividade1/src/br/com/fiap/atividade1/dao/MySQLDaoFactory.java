package br.com.fiap.atividade1.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLDaoFactory extends DaoFactory{
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/vendas";

	public static Connection criarConexao() throws Exception{ 
		return DriverManager.getConnection(URL,"root","");
	}

	@Override
	public ClientesDao getClientesDao() {
		return new MySQLClientesDao();
	}

	@Override
	public PedidosDao getPedidosDao() {
		return new MySQLPedidosDao();
	}
}