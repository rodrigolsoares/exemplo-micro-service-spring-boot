package com.micro.service.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.service.rule.CalculoParcelaRule;
import com.micro.service.rule.ValidaParametrosRule;
import com.micro.service.vo.Requisicao;


@RestController
@RequestMapping(value="/parcelas")
public class ParcelaResource {
	
	@Autowired
	private CalculoParcelaRule calculo;
	
	@Autowired
	private ValidaParametrosRule validaParametrosRule;
	
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<?> gerarParcelas(Requisicao requisicao){
		validaParametrosRule.validar(requisicao);
		return ResponseEntity.ok().body(calculo.executar(requisicao));
	}
	
	

}
