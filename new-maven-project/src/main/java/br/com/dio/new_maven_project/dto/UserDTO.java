package br.com.dio.new_maven_project.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class UserDTO {

	private int id;
	private String name;
	private LocalDate birthday;
	
}
