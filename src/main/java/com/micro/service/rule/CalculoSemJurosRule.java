package com.micro.service.rule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.micro.service.vo.Parcela;
import com.micro.service.vo.Requisicao;

@Service
public class CalculoSemJurosRule {
	
	Logger LOG = LoggerFactory.getLogger(CalculoSemJurosRule.class);
	
	public List<Parcela> calular(Requisicao requisicao){
		
		LOG.info("Calculando Parcela sem juros");
		
		List<Parcela> parcelas = new ArrayList<Parcela>();
		
		BigDecimal valorParcela = this.calcularParcelaAte6vezes(requisicao);
		
		for(int i = 1; i <= requisicao.getCondicaoPagamento().getQtdeParcelas(); i++) {
			parcelas.add(new Parcela(i, valorParcela, 0.0));
		}
		
		LOG.info("Parcela sem juros realizada com sucesso");
		
		return parcelas;
	}
	
	private BigDecimal calcularParcelaAte6vezes(Requisicao requisicao) {
		
		BigDecimal valorProduto = requisicao.getProduto().getValor();
		BigDecimal saldoDevedor = valorProduto.subtract(requisicao.getCondicaoPagamento().getValorEntrada());
		BigDecimal qtdeParcela =  new BigDecimal(requisicao.getCondicaoPagamento().getQtdeParcelas());
		return saldoDevedor.divide(qtdeParcela, BigDecimal.ROUND_UP);
	}
	
	
	
}
