package br.com.dio.new_maven_project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.dio.new_maven_project.dto.UserDTO;
import br.com.dio.new_maven_project.model.UserModel;



@Mapper
public interface UserMapper {

	@Mapping(target="code", source="id")
	@Mapping(target="userName", source="name")
	UserModel toModel(final UserDTO dto);
	
	@Mapping(target="id", source="code")
	@Mapping(target="name", source="userName")
	UserDTO toDto(final UserModel user);
}
