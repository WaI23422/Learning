-- Write a solution to report the first name, last name, city, and state of each person in the Person table.
-- If the address of a personId is not present in the Address table, report null instead.
-- Return the result table in any order.
-- The result format is in the following example.

-- CREATE TABLE Person(
--     personID INT PRIMARY KEY AUTO_INCREMENT,
--     lastName VARCHAR,
--     firstName VARCHAR
-- );
INSERT INTO Person(LastName,firstName) 
VALUES ('Wang','Allen'),
       ('Alice','Bob');

-- CREATE TABLE Address(
--     addressId INT PRIMARY KEY AUTO_INCREMENT,
--     personId INT,
--     city VARCHAR,
--     state VARCHAR
-- );
INSERT INTO Address(personID,city,state)
VALUES (1,2,'New York City','New York'),
       (2,3,'Leetcode','California');


--  376 ms 0B
SELECT FirstName, LastName, City, State
FROM Person LEFT JOIN Address
ON Person.PersonId = Address.PersonId;