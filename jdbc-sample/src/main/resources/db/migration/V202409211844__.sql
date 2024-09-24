CREATE TABLE employees(

	id BIGINT NOT NULL AUTO_INCREMENT,
	name VARCHAR(150) NOT NULL,
	salary DECIMAL(10,2) NOT NULL,
	birthday TIMESTAMP NOT NULL,
	PRIMARY KEY(id)
	
)engine=InnoDB default charset=utf8;