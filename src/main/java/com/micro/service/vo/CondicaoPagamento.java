package com.micro.service.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class CondicaoPagamento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private BigDecimal valorEntrada;
	private Integer qtdeParcelas;
	
	public BigDecimal getValorEntrada() {
		return valorEntrada;
	}
	
	public void setValorEntrada(BigDecimal valorEntrada) {
		this.valorEntrada = valorEntrada;
	}
	
	public Integer getQtdeParcelas() {
		return qtdeParcelas;
	}
	
	public void setQtdeParcelas(Integer qtdeParcelas) {
		this.qtdeParcelas = qtdeParcelas;
	}
	
	
}
