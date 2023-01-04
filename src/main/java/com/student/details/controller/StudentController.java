package com.student.details.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.details.exception.InvaildInputException;
import com.student.details.model.Data;
import com.student.details.model.Response;
import com.student.details.model.Student;
import com.student.details.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;
	Response resp = new Response();
	Data data = new Data();
	@PostMapping("/students")
	public ResponseEntity<String> saveStudents(@RequestBody List<Student> student) {
		studentService.save(student);
		return new ResponseEntity<>("updated sucessfully", HttpStatus.OK);
	}

	// getall
	@GetMapping("/students")
	public ResponseEntity<Response> getAllStudents() {
		List<Student> list = studentService.getAllStudents();
		data.addAll(list);
		resp.setData(data);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	// getById
	@GetMapping("/students/id/{rollNumber}")
	public ResponseEntity<Response>  getByRollNumber(@PathVariable int rollNumber) {
		if(rollNumber<0) {
			throw new InvaildInputException(400003, "rollNumber should not be less than '0' ");
		}
		List<Student> list = studentService.getByRollNumber(rollNumber);
		data.addAll(list);
		resp.setData(data);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	// getByName
	@GetMapping("/students/name/{name}")
	public ResponseEntity<Response>  getByName(@PathVariable String name) {
		List<Student> list = studentService.getByName(name);
		data.addAll(list);
		resp.setData(data);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	// getByMarks
	@GetMapping("/students/{marks}")
	public ResponseEntity<Response>  getByMarks(@PathVariable int marks) {
		if(marks<0) {
			throw new InvaildInputException(400003, "marks should not be less than '0' ");
		}
		List<Student> list = studentService.getByMarks(marks);
		data.addAll(list);
		resp.setData(data);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	// getByPercentage
	@GetMapping("/students/{percentage}")
	public ResponseEntity<Response>  getByPercentage(@PathVariable int percentage) {
		if(percentage<0) {
			throw new InvaildInputException(400003, "percentage should not be less than '0' ");
		}
		List<Student> list = studentService.getByPercentage(percentage);
		data.addAll(list);
		resp.setData(data);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	// getByAddress
	@GetMapping("/students/{address}")
	public ResponseEntity<Response>  getByAddress(@PathVariable String address) {
		List<Student> list = studentService.getByAddress(address);
		data.addAll(list);
		resp.setData(data);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	// getByStatus
	@GetMapping("/students/{status}")
	public ResponseEntity<Response>  getByStatus(@PathVariable String status) {
		if(!((status.equals("pass"))||(status.equals("fail")))){
			throw new InvaildInputException(400003, "status should be 'pass' or 'fail' ");
		}
		List<Student> list = studentService.getByStatus(status);
		data.addAll(list);
		resp.setData(data);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
}
