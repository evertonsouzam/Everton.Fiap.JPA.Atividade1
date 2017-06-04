package br.com.fiap.atividade1.entity;

import java.io.Serializable;
import java.util.Date;

public class Pedidos implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	private int idCliente;
	private Date data;
	private String descricao;
	private double valor;

	public Pedidos(){
		
	}
	
	public Pedidos(int id, int idCliente, Date date, String descricao, double valor) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.data = date;
		this.descricao = descricao;
		this.valor = valor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	
	
}