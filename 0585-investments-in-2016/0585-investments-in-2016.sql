# Write your MySQL query statement below
# Select where tiv_2015 are same with anyone
# SELECT tiv_2015 FROM Insurance
# GROUP BY tiv_2015
# HAVING COUNT(tiv_2015) > 1;
# Select where lat and lon are not same with any one 
# SELECT CONCAT(lat, lon) FROM Insurance
# GROUP BY lat, lon
# HAVING COUNT(CONCAT(lat, lon)) > 1;
# sum of tiv_16 from above two

SELECT ROUND(SUM(tiv_2016), 2) AS tiv_2016 FROM Insurance
WHERE tiv_2015 IN (SELECT tiv_2015 FROM Insurance
                   GROUP BY tiv_2015
                   HAVING COUNT(tiv_2015) > 1) AND
      CONCAT(lat, lon) NOT IN(
                   SELECT CONCAT(lat, lon) FROM Insurance
                   GROUP BY lat, lon
                   HAVING COUNT(CONCAT(lat, lon)) > 1
      );