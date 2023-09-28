# copied from discussions
SELECT a.visited_on as visited_on,
SUM(b.day_sum) AS amount,
ROUND(SUM(b.day_sum)/7,2) AS average_amount

FROM (SELECT visited_on, SUM(amount) as day_sum FROM Customer GROUP BY visited_on) as a,
(SELECT visited_on, SUM(amount) as day_sum FROM Customer GROUP BY visited_on) as b

WHERE DATEDIFF(a.visited_on , b.visited_on) BETWEEN 0 AND 6
GROUP BY a.visited_on
HAVING a.visited_on >= (SELECT MIN(visited_on) FROM Customer) + 6
ORDER BY a.visited_on

# done by me
# Working on 13 testcases out of 15
# WITH 
# cte2 AS(
#   SELECT customer_id, name, visited_on,
#   SUM(amount) as amount
#   FROM customer
#   GROUP BY visited_on
#   ORDER BY visited_on ASC
# ),
# cte AS(
#   SELECT DISTINCT(c2.visited_on) AS pre,
#       c1.visited_on AS post,
#       RANK() OVER(ORDER BY c1.visited_on) AS rnk
#       FROM cte2 c1 JOIN customer c2
#       ON DATEDIFF(c1.visited_on, c2.visited_on) = 6
#       ORDER BY c1.visited_on
# )

# SELECT DISTINCT(ct.post) AS visited_on,
# SUM(c1.amount) OVER(PARTITION BY ct.rnk) AS amount,
# ROUND(SUM(c1.amount) OVER(PARTITION BY ct.rnk) / 7, 2) AS average_amount
# FROM cte2 c1 JOIN cte ct
# ON c1.visited_on BETWEEN ct.pre AND ct.post
# ORDER BY ct.post;