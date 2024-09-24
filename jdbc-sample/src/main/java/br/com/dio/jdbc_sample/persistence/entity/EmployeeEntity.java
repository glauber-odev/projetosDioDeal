package br.com.dio.jdbc_sample.persistence.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import lombok.Data;

@Data
public class EmployeeEntity {

	private Long id;
	
	private String name;
	
	private BigDecimal salary;
	
	private OffsetDateTime birthday;
	
	private List<ContactEntity> contacts;
	
	private List<ModuleEntity> modules;
	
}
