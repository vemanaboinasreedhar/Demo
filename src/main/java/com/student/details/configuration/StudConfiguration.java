package com.student.details.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@Configuration
@ConfigurationProperties(prefix = "com.student.details")
public class StudConfiguration {
	private String studenturl;

	public String getStudenturl() {
		return studenturl;
	}

	public void setStudenturl(String studenturl) {
		this.studenturl = studenturl;
	}

}
