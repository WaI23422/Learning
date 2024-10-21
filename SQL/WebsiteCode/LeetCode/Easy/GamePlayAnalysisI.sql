-- Write a solution to find the first login date for each player.
-- Return the result table in any order.
-- The result format is in the following example.

-- CREATE TABLE Activity(
--     player_id INT PRIMARY KEY,
--     device_id INT PRIMARY KEY,
--     event_date date,
--     games_played INT
-- );
-- INSERT INTO Activity 
-- VALUES (1,2,2016-03-01,5),
--        (1,2,2016-05-02,6),
--        (2,3,2017-06-25,1),
--        (3,1,2016-03-02,0),
--        (3,4,2018-07-03,5);

-- 496 ms 0B
SELECT  player_id,
        MIN(event_date) AS first_login
FROM Activity 
GROUP BY player_id;

-- 528 ms 0B
SELECT
    player_id,
    MIN(event_date) AS first_login
FROM Activity
GROUP BY 1
ORDER BY 1