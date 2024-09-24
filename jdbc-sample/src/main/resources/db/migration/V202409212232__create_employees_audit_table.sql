CREATE TABLE audit_employees(

	id BIGINT NOT NULL AUTO_INCREMENT,
	name VARCHAR(150) NOT NULL,
	old_name VARCHAR(150) NOT NULL,
	salary DECIMAL(10,2) NOT NULL,
	old_salary DECIMAL(10,2) NOT NULL,
	birthday TIMESTAMP NOT NULL,
	old_birthday TIMESTAMP NOT NULL,
	operation CHAR(1),
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id)
	
)engine=InnoDB default charset=utf8;