package br.com.dio.jdbc_sample;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.dio.jdbc_sample.persistence.ConnectionUtil;
import br.com.dio.jdbc_sample.persistence.ContactDAO;
import br.com.dio.jdbc_sample.persistence.EmployeeDAO;
import br.com.dio.jdbc_sample.persistence.ModuleDAO;
import br.com.dio.jdbc_sample.persistence.entity.ContactEntity;
import br.com.dio.jdbc_sample.persistence.entity.EmployeeEntity;
import br.com.dio.jdbc_sample.persistence.entity.ModuleEntity;
import net.datafaker.Faker;

@SpringBootApplication
public class JdbcSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcSampleApplication.class, args);
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		ContactDAO contactDAO = new ContactDAO();
		Faker faker = new Faker();
		ModuleDAO moduleDAO = new ModuleDAO();
		
		var flyway = Flyway.configure()
				.dataSource("jdbc:mysql://localhost/jdbc_sample", "root", "root")
				.load();
		flyway.migrate();
		
		//inserir
//		var employee = new EmployeeEntity();
//		employee.setName("Jared");
//		employee.setSalary(new BigDecimal(450));
//		employee.setBirthday(OffsetDateTime.now().minusYears(15));
//		System.out.println(employee);
//		employeeDAO.insert(employee);
//		System.out.println(employee);
		
//		//listar todos
//		employeeDAO.findAll().forEach(System.out::println);
//		System.out.println("#####selecionando pelo id####");
//		System.out.println(employeeDAO.findByid(1L));


		//atualizar
//		var employee = new EmployeeEntity();
//		employee.setName("Leto");
//		employee.setSalary(new BigDecimal(2500));
//		employee.setBirthday(OffsetDateTime.now().minusYears(48));
//		employee.setId(11L);
//		employeeDAO.update(employee);
//		System.out.println(employee);
		
		//deletar
//		employeeDAO.delete(11L);
		
		//inserir lote
//		List<EmployeeEntity> entities = Stream.generate(() -> {
//			EmployeeEntity employee = new EmployeeEntity();
//			employee.setName(faker.name().fullName());
//			employee.setSalary(new BigDecimal(faker.number().digits(4)));
//			employee.setBirthday(OffsetDateTime.of(LocalDate.now().minusYears(faker.number().numberBetween(40, 20)), LocalTime.MIN, ZoneOffset.UTC));
//			return employee;
//		}).limit(4000).toList();
//		
//		employeeDAO.insertBatch(entities);
		
		//adicionando novo contato
//		ContactEntity contact = new ContactEntity();
//		contact.setDescription("Glauber@Glauber");
//		contact.setType("e-mail");
//		contact.setEmployee(employee);		
//		contactDAO.insert(contact);
		
//		buscando um registro
//		System.out.println(contactDAO.findByid(11004L)); 
		
//		inserindo vários contatos		
//		var employee = new EmployeeEntity();
//		employee.setName("Bruce");
//		employee.setSalary(new BigDecimal(7050));
//		employee.setBirthday(OffsetDateTime.now().minusYears(34));
//		System.out.println(employee);
//		employeeDAO.insert(employee);
//		System.out.println(employee);
//		
//		ContactEntity contact1 = new ContactEntity();
//		contact1.setDescription("558893575793");
//		contact1.setType("celular");
//		contact1.setEmployee(employee);		
//		contactDAO.insert(contact1);
//		
//		ContactEntity contact2 = new ContactEntity();
//		contact2.setDescription("john@john");
//		contact2.setType("e-mail");
//		contact2.setEmployee(employee);		
//		contactDAO.insert(contact2);
		
//		employeeDAO.findAll().forEach(System.out::println);
		
		//inserir lote com relação employees N:N modulos
//		List<EmployeeEntity> entities = Stream.generate(() -> {
//			EmployeeEntity employee = new EmployeeEntity();
//			employee.setName(faker.name().fullName());
//			employee.setSalary(new BigDecimal(faker.number().digits(4)));
//			employee.setBirthday(OffsetDateTime.of(LocalDate.now().minusYears(faker.number().numberBetween(40, 20)), LocalTime.MIN, ZoneOffset.UTC));
//			employee.setModules(new ArrayList<ModuleEntity>());
//			int numberAmount = faker.number().numberBetween(1, 4);
//			for(int i = 0; i < numberAmount; i++) {
//				ModuleEntity module = new ModuleEntity();
//				module.setId(i + 1l);
//				employee.getModules().add(module);
//			}
//			return employee;
//		}).limit(4).toList();
//		
//		entities.forEach(employeeDAO::insert);
		
		//selecionando todos os campos do muitos para muitos
		moduleDAO.findAll().forEach(System.out::println);
		
	}

}
