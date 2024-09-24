DELIMITER $
CREATE TRIGGER trg_audit_employees_delete BEFORE DELETE ON employees
FOR EACH ROW
BEGIN
INSERT INTO audit_employees (
	employees_id,
	name,
	salary,
	birthday,
	operation
) VALUES (	
	OLD.id,
	OLD.name,
	OLD.salary,
	OLD.birthday,
	'D'
);
END $