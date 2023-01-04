package com.student.details.service;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.student.details.model.Student;
import com.student.details.repository.StudentRepository;

@Service
public class CsvService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public void writeDetailsToCsv(Writer writer) throws IOException {
		Iterable<Student> students =  studentRepository.findAll();
		List<String> header = new ArrayList<>();
	    header.add("RollNumber");
	    header.add("Fistname");
	    header.add("Lastname");
	    header.add("Age");
	    header.add("ContactNumber");
	    header.add("Email");
	    header.add("Address");
	    header.add("Marks");
	    header.add("Percentage");
	    header.add("Status");
	    
		CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(header.toArray(new String[0])));
            for (Student student : students) {
                csvPrinter.printRecord(student.getRollNumber(),
                		student.getFistname(),
                		student.getLastname(),
                		student.getAge(),
                		student.getContactNumber(),
                		student.getEmail(),
                		student.getAddress(),
                		student.getMarks(),
                		student.getPercentage(),
                		student.getStatus());
            }
	}
	/*
	 * public void writeDetailsbyStatusToCsv(HttpServletResponse response) throws
	 * IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
	 * StatefulBeanToCsvBuilder<Iterable<Student>> builder = new
	 * com.opencsv.bean.StatefulBeanToCsvBuilder<Iterable<Student>>(response.
	 * getWriter()).withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withSeparator(
	 * CSVWriter.DEFAULT_SEPARATOR).withOrderedResults(false);
	 * StatefulBeanToCsv<Iterable<Student>> writer = builder.build();
	 * Iterable<Student> list = studentRepository.findAll(); writer.write(list); }
	 */

}
