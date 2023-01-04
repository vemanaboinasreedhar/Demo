package com.student.details.service;


import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestTemplate;

import com.student.details.configuration.StudConfiguration;
import com.student.details.model.Details;
import com.student.details.model.Response;

@SpringBootTest
@AutoConfigureWireMock(port = 8088)
public class DetailsServiceWireMockTest {
	

	
	@Autowired
	private RestTemplate restTemplate;
	
	@InjectMocks
	private DetailsService detailsService;

	@Mock
	private StudConfiguration configuration;
	
	//@Test
	@DisplayName("get all details")
	public void getAllDetails() {
		when(configuration.getStudenturl()).thenReturn("http://localhost:8088/student");
		
		Response response = detailsService.getAllStudentsDetails();
		assertNotNull(response);
	}
	
}
