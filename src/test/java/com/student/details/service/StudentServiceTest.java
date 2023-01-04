package com.student.details.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.student.details.model.Student;
import com.student.details.repository.StudentRepository;

import wiremock.com.fasterxml.jackson.core.JsonParseException;
import wiremock.com.fasterxml.jackson.databind.JsonMappingException;

@RunWith(SpringRunner.class)
public class StudentServiceTest {
	@InjectMocks
	private StudentService studentService;
	@Mock
	private StudentRepository studentRepository;
	List<Student> list = new ArrayList<>(); 
	List<Student> list1 = new ArrayList<>(); 

	
	  @BeforeAll
	  public void setUp() { 
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
	  
	  }
	 
	  
	 
	@Test
	@DisplayName("saveStudents")
	public void saveStudents() {
		when(studentRepository.saveAll(list)).thenReturn(list);
		studentService.save(list);
		//assertNotNull(studentService.save(list));
	}
	
	@Test
	@DisplayName("getallStudents")
	public void getAllStudents() {
		when(studentRepository.findAll()).thenReturn(list);
	List<Student> result = studentService.getAllStudents();
	assertEquals(list, result);
	}
	
	@Test
	@DisplayName("getById")
	public void getById() {
		when(studentRepository.findByRollNumber(0)).thenReturn(list);
		List<Student> result = studentService.getByRollNumber(0);
		assertEquals(list, result);
	}
	
	@Test
	@DisplayName("getByName")
	public void getByName() {
		when(studentRepository.findByFistname(null)).thenReturn(list);
		List<Student> result = studentService.getByName(null);
		assertEquals(list, result);
	}
	
	@Test
	@DisplayName("getByMarks")
	public void getByMarks() {
		when(studentRepository.findByMarks(0)).thenReturn(list);
		List<Student> result = studentService.getByMarks(0);
		assertEquals(list, result);
	}
	
	@Test
	@DisplayName("getByPercentage")
	public void getByPercentage() {
		when(studentRepository.findByPercentage(0)).thenReturn(list);
		List<Student> result = studentService.getByPercentage(0);
		assertEquals(list, result);
	}
	
	@Test
	@DisplayName("getByAddress")
	public void getByAddress() {
		when(studentRepository.findByAddress(null)).thenReturn(list);
		List<Student> result = studentService.getByAddress(null);
		assertEquals(list, result);
	}
	
	@Test
	@DisplayName("getByStatus")
	public void getByStatus() throws JsonParseException, JsonMappingException, IOException {
		when(studentRepository.findByStatus(null)).thenReturn(list);
		List<Student> result = studentService.getByStatus(null);

		/*
		 * ObjectMapper mapper = new
		 * ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
		 * false); DetailsList list = mapper.readValue(new
		 * File("src/test/resources/DetailsList.json"), DetailsList.class);
		 */
		assertEquals(list, result);
	}
	
	//<-----------Exception Test Case ------------------->
	
	@Test
	@DisplayName("getFailureallStudents")
	public void getFailureAllStudents() {
		when(studentRepository.findAll()).thenReturn(null);
	Assertions.assertThrows(Exception.class,() -> studentService.getAllStudents());
	}
	
	@Test
	@DisplayName("getFailureById")
	public void getFailureById() {
		when(studentRepository.findByRollNumber(0)).thenReturn(null);
		Assertions.assertThrows(Exception.class,() -> studentService.getByRollNumber(0));
	}
	
	@Test
	@DisplayName("getFailureByName")
	public void getFailureByName() {
		when(studentRepository.findByFistname(null)).thenReturn(null);
		Assertions.assertThrows(Exception.class,() -> studentService.getByName(null));
	}
	
	@Test
	@DisplayName("getFailureByMarks")
	public void getFailureByMarks() {
		when(studentRepository.findByMarks(0)).thenReturn(null);
		Assertions.assertThrows(Exception.class,() -> studentService.getByMarks(0));
	}
	
	@Test
	@DisplayName("getFailureByPercentage")
	public void getFailureByPercentage() {
		when(studentRepository.findByPercentage(0)).thenReturn(null);
		Assertions.assertThrows(Exception.class,() -> studentService.getByPercentage(0));
	}
	
	@Test
	@DisplayName("getFailureByAddress")
	public void getFailureByAddress() {
		when(studentRepository.findByAddress(null)).thenReturn(null);
		Assertions.assertThrows(Exception.class,() -> studentService.getByAddress(null));
	}
	
	@Test
	@DisplayName("getFailureByStatus")
	public void getFailureByStatus() {
		when(studentRepository.findByStatus(null)).thenReturn(null);
		Assertions.assertThrows(Exception.class,() -> studentService.getByStatus(null));
	}
	}

