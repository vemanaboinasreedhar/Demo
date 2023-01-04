package com.student.details.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.student.details.service.CsvService;

@RestController
public class CsvController {
	@Autowired
	CsvService csvService;
	
	@GetMapping("/download/studentsDetails")
	public void getAllStudentsInCsv(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"StudentsDetails.csv\"");
        csvService.writeDetailsToCsv(servletResponse.getWriter());
	}
	
	
}
