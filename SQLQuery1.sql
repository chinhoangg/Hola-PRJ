CREATE DATABASE testDb
USE testDb
CREATE TABLE Student (
   id   INT    NOT NULL identity(1,1),
   name NVARCHAR (32)     NOT NULL,
   gender BIT	  NOT NULL,
   dob  DATE NOT NULL,
   PRIMARY KEY (id)
);
GO
SET IDENTITY_INSERT Student OFF
GO
INSERT INTO student(name, gender, dob) VALUES (N'Nguyễn Văn Công', 1, '1981-04-18');
INSERT INTO student(name, gender, dob) VALUES (N'Đào Thị Dung', 0, '1990-05-20');
INSERT INTO student(name, gender, dob) VALUES (N'Hoàng Đức Ngôn', 1, '2000-06-05');
INSERT INTO student(name, gender, dob) VALUES (N'Ngô Mỹ Hạnh', 0, '2002-01-01');
GO

