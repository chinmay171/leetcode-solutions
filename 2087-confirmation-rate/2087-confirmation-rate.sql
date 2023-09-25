WITH 
total AS (SELECT user_id, COUNT(*) AS total_req
FROM confirmations c
GROUP BY user_id),

confirm AS(SELECT user_id, COUNT(*) AS confirm_req
FROM confirmations c
WHERE action = 'confirmed'
GROUP BY user_id)

SELECT s.user_id,
CASE WHEN ROUND(confirm_req / total_req, 2) IS NULL
     THEN 0.00
     ELSE ROUND(confirm_req / total_req, 2)
END AS confirmation_rate
FROM Signups s LEFT JOIN 
        (total t LEFT JOIN confirm c
        ON t.user_id = c.user_id)
     ON s.user_id = t.user_id;