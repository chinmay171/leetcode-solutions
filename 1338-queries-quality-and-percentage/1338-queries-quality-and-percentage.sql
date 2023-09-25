SELECT query_name,

ROUND(SUM(rating / position) / (
  SELECT COUNT(*)
  FROM Queries
  GROUP BY query_name
  HAVING query_name = q.query_name
), 2) AS quality,

CASE WHEN (SELECT COUNT(*)
            FROM Queries
            WHERE rating < 3
            GROUP BY query_name
            HAVING query_name = q.query_name) IS NULL
     THEN 0
     ELSE
      ROUND((SELECT COUNT(*)
      FROM Queries
      WHERE rating < 3
      GROUP BY query_name
      HAVING query_name = q.query_name) / (
              SELECT COUNT(*)
              FROM Queries
              GROUP BY query_name
              HAVING query_name = q.query_name
            ) * 100, 2)
END AS poor_query_percentage

FROM queries q
GROUP BY query_name;