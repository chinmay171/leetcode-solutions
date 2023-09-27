SELECT DISTINCT num AS ConsecutiveNums FROM (
     SELECT num,
     LEAD(num, 1) OVER() AS next_num,
     LEAD(num, 2) OVER() AS 2ndNext_num
     FROM logs) temp
WHERE temp.num = temp.next_num
AND temp.num = temp.2ndNext_num;