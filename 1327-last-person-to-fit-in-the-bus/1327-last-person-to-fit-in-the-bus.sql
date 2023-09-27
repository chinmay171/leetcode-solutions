WITH cte AS (
SELECT *,
LEAD(runSum) OVER() AS nextWeight
FROM(
  SELECT person_name,
  SUM(weight) OVER(ORDER BY turn) runSum
  FROM queue) temp
  )

SELECT person_name
FROM cte
WHERE runSum <= 1000
ORDER BY runSum DESC LIMIT 1;