package com.student.details.service;

import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.student.details.model.Details;
import com.student.details.model.DetailsList;
import com.student.details.model.Student;
import com.student.details.repository.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CsvServiceTest {
	@InjectMocks
	private CsvService csvService;
	@Mock
	private StudentRepository studentRepository;
	
	@Autowired
	HttpServletResponse response;
	
	@Test
	@DisplayName("getallStudents")
	public void getAllStudents() throws IOException {
		 List<Student> list = new ArrayList<>();
		Student student = new Student();
		  student.setRollNumber(1); student.setFistname("hello");
		  student.setLastname("hello"); student.setAge(25);
		  student.setContactNumber(789456123); student.setEmail("hello");
		  student.setAddress("hello"); student.setMarks(85); student.setPercentage(85);
		  student.setStatus("hello"); 
		  list.add(student);
		when(studentRepository.findAll()).thenReturn(list);
	csvService.writeDetailsToCsv(response.getWriter());
}

	@Test
	@DisplayName("IOException")
	public void getAllStudentsIOExceptionTest() throws IOException {
		List<Student> list = new ArrayList<>();
		when(studentRepository.findAll()).thenReturn(list);
	Assertions.assertThrows(Exception.class,() -> csvService.writeDetailsToCsv(null));
}
}