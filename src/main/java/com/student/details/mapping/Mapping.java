package com.student.details.mapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.student.details.model.Details;
import com.student.details.model.Response;
import com.student.details.model.Student;

@Component
public class Mapping {

	public List<Details> tranformTo(Response response) {
		List<Details> list = new ArrayList<>();
		for(Student details:response.getData()) {
			Details d = new Details();
			d.setRollNumber(details.getRollNumber());
			d.setLastname(details.getLastname());
			d.setStatus(details.getStatus());
			list.add(d);
			
		}
		return list;
	}
	
	
	
	
	

}
