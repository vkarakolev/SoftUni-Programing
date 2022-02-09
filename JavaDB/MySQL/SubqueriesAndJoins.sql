#Ex.1
SELECT e.employee_id, CONCAT(e.first_name, ' ', e.last_name) AS full_name, d.department_id, d.name
FROM employees AS e
JOIN departments AS d ON e.employee_id = d.manager_id
ORDER BY e.employee_id
LIMIT 5;

#Ex.2
SELECT t.town_id, t.name, a.address_text FROM towns AS t
JOIN addresses AS a
USING (town_id)
WHERE t.name IN ('San Francisco', 'Sofia', 'Carnation')
ORDER BY town_id, address_id;

#Ex.3
SELECT employee_id, first_name, last_name, department_id, salary FROM employees
WHERE manager_id IS NULL;

#Ex.4
SELECT COUNT(*) FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);