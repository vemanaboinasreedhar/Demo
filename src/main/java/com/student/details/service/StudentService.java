package com.student.details.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.details.exception.NoDataFound;
import com.student.details.model.Student;
import com.student.details.repository.StudentRepository;
@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	public void save(List<Student> student) {
		studentRepository.saveAll(student);
		
	}
	
	public List<Student> getAllStudents() {
		if(studentRepository.findAll() == null) {
			throw new NoDataFound(404001, "No data found");
		}
		return (List<Student>) studentRepository.findAll();
	}

	public List<Student> getByRollNumber(int rollNumber) {
		if(studentRepository.findByRollNumber(rollNumber) == null) {
			throw new NoDataFound(404001, "No data found with 'rollNumber' = "+rollNumber);
		}
		return (List<Student>) studentRepository.findByRollNumber(rollNumber);
	}

	public List<Student> getByName(String name) {
		if(studentRepository.findByFistname(name) == null) {
			throw new NoDataFound(404001, "No data found with 'name' = "+name);
		}
		return (List<Student>) studentRepository.findByFistname(name);
	}

	public List<Student> getByMarks(int marks) {
		if(studentRepository.findByMarks(marks) == null) {
			throw new NoDataFound(404001, "No data found with 'marks' = "+marks);
		}
		return (List<Student>) studentRepository.findByMarks(marks);
	}

	public List<Student> getByPercentage(int percentage) {
		if(studentRepository.findByPercentage(percentage) == null) {
			throw new NoDataFound(404001, "No data found with 'percentage' = "+percentage);
		}
		return (List<Student>) studentRepository.findByPercentage(percentage);
	}

	public List<Student> getByAddress(String address) {
		if(studentRepository.findByAddress(address) == null) {
			throw new NoDataFound(404001, "No data found with 'address' = "+address);
		}
		return (List<Student>) studentRepository.findByAddress(address);
	}

	public List<Student> getByStatus(String status) {
		if(studentRepository.findByStatus(status) == null) {
			throw new NoDataFound(404001, "No data found with 'status' = "+status);
		}
		return (List<Student>) studentRepository.findByStatus(status);
	}

}
