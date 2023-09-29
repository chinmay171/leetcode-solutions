WITH cte AS(
SELECT * FROM trips
WHERE client_id NOT IN(
        SELECT users_id FROM users
        WHERE banned = 'Yes')
  AND driver_id NOT IN(
        SELECT users_id FROM users
        WHERE banned = 'Yes')
        )

SELECT request_at AS Day, 
ROUND(SUM(CASE WHEN status = 'completed'
         THEN 0
         ELSE 1
    END) / COUNT(*), 2) 
    AS 'Cancellation Rate'
FROM cte
GROUP BY request_at
HAVING request_at BETWEEN '2013-10-01' AND '2013-10-03';