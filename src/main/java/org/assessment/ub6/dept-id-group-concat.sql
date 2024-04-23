SELECT dept_id,
GROUP_CONCAT ( DISTINCT emp_id ORDER BY emp_id  SEPARATOR', ') as "employees ids"
FROM employee
GROUP BY dept_id;