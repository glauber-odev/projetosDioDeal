package br.com.dio.example_gradle_kt.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserModel {

	private int code;
	private String userName;
	private LocalDate birthday;
	
}
