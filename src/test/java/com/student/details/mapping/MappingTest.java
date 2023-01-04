package com.student.details.mapping;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.student.details.model.Details;
import com.student.details.model.Response;

import wiremock.com.fasterxml.jackson.core.JsonParseException;
import wiremock.com.fasterxml.jackson.databind.DeserializationFeature;
import wiremock.com.fasterxml.jackson.databind.JsonMappingException;
import wiremock.com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)

@SpringBootTest
public class MappingTest {
	
	@InjectMocks
     private Mapping mapping;
	
	
	@Test
	@DisplayName("tranformTo")
	public void tranformTo() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new
				 ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				  false);
		Response response = mapper.readValue(new
				 File("src/test/resources/Response.json"), Response.class); 
	
		List<Details> list = mapping.tranformTo(response);
		assertNotNull(list);
		
	}
	
	
	
}