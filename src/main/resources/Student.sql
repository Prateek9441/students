DROP TABLE IF EXISTS Student;
DROP TABLE IF EXISTS Assignment;
DROP TABLE IF EXISTS Exam;
DROP TABLE IF EXISTS ExtraCredit;
 
CREATE TABLE Student (
  rollNumber INT PRIMARY KEY ,
  name VARCHAR(250) NOT NULL
);

CREATE TABLE Assignment (
  rollNumber INT ,
  name VARCHAR(250) PRIMARY KEY NOT NULL,
  marks INT
);

CREATE TABLE Exam (
  rollNumber INT ,
  name VARCHAR(250) PRIMARY KEY NOT NULL,
  marks INT
);

CREATE TABLE ExtraCredit (
  rollNumber INT ,
  name VARCHAR(250) PRIMARY KEY NOT NULL,
  marks INT
);
 