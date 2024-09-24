ALTER TABLE audit_employees MODIFY COLUMN old_name VARCHAR(150);
ALTER TABLE audit_employees MODIFY COLUMN old_salary DECIMAL(10,2);
ALTER TABLE audit_employees MODIFY COLUMN old_birthday TIMESTAMP;