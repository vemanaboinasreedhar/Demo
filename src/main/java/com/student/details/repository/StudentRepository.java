package com.student.details.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.student.details.model.Student;
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

	public List<Student> findByRollNumber(int rollNumber);

	public List<Student> findByFistname(String fistname);

	public List<Student> findByMarks(int marks);

	public List<Student> findByPercentage(int percentage);

	public List<Student> findByAddress(String address);

	public List<Student> findByStatus(String status);

}
