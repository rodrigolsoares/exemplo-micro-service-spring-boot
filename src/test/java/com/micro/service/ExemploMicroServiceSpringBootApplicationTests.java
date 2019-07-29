package com.micro.service;

import java.net.URISyntaxException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.micro.service.vo.Errors;
import com.micro.service.vo.Parcela;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ExemploMicroServiceSpringBootApplicationTests {
	
	@LocalServerPort
    int randomServerPort;
	
	
	@Test
	public void testGetParcelaMaiorQue6vezesSuccess() throws URISyntaxException
	{
		
	    final String url = "http://localhost:" + randomServerPort + "/parcelas";
	    
	    UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
	    		
	    builder.queryParam("produto.codigo", "10");
	    builder.queryParam("produto.nome", "Televisão 4k 60 polegadas");
	    builder.queryParam("produto.valor", "14000.00");
	    builder.queryParam("condicaoPagamento.valorEntrada", "1000.00");
	    builder.queryParam("condicaoPagamento.qtdeParcelas", "10");

	    RestTemplate restTemplate = new RestTemplate();
	  
	    ResponseEntity<List<Parcela>> result = 
	    		restTemplate.exchange(builder.toUriString(),HttpMethod.GET, null, new ParameterizedTypeReference<List<Parcela>>(){});
	    
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertTrue(!result.getBody().isEmpty());
		
	 
	}
	
	@Test
	public void testGetParcelaMenorQue6vezesSuccess() throws URISyntaxException
	{
		
	    final String url = "http://localhost:" + randomServerPort + "/parcelas";
	    
	    UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
	    		
	    builder.queryParam("produto.codigo", "6");
	    builder.queryParam("produto.nome", "Televisão 4k 60 polegadas");
	    builder.queryParam("produto.valor", "14000.00");
	    builder.queryParam("condicaoPagamento.valorEntrada", "1000.00");
	    builder.queryParam("condicaoPagamento.qtdeParcelas", "10");

	    RestTemplate restTemplate = new RestTemplate();
	  
	    ResponseEntity<List<Parcela>> result = 
	    		restTemplate.exchange(builder.toUriString(),HttpMethod.GET, null, new ParameterizedTypeReference<List<Parcela>>(){});
	    
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertTrue(!result.getBody().isEmpty());
		
	 
	}
	
	
	@Test(expected = InternalServerError.class)
	public void testRequisicaoSemParametros() throws URISyntaxException
	{
		
	    final String url = "http://localhost:" + randomServerPort + "/parcelas";
	    UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
	    		
	    RestTemplate restTemplate = new RestTemplate();	  
	    ResponseEntity<Errors> result = restTemplate.getForEntity(builder.toUriString(), Errors.class);

	 
	}
	
	
	
	

}
