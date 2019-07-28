package com.micro.service.rule;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.micro.service.vo.BancoCentral;

@Service
public class BancoCentralRule {
	
	@Value("${url.bc.taxa.selic}")
	private String endpoint;
	
	public List<BancoCentral> getSelic() {
		
		String uri = endpoint + this.montaParam(); 
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<List<BancoCentral>> result = 
		restTemplate.exchange(uri,HttpMethod.GET, null, new ParameterizedTypeReference<List<BancoCentral>>(){});
				  
		return result.getBody();
	}
	
	private String montaParam() {
		
		String dataParam = getDataHoje();
		
		StringBuffer sb = new StringBuffer();
		sb.append("?formato=json&dataInicial=");
		sb.append(dataParam);
		sb.append("&dataFinal=");
		sb.append(dataParam);
		
		return sb.toString();
	}
	
	private String getDataHoje() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = sdf.format(new Date());
		return dataFormatada;
	}
	
	
}
