package com.micro.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ExemploMicroServiceSpringBootApplicationTests {
	
	@LocalServerPort
    int randomServerPort;
	
	
	@Test
	public void testGetParcelaSuccess() throws URISyntaxException
	{
		
	    final String baseUrl = "http://localhost:" + randomServerPort + "/parcelas";
	   
	    RestTemplate restTemplate = new RestTemplate();
	    URI uri = new URI(baseUrl);
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	
		Assert.assertEquals(200, result.getStatusCodeValue());
	 
	    
	}	

}
