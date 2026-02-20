CREATE DATABASE IF NOT EXISTS skillnext2_db;
USE skillnext2_db;

CREATE TABLE IF NOT EXISTS student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    branch VARCHAR(100),
    email VARCHAR(100)
);

SELECT * FROM student;
