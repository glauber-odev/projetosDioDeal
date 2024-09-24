package br.com.dio.jdbc_sample.persistence;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.StatementImpl;
import com.mysql.cj.protocol.x.XpluginStatementCommand;

import br.com.dio.jdbc_sample.persistence.entity.ContactEntity;
import br.com.dio.jdbc_sample.persistence.entity.EmployeeEntity;

public class AccessDAO {
	
	private static final ContactDAO contactDAO = new ContactDAO();
	
	public void insert(final Long employee_id, final Long module_id) {
		
		try(
			var connection = ConnectionUtil.getConnection();
			var statement = connection.prepareStatement("INSERT INTO accesses (employee_id, module_id) VALUES (?, ?);");
		){
			statement.setLong(1, employee_id);
			statement.setLong(2, module_id);
			statement.executeUpdate();

		} catch(SQLException ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
	}
	
	public void insertBatch(final List<EmployeeEntity> entities) {
		
		try(var connection = ConnectionUtil.getConnection();){
				String sql = "INSERT INTO employees (name, salary, birthday) VALUES ( ?, ?, ?);";			
				try(var statement = connection.prepareStatement(sql)){					
					connection.setAutoCommit(false);
					for(EmployeeEntity entity : entities) {
						statement.setString(	1, entity.getName());
						statement.setBigDecimal(2, entity.getSalary());
						statement.setTimestamp(	3, 
								Timestamp.valueOf(entity.getBirthday().atZoneSimilarLocal(ZoneOffset.UTC).toLocalDateTime())
								);
						statement.addBatch();
					}
					statement.executeBatch();
					connection.commit();
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				};

		} catch(SQLException ex) {	
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
	}
	
	public void update(final EmployeeEntity entity) {		
		
		try(
				var connection = ConnectionUtil.getConnection();
				var statement = connection.createStatement();				
		){
			
			String query = "UPDATE employees SET "
					+"name = '"+entity.getName()+"', "
					+"salary = '"+entity.getSalary()+"', "
					+"birthday = '"+formatOffsetDateTime(entity.getBirthday())+"'"
					+ "WHERE id = '"+entity.getId()+"';";
			
			statement.executeUpdate(query);
			var resultset = statement.getResultSet();
			
//			if(resultset.next()) {
//			entity.setId(resultset.getLong("id"));
//			entity.setName(resultset.getString("name"));
//			entity.setSalary(resultset.getBigDecimal("salary"));
//			var birthdayinstant = resultset.getTimestamp("birthday").toInstant();
//			entity.setBirthday(OffsetDateTime.ofInstant(birthdayinstant, ZoneOffset.UTC ));
//			}

		} catch(SQLException ex) {	
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
		
	}
	
	public void delete(final Long id) {
		
		try(
				var connection = ConnectionUtil.getConnection();
				var statement = connection.createStatement();
				){
			
			statement.executeUpdate("DELETE FROM employees WHERE id = "+id);
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
	}
	
	public List<EmployeeEntity> findAll(){
		
		List<EmployeeEntity> entities = new ArrayList<EmployeeEntity>();
		
		try(
				var connection = ConnectionUtil.getConnection();
				var statement = connection.createStatement();				
		){
			
			var query = "SELECT * FROM employees;";
			statement.executeQuery(query);
			var resultset = statement.getResultSet();
			while(resultset.next()) {
				var entity = new EmployeeEntity();			
				entity.setId(resultset.getLong("id"));
				entity.setName(resultset.getString("name"));
				entity.setSalary(resultset.getBigDecimal("salary"));
				var birthdayinstant = resultset.getTimestamp("birthday").toInstant();
				entity.setBirthday(OffsetDateTime.ofInstant(birthdayinstant, ZoneOffset.UTC ));
				entity.setContacts(contactDAO.findByIdEmployee(resultset.getLong("id")));
				entities.add(entity);
			}
			

		} catch(SQLException ex) {	
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
		return entities;
	}
	
	public EmployeeEntity findByid(final Long id) {
		
		var entity = new EmployeeEntity();
		
		try(
				var connection = ConnectionUtil.getConnection();
				var statement = connection.prepareStatement("SELECT * FROM employees LEFT JOIN"
						+ " contacts ON employees.id = contacts.employee_id WHERE id = ?;");				
		){
			statement.setLong(1, id);
			statement.executeQuery();
			var resultset = statement.getResultSet();
			
			if(resultset.next()) {
				entity.setId(resultset.getLong("id"));
				entity.setName(resultset.getString("name"));
				entity.setSalary(resultset.getBigDecimal("salary"));
				var birthdayinstant = resultset.getTimestamp("birthday").toInstant();
				entity.setBirthday(OffsetDateTime.ofInstant(birthdayinstant, ZoneOffset.UTC ));
				entity.setContacts(new ArrayList<ContactEntity>());
				
				do {
					var contact = new ContactEntity();
					contact.setId(resultset.getLong("id"));
					contact.setDescription(resultset.getString("description"));
					contact.setType(resultset.getString("type"));
					entity.getContacts().add(contact);
				} while(resultset.next());
			}

		} catch(SQLException ex) {	
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
		return entity;
	}
	
	private String formatOffsetDateTime(final OffsetDateTime dateTime) {
		dateTime.withOffsetSameInstant(ZoneOffset.UTC);
		return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

}