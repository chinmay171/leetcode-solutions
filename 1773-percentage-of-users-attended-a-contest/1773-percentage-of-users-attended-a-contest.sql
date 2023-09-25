WITH t AS(
  SELECT COUNT(user_id) AS totalCnt
  FROM users
)

SELECT c.contest_id,
ROUND((COUNT(c.user_id) / t.totalCnt) * 100, 2)
AS percentage
FROM register c JOIN t
GROUP BY c.contest_id 
ORDER BY percentage DESC, c.contest_id ASC;