WITH cte AS(
SELECT *,
ROW_NUMBER() OVER(PARTITION BY stock_name) AS row_num ,
SUM(CASE WHEN operation = 'buy'
         THEN -price
         ELSE price
    END) OVER(PARTITION BY stock_name
            ORDER BY operation_day ) AS rnk
FROM stocks
)

SELECT stock_name, rnk AS capital_gain_loss FROM cte
WHERE (stock_name, operation_day) IN (
        SELECT stock_name, MAX(operation_day) AS operation_day
        FROM cte
        GROUP BY stock_name);