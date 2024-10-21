-- Write a solution to find all customers who never order anything.
-- Return the result table in any order.
-- The result format is in the following example.

-- CREATE TABLE Customers (
--     id INT PRIMARY KEY UNIQUE AUTO_INCREMENT,
--     name VARCHAR  
-- );
-- INSERT INTO Customers (name) 
-- VALUES ('JOE'),
--        ('HENRY'),
--        ('SAM'),
--        ('MAX');

-- CREATE TABLE Orders(
--     id INT PRIMARY KEY UNIQUE AUTO_INCREMENT,
--     customerId INT FOREIGN KEY REFERENCES Customers(id) 
-- );

-- INSERT INTO Orders (customerId) 
-- VALUES (3),
--        (1);

-- 496 ms
SELECT cus.name AS Customers
FROM customers cus
LEFT JOIN orders ord ON cus.id = ord.customerId
WHERE ord.customerId IS NULL;

-- 496 ms
SELECT name AS Customers
FROM customers
LEFT JOIN orders ON customers.id = orders.customerId
WHERE orders.customerId IS NULL;

-- 495   ms
SELECT Name as Customers
FROM Customers
WHERE Id NOT IN(
    SELECT CustomerId
    FROM Orders
);

-- 483   ms
select c.name as Customers
from customers as c
where c.id NOT IN (select customerId from orders);