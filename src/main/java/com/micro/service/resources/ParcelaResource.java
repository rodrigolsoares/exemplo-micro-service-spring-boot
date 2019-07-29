package com.micro.service.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	Logger LOG = LoggerFactory.getLogger(ParcelaResource.class);
	
	@Autowired
	private CalculoParcelaRule calculo;
	
	@Autowired
	private ValidaParametrosRule validaParametrosRule;
	
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<?> gerarParcelas(Requisicao requisicao){
		
		LOG.info("Realizando a requisição");
		
		validaParametrosRule.validar(requisicao);
		return ResponseEntity.ok().body(calculo.executar(requisicao));
	}
	
	

}
