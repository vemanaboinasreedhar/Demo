package com.student.details.controller;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.student.details.mapping.Mapping;
import com.student.details.model.Details;
import com.student.details.model.DetailsList;
import com.student.details.model.Response;
import com.student.details.service.DetailsService;

@RunWith(MockitoJUnitRunner.class)
public class DetailsControllerTest {
	@InjectMocks
	private DetailsController detailsController;
	@Mock
	private DetailsService detailsService;
	@Mock
	private Mapping mapping;
	

	
	@Test
	@DisplayName("get all details")
	public void getAllDetails() throws Exception{
		List<Details>  list = new ArrayList();
		Response response = new Response();
		when(detailsService.getAllStudentsDetails()).thenReturn(response);
		when(mapping.tranformTo(response)).thenReturn(list);
		ResponseEntity<List<Details> > result = detailsController.getAllStudentsDetails();
		assertTrue((result.getBody()).isEmpty());
	}
	@Test
	@DisplayName("get all details by rollNumber")
	public void getDetailsByRollNumber() throws Exception{
		List<Details>  list = new ArrayList();
		List<Integer> rollNumber = new ArrayList();
		rollNumber.add(0);
		when(detailsService.getDetailsByRollNumber(rollNumber)).thenReturn(list);
		ResponseEntity<List<Details>> result = detailsController.getDetailsByRollNumber(rollNumber);
		assertEquals(HttpStatus.OK, result.getStatusCode());
	}

}
