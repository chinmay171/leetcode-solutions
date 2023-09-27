SELECT 'Low Salary' AS category,
COUNT(account_id) AS accounts_count
FROM accounts
WHERE income < 20000

UNION

SELECT 'Average Salary' AS category,
COUNT(account_id) AS accounts_count
FROM accounts
WHERE income <= 50000 AND income >= 20000

UNION

SELECT 'High Salary' AS category,
COUNT(account_id) AS accounts_count
FROM accounts
WHERE income > 50000;