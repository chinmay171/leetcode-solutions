SELECT u.user_id AS buyer_id, join_date, 
IF(f.orders_in_2019, f.orders_in_2019, 0) 
AS orders_in_2019
FROM users u LEFT JOIN (
        SELECT buyer_id, COUNT(*) AS orders_in_2019
        FROM Orders
        WHERE order_date LIKE "2019%"
        GROUP BY buyer_id) f
ON u.user_id = f.buyer_id;
