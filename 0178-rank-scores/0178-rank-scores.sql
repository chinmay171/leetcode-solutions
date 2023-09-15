# Write your MySQL query statement below
# SELECT s.Score AS Score,
# DENSE_RANK() OVER (ORDER BY s.Score DESC) as Rank
# FROM Scores s

SELECT Score,
dense_rank() OVER(ORDER BY score DESC) as "rank"
FROM Scores;