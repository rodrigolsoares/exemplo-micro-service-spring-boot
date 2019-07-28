package com.micro.service.rule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.service.vo.Parcela;
import com.micro.service.vo.Requisicao;

@Service
public class CalculoSemJurosRule {
	
	
	public List<Parcela> calular(Requisicao requisicao){
		
		List<Parcela> parcelas = new ArrayList<Parcela>();
		
		BigDecimal valorParcela = this.calcularParcelaAte6vezes(requisicao);
		
		for(int i = 1; i <= requisicao.getCondicaoPagamento().getQtdeParcelas(); i++) {
			parcelas.add(new Parcela(i, valorParcela, 0.0));
		}
		
		return parcelas;
	}
	
	private BigDecimal calcularParcelaAte6vezes(Requisicao requisicao) {
		
		BigDecimal valorProduto = requisicao.getProduto().getValor();
		BigDecimal saldoDevedor = valorProduto.subtract(requisicao.getCondicaoPagamento().getValorEntrada());
		BigDecimal qtdeParcela =  new BigDecimal(requisicao.getCondicaoPagamento().getQtdeParcelas());
		return saldoDevedor.divide(qtdeParcela, BigDecimal.ROUND_UP);
	}
	
	
	
}
