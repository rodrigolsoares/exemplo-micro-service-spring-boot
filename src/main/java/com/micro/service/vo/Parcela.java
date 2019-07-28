package com.micro.service.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Parcela implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer numeroParcela;
	private BigDecimal valor;
	private Double taxaJurosAoMes;
	
	Parcela(){}
	
	public Parcela(Integer numeroParcela, BigDecimal valor, Double taxaJurosAoMes) {
		this.numeroParcela = numeroParcela;
		this.valor = valor;
		this.taxaJurosAoMes = taxaJurosAoMes;
	}



	public Integer getNumeroParcela() {
		return numeroParcela;
	}
	public void setNumeroParcela(Integer numeroParcela) {
		this.numeroParcela = numeroParcela;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Double getTaxaJurosAoMes() {
		return taxaJurosAoMes;
	}
	public void setTaxaJurosAoMes(Double taxaJurosAoMes) {
		this.taxaJurosAoMes = taxaJurosAoMes;
	}
	
	

}
