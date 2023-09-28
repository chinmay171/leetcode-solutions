(SELECT u.name AS results
FROM users u JOIN (
      SELECT user_id, COUNT(user_id) AS count
      FROM movierating
      GROUP BY user_id) m
ON u.user_id = m.user_id
ORDER BY m.count DESC, u.name ASC LIMIT 1)

UNION ALL
 
(SELECT mv.title AS results
FROM movies mv JOIN (
      SELECT movie_id, AVG(rating) AS avg_rating
      FROM movierating
      WHERE created_at LIKE "2020-02%"
      GROUP BY movie_id) m
ON mv.movie_id = m.movie_id
ORDER BY avg_rating DESC, mv.title ASC LIMIT 1);