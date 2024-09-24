package br.com.dio.jdbc_sample.persistence;

import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import br.com.dio.jdbc_sample.persistence.entity.ContactEntity;
import br.com.dio.jdbc_sample.persistence.entity.EmployeeEntity;
import br.com.dio.jdbc_sample.persistence.entity.ModuleEntity;

public class ModuleDAO {

	public List<ModuleEntity> findAll(){
		
		List<ModuleEntity> entities = new ArrayList<ModuleEntity>();

		try(
				var connection = ConnectionUtil.getConnection();
				var statement = connection.prepareStatement(
						"select "+
						"m.id module_id, "+
						"m.name module_name, "+
						"e.id employee_id, "+
						"e.name employee_name, "+
						"e.salary employee_salary, "+
						"e.birthday employee_birthday "+
						"from jdbc_sample.employees e "+
						"inner join jdbc_sample.accesses a "+
						"on e.id = a.employee_id "+
						"inner join jdbc_sample.employees_modules m "+
						"on m.id = a.module_id "+
						"order by m.id;");
		){					
			
	        var resultSet = statement.executeQuery();
	        long currentModuleId = -1;  // Para identificar mudança de módulo

	        while (resultSet.next()) {
	            long moduleId = resultSet.getLong("module_id");

	            // Verifica se estamos em um novo módulo. Se sim, cria mais um, senão adiciona mais um employee
	            if (currentModuleId != moduleId) {
	                // Adiciona novo módulo à lista
	                ModuleEntity module = new ModuleEntity();
	                module.setId(moduleId);
	                module.setName(resultSet.getString("module_name"));
	                module.setEmployees(new ArrayList<>());
	                entities.add(module);
	                currentModuleId = moduleId; // Atualiza o ID do módulo atual
	            }

	            // Adiciona o employee ao módulo atual
	            EmployeeEntity employee = new EmployeeEntity();
	            employee.setId(resultSet.getLong("employee_id"));
	            employee.setName(resultSet.getString("employee_name"));
	            employee.setSalary(resultSet.getBigDecimal("employee_salary"));
	            var birthdayInstant = resultSet.getTimestamp("employee_birthday").toInstant();
	            employee.setBirthday(OffsetDateTime.ofInstant(birthdayInstant, ZoneOffset.UTC));
	            
	            // Adiciona o funcionário ao ultimo módulo adicionado
	            var currentModule = entities.get(entities.size() - 1); // Obtém o último módulo que foi adicionado
	            currentModule.getEmployees().add(employee);
			}
			
		} catch(SQLException ex) {	
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
		return entities;
	}
	
}
