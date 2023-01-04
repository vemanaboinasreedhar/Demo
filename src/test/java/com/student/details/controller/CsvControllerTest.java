package com.student.details.controller;

import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.student.details.service.CsvService;
 
@RunWith(SpringRunner.class)
@SpringBootTest
public class CsvControllerTest {
	
	@InjectMocks
	private CsvController csvController;
	@Mock
	private CsvService csvService;
	
	@Autowired
	HttpServletResponse response;
	
	@Test
	@DisplayName("getallStudents")
	public void getAllStudents() throws IOException {
		
		csvController.getAllStudentsInCsv(response);
	}

}
