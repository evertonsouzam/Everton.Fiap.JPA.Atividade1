package br.com.fiap.atividade1.dao;

import java.util.List;

import br.com.fiap.atividade1.entity.Pedidos;

public interface PedidosDao {
	Pedidos incluirPedido(Pedidos pedido) throws Exception;

	List<Pedidos> listarPedidos(int idCliente) throws Exception;
}