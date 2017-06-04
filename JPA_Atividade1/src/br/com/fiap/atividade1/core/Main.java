package br.com.fiap.atividade1.core;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.atividade1.dao.ClientesDao;
import br.com.fiap.atividade1.dao.DaoFactory;
import br.com.fiap.atividade1.dao.PedidosDao;
import br.com.fiap.atividade1.entity.Clientes;
import br.com.fiap.atividade1.entity.Pedidos;

public class Main {

	public static void main(String[] args) {
		try {
			ClientesDao clientesDao = DaoFactory.getDaoFactory(DaoFactory.MYSQL).getClientesDao();

			List<Pedidos> listaPedidos = new ArrayList<>();
			
			Clientes cliente = new Clientes();
			cliente.setId(1);
			cliente.setNome("Everton Mendes");
			cliente.setEmail("everton.mendes@gmail.com");
			cliente = clientesDao.inserirCliente(cliente);
			
			PedidosDao pedidosDao = DaoFactory.getDaoFactory(DaoFactory.MYSQL).getPedidosDao();
			
			Pedidos pedido = new Pedidos();
			pedido.setData(new Date(5, 5, 17));
			pedido.setDescricao("Materiais Escritório");
			pedido.setValor(9000);
			pedido.setIdCliente(cliente.getId());
			
			pedidosDao.incluirPedido(pedido);
			
			listaPedidos = pedidosDao.listarPedidos(7);
			for (Pedidos pedidos : listaPedidos) {
				System.out.println(pedidos.getDescricao());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	

}
