SELECT MAX(num) AS num FROM mynumbers
WHERE num IN(
    SELECT num FROM mynumbers
    GROUP BY num
    HAVING COUNT(num) = 1
);