CREATE TABLE accesses (
	employee_id BIGINT,
	module_id BIGINT,
	PRIMARY KEY(employee_id, module_id),
	CONSTRAINT fk_accesses_employees FOREIGN KEY (employee_id) REFERENCES employees(id),
	CONSTRAINT fk_accesses_employees_modules FOREIGN KEY (module_id) REFERENCES employees_modules(id)
)engine=InnoDB default charset=utf8;