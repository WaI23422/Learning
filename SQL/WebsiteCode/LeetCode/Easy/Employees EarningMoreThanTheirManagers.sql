-- Write a solution to find the employees who earn more than their managers.
-- Return the result table in any order.
-- The result format is in the following example.

-- CREATE TABLE Employee(
--     id INT PRIMARY KEY UNIQUE AUTO_INCREMENT,
--     name VARCHAR,
--     salary INT,
--     manageID INT
-- );

-- INSERT INTO Employee(name,salary,manageID)
-- VALUES ('Joe',70000,3),
--        ('Henry',80000,4),
--        ('Sam',60000,NULL),
--        ('Max',90000,NULL);

-- 339 ms 0B
SELECT e.name as Employee
FROM Employee e
INNER JOIN Employee m
ON e.managerId = m.id
WHERE e.salary > m.salary;