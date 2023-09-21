# Write your MySQL query statement below
SELECT a.customer_id FROM(
SELECT customer_id, COUNT(DISTINCT product_key) AS freq
FROM Customer
GROUP BY customer_id) a
WHERE a.freq = (SELECT COUNT(*) FROM Product);