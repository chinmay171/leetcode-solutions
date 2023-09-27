WITH cte AS (
      SELECT product_id, MAX(change_date) AS updatedDate
      FROM products
      WHERE change_date <= '2019-08-16'
      GROUP BY product_id
      )

SELECT p.product_id, p.new_price AS price
FROM products p JOIN cte c
ON p.product_id = c.product_id
AND p.change_date = c.updatedDate
UNION
SELECT product_id, 10
FROM products
WHERE product_id NOT IN(SELECT product_id FROM cte);

# SELECT product_id, 
# CASE WHEN product_id IN (SELECT product_id FROM cte)
#           AND change_date IN(SELECT updatedDate FROM cte)
#      THEN new_price
#      WHEN DATEDIFF(change_date, '2019-08-16') > 0
#      THEN 10
# END AS price
# FROM products
# GROUP BY product_id;