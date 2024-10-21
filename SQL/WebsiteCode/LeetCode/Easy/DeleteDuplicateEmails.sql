-- Write a solution to delete all duplicate emails, keeping only one unique email with the smallest id.
-- For SQL users, please note that you are supposed to write a DELETE statement and not a SELECT one.
-- For Pandas users, please note that you are supposed to modify Person in place.
-- After running your script, the answer shown is the Person table. 
-- The driver will first compile and run your piece of code and then show the Person table. The final order of the Person table does not matter.
-- The result format is in the following example.

-- CREATE TABLE Person(
--     id INT PRIMARY KEY UNIQUE AUTO_INCREMENT,
--     email VARCHAR
-- );
-- INSERT INTO Person(email) 
-- VALUES ('john@example.com '),
--        ('john@example.com '),
--        ('bob@example.com');

-- 909ms
DELETE a FROM Person a, Person b
WHERE a.email = b.email AND a.id > b.id;

-- 610ms
DELETE FROM Person
WHERE id NOT IN (
    SELECT id
    FROM (
        SELECT MIN(id) AS id
        FROM Person
        GROUP BY email
    ) AS tmp
);

-- 522ms
with cte as (select min(id) id, email from person group by email)
delete from person p where (id, email) not in (select * from cte)

-- 519ms
WITH CTE AS (
    SELECT 
        id, 
        email,
        ROW_NUMBER() OVER (
            PARTITION BY email 
            ORDER BY id
        ) AS row_num
    FROM Person
)
DELETE FROM Person
WHERE id IN (
    SELECT id
    FROM CTE
    WHERE row_num > 1
);