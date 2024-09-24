DELIMITER $
CREATE TRIGGER trg_audit_employees_insert AFTER INSERT ON employees
FOR EACH ROW
BEGIN
INSERT INTO audit_employees (
	employees_id,
	name,
	salary,
	birthday,
	operation
) VALUES (
	NEW.id,
	NEW.name,
	NEW.salary,
	NEW.birthday,
	'I'
);
END $