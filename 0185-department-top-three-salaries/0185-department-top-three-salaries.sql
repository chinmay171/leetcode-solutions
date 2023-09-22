SELECT t.d_name AS Department
	,t.e_name AS Employee
	,t.Salary
FROM (
	SELECT e.name AS e_name
		,e.salary
		,d.Name AS d_name
		,DENSE_RANK() OVER (
			PARTITION BY departmentid ORDER BY salary DESC
			) AS row_num
	FROM employee AS e
	INNER JOIN department AS d ON e.departmentid = d.id
	) t
WHERE row_num <= 3