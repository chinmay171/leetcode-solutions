SELECT query_name,
ROUND(AVG(rating / position), 2) AS quality,
CASE WHEN SUM(q.rating < 3) IS NULL THEN 0
     ELSE ROUND(SUM(q.rating < 3) /
            COUNT(q.query_name) * 100, 2)
END AS poor_query_percentage

FROM queries q
GROUP BY query_name;