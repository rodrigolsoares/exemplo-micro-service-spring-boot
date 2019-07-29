package com.micro.service.rule;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.service.vo.BancoCentral;
import com.micro.service.vo.Parcela;
import com.micro.service.vo.Requisicao;

@Service
public class CalculoParcelaRule {
	
	Logger LOG = LoggerFactory.getLogger(CalculoParcelaRule.class);
	
	private static double Taxa_SELIC_FIXA = 0.0115;
	private static int TOTAL_PARCELA_SEM_JUROS = 6;
	
	@Autowired
	private BancoCentralRule bancoCentral;
	
	@Autowired
	private CalculoSemJurosRule calculoSemJuros;
	
	@Autowired
	private CalculoComJurosRule  calculoComJuros;
	
	public List<Parcela> executar(Requisicao requisicao){
		
		LOG.info("Codigo do produto: " + requisicao.getProduto().getCodigo() );
		LOG.info("Nome do produto: " + requisicao.getProduto().getNome() );
		LOG.info("Valor do produto: " + requisicao.getProduto().getValor());
		LOG.info("Valor de entrada: " + requisicao.getCondicaoPagamento().getValorEntrada() );
		LOG.info("Total de parcela: " + requisicao.getCondicaoPagamento().getQtdeParcelas() );
		
		if( requisicao.getCondicaoPagamento().getQtdeParcelas() <= TOTAL_PARCELA_SEM_JUROS ) {
			
			LOG.info("Realizando calculo sem Juros");
			return calculoSemJuros.calular(requisicao);
			
		}else {
			
			LOG.info("Realizando calculo com Juros");
			double taxaSelic = Taxa_SELIC_FIXA;
			List<BancoCentral> listaBancoCentral =  bancoCentral.getSelic();
			
			LOG.info("Taxa Selic: " + taxaSelic);
			if(!listaBancoCentral.isEmpty()) {
				taxaSelic = Double.parseDouble(listaBancoCentral.get(0).getValor());
			}
			
			return calculoComJuros.calular(requisicao, taxaSelic);
			
		}
		
	
	}
	
	
	

	
	
}
