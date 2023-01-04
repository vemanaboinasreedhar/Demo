package com.student.details.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.student.details.model.Response;
import com.student.details.model.Student;
import com.student.details.service.StudentService;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {
	@InjectMocks
	private StudentController studentController;
	@Mock
	private StudentService studentService;
	Response resp;
	List<Student> list ;
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
		ResponseEntity<String> result = studentController.saveStudents(list);
		assertEquals(HttpStatus.OK, result.getStatusCode());
	}
	
	@Test
	@DisplayName("getallStudents")
	public void getAllStudents() {
	ResponseEntity<Response> result = studentController.getAllStudents();
	assertEquals(HttpStatus.OK, result.getStatusCode());
	}
	
	@Test
	@DisplayName("getById")
	public void getById() {
	ResponseEntity<Response> result = studentController.getByRollNumber(1);
	assertEquals(HttpStatus.OK, result.getStatusCode());
	}
	
	@Test
	@DisplayName("getByName")
	public void getByName() {
	ResponseEntity<Response> result = studentController.getByName("hello");
	assertEquals(HttpStatus.OK, result.getStatusCode());
	}
	
	@Test
	@DisplayName("getByMarks")
	public void getByMarks() {
	ResponseEntity<Response> result = studentController.getByMarks(85);
	assertEquals(HttpStatus.OK, result.getStatusCode());
	}
	
	@Test
	@DisplayName("getByPercentage")
	public void getByPercentage() {
	ResponseEntity<Response> result = studentController.getByPercentage(85);
	assertEquals(HttpStatus.OK, result.getStatusCode());
	}
	
	@Test
	@DisplayName("getByAddress")
	public void getByAddress() {
	ResponseEntity<Response> result = studentController.getByAddress("hello");
	assertEquals(HttpStatus.OK, result.getStatusCode());
	}
	
	@Test
	@DisplayName("getByStatus")
	public void getByStatus() {
	ResponseEntity<Response> result = studentController.getByStatus("pass");
	assertEquals(HttpStatus.OK, result.getStatusCode());
	}
	
	//<-----------Exception Test Case ------------------->
	
	@Test
	@DisplayName("getFailureById")
	public void getFailureById() {
	Assertions.assertThrows(Exception.class,() -> studentController.getByRollNumber(-1));
	}
	
	@Test
	@DisplayName("getFailureByMarks")
	public void getFailureByMarks() {
	Assertions.assertThrows(Exception.class,() -> studentController.getByMarks(-85));
	}
	
	@Test
	@DisplayName("getFailureByPercentage")
	public void getFailureByPercentage() {
	Assertions.assertThrows(Exception.class,() -> studentController.getByPercentage(-85));
	}
	
	@Test
	@DisplayName("getFailureByStatus")
	public void getFailureByStatus() {
	Assertions.assertThrows(Exception.class,() -> studentController.getByStatus("hello"));
	}
	
}
