-- Create database
CREATE DATABASE IF NOT EXISTS student_db;
USE student_db;

-- Create table
CREATE TABLE IF NOT EXISTS student (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    marks INT
);

-- Sample data
INSERT INTO student VALUES
(1, 'Rahul', 85);
