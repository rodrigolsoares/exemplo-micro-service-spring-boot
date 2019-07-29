package com.micro.service.rule;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.micro.service.vo.Parcela;
import com.micro.service.vo.Requisicao;

@Service
public class CalculoComJurosRule {
	
	Logger LOG = LoggerFactory.getLogger(CalculoComJurosRule.class);
	
	public List<Parcela> calular(Requisicao requisicao, double taxaSelic){
		
		LOG.info("Calculando Parcela com juros");
		
		List<Parcela> parcelas = new ArrayList<Parcela>();

		BigDecimal valorApagar = this.calcularValorTotal(requisicao, taxaSelic);
		BigDecimal valorParcela = this.calcularParcela(requisicao, valorApagar);
		
		for(int i = 1; i <= requisicao.getCondicaoPagamento().getQtdeParcelas(); i++) {
			parcelas.add(new Parcela(i, valorParcela, taxaSelic));
		}
		
		LOG.info("Parcela com juros realizada com sucesso");
		
		return parcelas;
	}
	
		
	private BigDecimal calcularValorTotal(Requisicao requisicao, double taxaSelic) {
		
		BigDecimal valorProduto = requisicao.getProduto().getValor();
		BigDecimal saldoDevedor = valorProduto.subtract(requisicao.getCondicaoPagamento().getValorEntrada());
		BigDecimal taxaJuros = new  BigDecimal(taxaSelic);
		BigDecimal valor_fixo_Formula =  new BigDecimal(1);
		BigDecimal acrescimento = (valor_fixo_Formula.add(taxaJuros)).pow(requisicao.getCondicaoPagamento().getQtdeParcelas());
		BigDecimal valor =  saldoDevedor.multiply(acrescimento);
		
		return valor.setScale(2, RoundingMode.HALF_EVEN);
		
	}
	
	private BigDecimal calcularParcela(Requisicao requisicao, BigDecimal valorApagar) {
		BigDecimal qtdeParcela =  new BigDecimal(requisicao.getCondicaoPagamento().getQtdeParcelas());
		return valorApagar.divide(qtdeParcela, BigDecimal.ROUND_UP);
	}
	
}
