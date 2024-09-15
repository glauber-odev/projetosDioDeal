package br.com.dio.new_maven_project;

import java.time.LocalDate;

import org.mapstruct.factory.Mappers;

import br.com.dio.new_maven_project.dto.UserDTO;
import br.com.dio.new_maven_project.mapper.UserMapper;
import br.com.dio.new_maven_project.model.UserModel;



public class App {
	
    private static final UserMapper mapper = Mappers.getMapper(UserMapper.class);
	
    public static void main(String[] args) {    	
            
        UserModel user = new UserModel();
        user.setUserName("José da Silva");
        user.setCode(1234);
        user.setBirthday(LocalDate.now().minusYears(26));
//        System.out.println("O valor da instância do username :\n");
//        System.out.println(user.toString());
        //inverte o valor dos objetos mapeados
        System.out.println(mapper.toDto(user));
        
        UserDTO dto = new UserDTO();
        dto.setId(25);
        dto.setName("Maria");
        dto.setBirthday(LocalDate.now().minusYears(30));
//        System.out.println("O valor da instância dto :\n");
//        System.out.println(dto.toString());
        System.out.println(mapper.toModel(dto));
        
    }
}
