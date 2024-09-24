package br.com.dio.example_gradle_kt;

import java.time.LocalDate;

import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.dio.example_gradle_kt.dto.UserDto;
import br.com.dio.example_gradle_kt.mapper.UserMapper;
import br.com.dio.example_gradle_kt.model.UserModel;



@SpringBootApplication
public class ExampleGradleKtApplication {
	


	public static void main(String[] args) {
		SpringApplication.run(ExampleGradleKtApplication.class, args);
		
	    private static final UserMapper mapper = Mappers.getMapper(UserMapper.class);
		
	        UserModel user = new UserModel();
	        user.setUserName("José da Silva");
	        user.setCode(1234);
	        user.setBirthday(LocalDate.now().minusYears(26));
//	        System.out.println("O valor da instância do username :\n");
//	        System.out.println(user.toString());
	        //inverte o valor dos objetos mapeados
	        System.out.println(mapper.toDto(user));
	        
	        UserDto dto = new UserDto();
	        dto.setId(25);
	        dto.setName("Maria");
	        dto.setBirthday(LocalDate.now().minusYears(30));
//	        System.out.println("O valor da instância dto :\n");
//	        System.out.println(dto.toString());
	        System.out.println(mapper.toModel(dto));
	}

}
