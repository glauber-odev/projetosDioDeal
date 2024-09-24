package br.com.dio.jdbc_sample.persistence.entity;

import java.util.List;

import lombok.Data;

@Data
public class ModuleEntity {
	
	private Long id;
	
	private String name;
	
	private List<EmployeeEntity> employees;

}
