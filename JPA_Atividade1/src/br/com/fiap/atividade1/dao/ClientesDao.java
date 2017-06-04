package br.com.fiap.atividade1.dao;

import br.com.fiap.atividade1.entity.Clientes;

public interface ClientesDao {
	Clientes inserirCliente(Clientes cliente) throws Exception;

	Clientes buscarCliente(int id) throws Exception;
}