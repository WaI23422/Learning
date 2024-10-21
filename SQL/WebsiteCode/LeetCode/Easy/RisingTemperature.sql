-- Write a solution to find all dates' Id with higher temperatures compared to its previous dates (yesterday).
-- Return the result table in any order.
-- The result format is in the following example.

-- CREATE TABLE Weather(
--     id INT PRIMARY KEY UNIQUE AUTO_INCREMENT,
--     recordDate DATE,
--     temperature INT
-- );
-- INSERT INTO Weather(recordDate,temperature) 
-- VALUES (2015-01-01,10),
--        (2015-01-02,25),
--        (2015-01-03,20),
--        (2015-01-04,30);

-- Simple Join: 313ms
SELECT W1.id
FROM Weather W1
JOIN Weather W2
ON W1.recordDate = DATE_ADD(W2.recordDate, INTERVAL 1 DAY)
WHERE W1.temperature > W2.temperature;

--  Subquery: 1940ms
SELECT id
FROM Weather w1
WHERE temperature > (
    SELECT temperature
    FROM Weather w2
    WHERE w2.recordDate = DATE_SUB(w1.recordDate, INTERVAL 1 DAY)
);

-- DateOff Simple: 401ms
SELECT w1.id
FROM Weather w1, Weather w2
WHERE DATEDIFF(w1.recordDate, w2.recordDate) = 1
AND w1.temperature > w2.temperature;

-- CTE+LAG: 345ms
WITH q1 AS (
    SELECT 
        *,
        LAG(temperature) OVER (ORDER BY recordDate) AS previous_day_temperature,
        LAG(recordDate) OVER (ORDER BY recordDate) AS previous_Date
    FROM Weather
)

-- Select the IDs where the temperature is higher than the previous day
-- and the previous day exists (difference is exactly 1 day)
SELECT id
FROM q1
WHERE temperature > previous_day_temperature
AND DATEDIFF(recordDate, previous_Date) = 1;