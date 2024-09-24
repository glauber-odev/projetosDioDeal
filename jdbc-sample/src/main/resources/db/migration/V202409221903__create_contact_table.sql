CREATE TABLE contacts (
	id BIGINT NOT NULL auto_increment,
	description VARCHAR(150) NOT NULL,
	type VARCHAR(30),
	employee_id BIGINT NOT NULL,
	PRIMARY KEY(id),
	CONSTRAINT fk_contacts_employees FOREIGN KEY (employee_id) REFERENCES employees(id)
);