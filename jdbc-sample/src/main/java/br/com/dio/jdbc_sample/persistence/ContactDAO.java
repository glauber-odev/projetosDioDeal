package br.com.dio.jdbc_sample.persistence;

import java.math.BigDecimal;
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

public class ContactDAO {
	
	public void insert(final ContactEntity contact) {
		
		try(
				var connection = ConnectionUtil.getConnection();
				var statement = connection.prepareStatement(
						"INSERT INTO contacts (description, type, employee_id) VALUES ( ?, ?, ?);"
						);
		){
						
			statement.setString(1, contact.getDescription());
			statement.setString(2, contact.getType());
			statement.setBigDecimal(3, new BigDecimal(contact.getEmployee().getId()));
			statement.executeUpdate();
			
			System.out.printf("Foram adicionados %s registros.", statement.getUpdateCount());
			//testa se é uma conexão sql, e joga o id do ulitmo indice inserido no banco de dados
			if(statement instanceof StatementImpl impl)
				contact.setId(impl.getLastInsertID());
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
	
	public List<ContactEntity> findAll(){
		
		List<ContactEntity> entities = new ArrayList<ContactEntity>();
		
		try(
				var connection = ConnectionUtil.getConnection();
				var statement = connection.createStatement();				
		){
			
			var query = "SELECT * FROM contacts;";
			statement.executeQuery(query);
			var resultset = statement.getResultSet();
			while(resultset.next()) {
				var entity = new ContactEntity();			
				entity.setId(resultset.getLong("id"));
				entity.setDescription(resultset.getString("description"));
				entity.setType(resultset.getString("type"));
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
				var statement = connection.createStatement();				
		){
			
			statement.executeQuery("SELECT * FROM employees WHERE id = "+id);
			var resultset = statement.getResultSet();
			
			if(resultset.next()) {
			entity.setId(resultset.getLong("id"));
			entity.setName(resultset.getString("name"));
			entity.setSalary(resultset.getBigDecimal("salary"));
			var birthdayinstant = resultset.getTimestamp("birthday").toInstant();
			entity.setBirthday(OffsetDateTime.ofInstant(birthdayinstant, ZoneOffset.UTC ));
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
	
	public List<ContactEntity> findByIdEmployee(final Long id){
		
		List<ContactEntity> entities = new ArrayList<ContactEntity>();
		
		try(
				var connection = ConnectionUtil.getConnection();
				var statement = connection.prepareStatement("SELECT * FROM contacts WHERE employee_id = ?;");
		){					
			statement.setLong(1, id);
			statement.executeQuery();
			var resultset = statement.getResultSet();
			ContactEntity entity = new ContactEntity();
			while(resultset.next()) {
				entity.setId(resultset.getLong("id"));
				entity.setDescription(resultset.getString("description"));
				entity.setType(resultset.getString("type"));
				entity.setEmployee(new EmployeeEntity());
				entity.getEmployee().setId(resultset.getLong("employee_id"));
				entities.add(entity);				
			}
			
		} catch(SQLException ex) {	
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
		return entities;
	}

}