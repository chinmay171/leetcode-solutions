SELECT employee_id, department_id
FROM employee
WHERE ((employee_id, 1) IN (
        SELECT employee_id, COUNT(employee_id) AS cnt
        FROM employee
        GROUP BY employee_id)) OR
      (primary_flag = 'Y');
