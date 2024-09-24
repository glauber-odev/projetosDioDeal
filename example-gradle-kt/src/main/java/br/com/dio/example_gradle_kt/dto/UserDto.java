package br.com.dio.example_gradle_kt.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserDto {

	private int id;
	private String name;
	private LocalDate birthday;
	
}
