CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
 RETURN (
        SELECT MAX(salary)
        FROM(
            SELECT salary
            ,DENSE_RANK() OVER (ORDER BY SALARY DESC) AS ranking
            FROM Employee
            ) A
        WHERE ranking = N
  );
END