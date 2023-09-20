# Write your MySQL query statement below
SELECT DISTINCT(l.num) AS ConsecutiveNums FROM(
    SELECT num,
    LEAD(num, 1) OVER() AS 1stNext,
    LEAD(num, 2) OVER() AS 2ndNext
    FROM Logs
    ) l
WHERE (l.num = l.1stNext) AND (l.num = l.2ndNext);

# THIS WILL FIRST JUST NEXT NUM FROM LOG
# AND THEN AGAIN CHECK THE NEXT NUM FROM
# THE NESTED TABLE FORMED IN FIRST STEP.
# 20 test cases passed out of 21 overall

# SELECT l2.nextnext_num AS ConsecutiveNums
# FROM (SELECT l1.num, l1.next_num,
#       LEAD(l1.next_num) OVER() AS nextnext_num
#       FROM (SELECT l.num, l.next_num FROM(
#               SELECT id, num,
#               LEAD(num) OVER() AS next_num
#               FROM Logs) l
#           WHERE l.num = l.next_num) l1) l2
# WHERE l2.nextnext_num = l2.next_num;