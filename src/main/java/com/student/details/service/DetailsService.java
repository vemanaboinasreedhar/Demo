package com.student.details.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.student.details.configuration.StudConfiguration;
import com.student.details.mapping.Mapping;
import com.student.details.model.Details;
import com.student.details.model.DetailsList;
import com.student.details.model.Response;

@Service
public class DetailsService {
	 
	@Autowired
	RestTemplate restTemplate = new RestTemplate(); 
	
	@Autowired
	StudConfiguration configuration;
	
	@Autowired
	Mapping mapping;
	
	public Response getAllStudentsDetails() {
		String url = configuration.getStudenturl();
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	   Response response =    
	    restTemplate.exchange(url, HttpMethod.GET, entity, Response.class).getBody();
		
	   return  response;
				 
	}

	public List<Details> getDetailsByRollNumber(List<Integer> rollNumber) {
		List<Details> list = new ArrayList<>();
		for(Integer roll:rollNumber) {
		String url = configuration.getStudenturl()+"/id/"+roll;
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      Response   response =    
	    restTemplate.exchange(url, HttpMethod.GET, entity, Response.class).getBody();
	      List<Details> lis = mapping.tranformTo(response);
	      list.addAll(lis);
		}
	  
	return  list;
	}

}
