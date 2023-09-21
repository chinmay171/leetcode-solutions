# Write your MySQL query statement below
# SELECT a.customer_id FROM(

SELECT customer_id
FROM Customer
GROUP BY customer_id
HAVING COUNT(DISTINCT product_key)
       = (SELECT COUNT(*) FROM Product);

# ) a
# WHERE a.freq = (SELECT COUNT(*) FROM Product);