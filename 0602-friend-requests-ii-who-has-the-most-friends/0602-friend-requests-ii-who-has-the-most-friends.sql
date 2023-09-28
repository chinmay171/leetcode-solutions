# 1 - 2, 3
# 2 - 1, 3
# 3 - 1, 2, 4
# 4 - 3

SELECT a.ids AS id, COUNT(a.ids) AS num FROM(
    SELECT requester_id AS ids FROM RequestAccepted
    UNION ALL
    SELECT accepter_id FROM RequestAccepted) a
GROUP BY ids
ORDER BY num DESC LIMIT 1;