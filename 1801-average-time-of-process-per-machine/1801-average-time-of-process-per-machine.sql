SELECT a1.machine_id, ROUND(AVG(a1.timestamp - a2.timestamp), 3)
AS processing_time
FROM activity a1 JOIN activity a2
ON a1.machine_id = a2.machine_id AND
   a1.process_id = a2.process_id AND
   a1.activity_type != a2.activity_type
WHERE a1.activity_type = 'end'
GROUP BY a1.machine_id;