package br.com.dio.example_gradle_kt.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.dio.example_gradle_kt.dto.UserDto;
import br.com.dio.example_gradle_kt.model.UserModel;

@Mapper
public interface UserMapper {
	
	@Mapping(target = "code", source = "id")
	@Mapping(target = "userName", source = "name")
	UserModel toModel(final UserDto dto);
		
	@Mapping(target = "id", source = "code")
	@Mapping(target = "name", source = "userName")
	UserDto toDto(final UserModel model);
}
