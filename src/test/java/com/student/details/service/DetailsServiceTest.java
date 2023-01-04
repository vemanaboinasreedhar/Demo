package com.student.details.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.student.details.configuration.StudConfiguration;
import com.student.details.model.Data;
import com.student.details.model.Details;
import com.student.details.model.DetailsList;
import com.student.details.model.Response;
import com.student.details.model.Student;


@RunWith(SpringRunner.class)

@SpringBootTest



/*
 * @ContextConfiguration(classes = { DetailsService.class })
 * 
 * @AutoConfigureWireMock(port = 8088)
 * 
 * @TestInstance(TestInstance.Lifecycle.PER_CLASS)
 */
 
 
public class DetailsServiceTest {

	@InjectMocks
	private DetailsService detailsService;

	@Mock
	private StudConfiguration configuration;

	@Mock
	private RestTemplate restTemplate;
	
	 
	@Test
		@DisplayName("get all details")
		public void getAllDetails() {
		Response response1 = new Response();
		Data data = new Data();
		List<Student> list = new ArrayList<>(); 
		Student student = new Student();
		  student.setRollNumber(1);
		  student.setFistname("hello");
		  student.setLastname("hello"); 
		  student.setAge(25);
		  student.setContactNumber(789456123);
		  student.setEmail("hello");
		  student.setAddress("hello");
		  student.setMarks(85);
		  student.setPercentage(85);
		  student.setStatus("hello"); 
		  list.add(student);
		data.addAll(list);
		response1.setData(data);
	ResponseEntity<Response> response=new ResponseEntity<Response>(response1, HttpStatus.OK);
		        when(restTemplate.exchange(
		        		Mockito.any(String.class),
		                Mockito.<HttpMethod> any(),
		                Mockito.<HttpEntity<Response>> any(),
		                Mockito.<Class<Response>> any()))
		        .thenReturn(response);
		        when(configuration.getStudenturl()).thenReturn("/student");
		        //assertNull(detailsService.getAllStudentsDetails());
		  assertEquals(response.getBody(), detailsService.getAllStudentsDetails());
		        
		    }

	//@Test
	@DisplayName("get all details")
	public void getAllDetails1() {
		DetailsList list = new DetailsList();
		Details details = new Details();
			 details.setRollNumber(2);
			 details.setLastname("hello");
			 details.setStatus("pass");
			 list.add(details);
	        ResponseEntity<DetailsList> response=new ResponseEntity<DetailsList>(list, HttpStatus.OK);
	        when(restTemplate.exchange(
	        		Mockito.any(String.class),
	                Mockito.<HttpMethod> any(),
	                Mockito.<HttpEntity<DetailsList>> any(),
	                Mockito.<Class<DetailsList>> any()))
	        .thenReturn(response);
	        when(configuration.getStudenturl()).thenReturn("/student");
	    assertEquals(response.getBody(),detailsService.getAllStudentsDetails());
	        
	    }

	

	}

