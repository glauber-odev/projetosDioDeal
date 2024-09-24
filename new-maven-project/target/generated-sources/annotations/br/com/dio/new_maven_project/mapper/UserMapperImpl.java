package br.com.dio.new_maven_project.mapper;

import br.com.dio.new_maven_project.dto.UserDTO;
import br.com.dio.new_maven_project.model.UserModel;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-15T09:38:59-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserModel toModel(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setCode( dto.getId() );
        userModel.setUserName( dto.getName() );
        userModel.setBirthday( dto.getBirthday() );

        return userModel;
    }

    @Override
    public UserDTO toDto(UserModel user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getCode() );
        userDTO.setName( user.getUserName() );
        userDTO.setBirthday( user.getBirthday() );

        return userDTO;
    }
}
