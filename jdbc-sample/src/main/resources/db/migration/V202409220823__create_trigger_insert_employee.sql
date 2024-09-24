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
	NOW.id,
	NOW.name,
	NOW.salary,
	NOW.birthday,
	'I'
);
END $