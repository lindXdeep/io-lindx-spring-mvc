USE db_persons;

CREATE TABLE person(
    id BIGINT,
    name VARCHAR(256),
    age INT,
    email VARCHAR(256)
);

SHOW TABLES;

INSERT INTO person VALUES(1, 'Tom', 23, 'tom@gmail.com');
INSERT INTO person VALUES(2, 'Bom', 31, 'bom@gmail.com');
INSERT INTO person VALUES(3, 'john', 40, 'john@gmail.com');
INSERT INTO person VALUES(4, 'Bill', 35, 'bill@gmail.com');

SELECT * FROM person;

