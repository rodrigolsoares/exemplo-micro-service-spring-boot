package com.micro.service.vo;

import java.io.Serializable;

public class Requisicao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Produto produto;
	private CondicaoPagamento condicaoPagamento;
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public CondicaoPagamento getCondicaoPagamento() {
		return condicaoPagamento;
	}
	
	public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}
	
	

}
