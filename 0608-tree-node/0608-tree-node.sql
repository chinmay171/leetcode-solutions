# SELECT id
# FROM Tree
# WHERE id IN (SELECT p_id FROM Tree); 

SELECT id, 
CASE WHEN p_id IS NULL
     THEN 'Root'
     WHEN (id IN (SELECT p_id FROM Tree))
     THEN 'Inner'
     ELSE 'Leaf'
END AS type
FROM Tree;