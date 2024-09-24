package br.com.dio.jdbc_sample.persistence.entity;

import lombok.Data;

@Data
public class ContactEntity {

	private Long id;
	
	private String description;
	
	private String type;
	
	private EmployeeEntity employee;
	
}
