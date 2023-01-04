package com.student.details.model;

import java.util.ArrayList;
import java.util.List;

public class Data extends ArrayList<Student> {
	List<Student> studentlist ;

	public List<Student> getStudentlist() {
		return studentlist;
	}

	public void setStudentlist(List<Student> studentlist) {
		this.studentlist = studentlist;
	}
}
