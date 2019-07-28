package com.micro.service.rule;


import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.micro.service.exception.ParametroInvalidoException;
import com.micro.service.vo.CondicaoPagamento;
import com.micro.service.vo.Produto;
import com.micro.service.vo.Requisicao;

@Service
public class ValidaParametrosRule {
	

	public void validar(Requisicao requisicao) {
		
		if(requisicao.getProduto() == null) {
			throw new ParametroInvalidoException("Objeto " + Produto.class.getName() + " não encontrado !");
		}
		
		if(requisicao.getCondicaoPagamento() == null) {
			throw new ParametroInvalidoException("Objeto " + CondicaoPagamento.class.getName() + " não encontrado !");
		}
		
		if( this.validarValor(requisicao.getProduto().getCodigo())) {
			throw new ParametroInvalidoException("Código do produto inválido");
		}
		
		if( validarValor(requisicao.getProduto().getNome()) ) {
			throw new ParametroInvalidoException("Nome do produto inválido");
		}
		
		if( this.validarValor(requisicao.getProduto().getValor()) ) {
			throw new ParametroInvalidoException("Valor do produto inválido");
		}
		
		if( this.validarValor(requisicao.getCondicaoPagamento().getQtdeParcelas())) {
			throw new ParametroInvalidoException("Quantidade de parcelas inválida");
		}
		
		if( this.validarValor(requisicao.getCondicaoPagamento().getValorEntrada())) {
			throw new ParametroInvalidoException("Valor de entrada inválido");
		}
		
		
	}
	
	private boolean validarValor(BigDecimal valor) {
		return valor == null || valor.signum() <= 0;
	}
	
	private boolean validarValor(Integer valor) {
		return valor == null || valor.intValue() <= 0;
	}
	
	private boolean validarValor(String valor) {
		return StringUtils.isEmpty(valor);
	}
	
}
