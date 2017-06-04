package br.com.fiap.atividade1.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.atividade1.entity.Pedidos;

public class MySQLPedidosDao implements PedidosDao {
	Connection cn = null;
	PreparedStatement stmt;
	ResultSet rs = null;
	@Override
	public Pedidos incluirPedido(Pedidos pedido) throws Exception {
		try {
			cn=MySQLDaoFactory.criarConexao();
			stmt = cn.prepareStatement("INSERT INTO PEDIDOS (IDCLIENTE, DATA,DESCRICAO,VALOR) VALUES (?,?,?,?)");
			stmt.setInt(1, pedido.getIdCliente());
			stmt.setDate(2, (Date) pedido.getData());
			stmt.setString(3, pedido.getDescricao());
			stmt.setDouble(4, pedido.getValor());
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if (rs.next()){
				pedido.setId(rs.getInt(1));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			cn.close();
			if (stmt != null) stmt.close();
			if (rs != null) rs.close();
		}
		return pedido;
	}

	@Override
	public List<Pedidos> listarPedidos(int idCliente) throws Exception {
		List<Pedidos> pedidos = new ArrayList<>();
		try {
			cn=MySQLDaoFactory.criarConexao();
			
			
			String sql="SELECT IDPEDIDO,DATA,DESCRICAO,VALOR FROM PEDIDOS WHERE IDCLIENTE=?";
			stmt = cn.prepareStatement(sql);
			stmt.setInt(1, idCliente);
			rs = stmt.executeQuery();
			while (rs.next()){
				pedidos.add(new Pedidos(rs.getInt("IDPEDIDO"),idCliente, rs.getDate("DATA"),rs.getString("DESCRICAO"), rs.getDouble("VALOR")));
			}
		} catch (Exception e) {
			throw e;
		}
		finally{
			cn.close();
			if (stmt != null) stmt.close();
			if (rs != null) rs.close();
		}
		
		return pedidos;
	}
}