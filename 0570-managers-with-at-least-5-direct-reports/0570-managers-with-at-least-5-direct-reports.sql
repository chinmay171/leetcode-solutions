SELECT f.name FROM(
    SELECT e1.name, count(*) AS cnt
    FROM employee e1 JOIN employee e2
    WHERE e1.id = e2.managerId
    GROUP BY e1.id) f
WHERE f.cnt >= 5;