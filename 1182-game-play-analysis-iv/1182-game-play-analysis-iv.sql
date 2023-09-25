# Write your MySQL query statement below
# Write your MySQL query statement below
# COUNT ALL DISTINCT PLAYERS
# COUNT PLAYER WHO LOGGED IN ON TWO CONSECUTIVE DAYS
# ROUND(2ND QUERY / 1ST QUERY, 2)

SELECT ROUND(COUNT(player_id) /
 (SELECT COUNT(DISTINCT player_id) FROM Activity), 2) AS fraction
FROM Activity
WHERE (player_id, DATE_SUB(event_date, INTERVAL 1 DAY)) IN (
SELECT player_id, MIN(event_date) FROM Activity GROUP BY player_id);










# SELECT ROUND(f.req_count / f.total_unq, 2) AS fraction
# FROM(
#     SELECT COUNT(DISTINCT player_id) AS total_unq, req_count
#      FROM Activity a 
#      JOIN (
# SELECT COUNT(DISTINCT a.player_id) AS total,
# COUNT(DISTINCT b.player_id) AS req,
# MOD(COUNT(DISTINCT a.player_id) / COUNT(DISTINCT b.player_id),2) AS ans

# FROM Activity a

# JOIN ( SELECT b1.player_id,
#        DATE_SUB(event_date, INTERVAL 1 DAY) AS mod_date
#        FROM Activity b1 ) b

# ON b.mod_date = a.event_date
# AND b.player_id = a.player_id