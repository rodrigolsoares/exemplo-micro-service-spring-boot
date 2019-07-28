package com.micro.service.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.service.vo.BancoCentral;
import com.micro.service.vo.Parcela;
import com.micro.service.vo.Requisicao;

@Service
public class CalculoParcelaRule {
	
	private static double Taxa_SELIC_FIXA = 0.0115;
	private static int TOTAL_PARCELA_SEM_JUROS = 6;
	
	@Autowired
	private BancoCentralRule bancoCentral;
	
	@Autowired
	private CalculoSemJurosRule calculoSemJuros;
	
	@Autowired
	private CalculoComJurosRule  calculoComJuros;
	
	public List<Parcela> executar(Requisicao requisicao){
		
		
		if( requisicao.getCondicaoPagamento().getQtdeParcelas() <= TOTAL_PARCELA_SEM_JUROS ) {
			
			return calculoSemJuros.calular(requisicao);
			
		}else {
			
			double taxaSelic = Taxa_SELIC_FIXA;
			List<BancoCentral> listaBancoCentral =  bancoCentral.getSelic();
			
			if(!listaBancoCentral.isEmpty()) {
				taxaSelic = Double.parseDouble(listaBancoCentral.get(0).getValor());
			}
			
			return calculoComJuros.calular(requisicao, taxaSelic);
			
		}
		
	
	}
	
	
	

	
	
}
