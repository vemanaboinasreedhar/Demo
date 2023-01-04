package com.student.details.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.details.mapping.Mapping;
import com.student.details.model.Details;
import com.student.details.model.Response;
import com.student.details.service.DetailsService;
@RestController
public class DetailsController {
	@Autowired
	DetailsService detailsService;
	@Autowired
	Mapping mapping;
	
	@GetMapping("/details")
	public ResponseEntity<List<Details> > getAllStudentsDetails() 
	{
		Response response = detailsService.getAllStudentsDetails();
		 List<Details> list = mapping.tranformTo(response);
		 return new ResponseEntity<>(list, HttpStatus.OK); 
	}
	
	//HttpServletRequest request,
		@GetMapping("/getDetailsByRollNumber")
		public ResponseEntity<List<Details> > getDetailsByRollNumber(
				@RequestParam(required = false)List<Integer> rollNumber) 
		{
			List<Details> list = detailsService.getDetailsByRollNumber(rollNumber);
			return new ResponseEntity<>(list, HttpStatus.OK); 
		}
}

