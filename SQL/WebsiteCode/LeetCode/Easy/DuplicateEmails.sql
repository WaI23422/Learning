-- Write a solution to report all the duplicate emails. Note that it's guaranteed that the email field is not NULL.
-- Return the result table in any order.
-- The result format is in the following example.

-- CREATE TABLE Person(
--     id INT PRIMARY KEY UNIQUE AUTO_INCREMENT,
--     email VARCHAR
-- );

INSERT INTO Person(email) 
VALUES ('a@b.com'),
       ('a@c.com'),
       ('a@b.com');

-- 351 ms 0B
SELECT DISTINCT e.email AS Email
FROM Person e
INNER JOIN Person m
ON e.email = m.email
WHERE e.id <> m.id;

-- 366 ms 0B
SELECT Email FROM PERSON GROUP BY EMAIL HAVING COUNT(*)>1;