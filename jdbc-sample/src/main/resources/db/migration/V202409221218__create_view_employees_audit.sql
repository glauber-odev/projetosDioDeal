CREATE VIEW view_employee_audit AS
SELECT 	employees_id,
		name,
		old_name,
		salary,
		old_salary,
		birthday,
		old_birthday,
		operation
FROM audit_employees
ORDER BY created_at;