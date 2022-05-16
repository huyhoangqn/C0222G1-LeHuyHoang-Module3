create database QuanLySinhVien;
USE QuanLySinhVien;
CREATE TABLE class (
    classId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    className VARCHAR(50) NOT NULL,
    startDate DATETIME NOT NULL,
    `status` BIT
);

CREATE TABLE student (
    studentId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    studentName VARCHAR(50) NOT NULL,
    address VARCHAR(50) NOT NULL,
    phone VARCHAR(20),
    `status` BIT,
    classId INT NOT NULL,
    FOREIGN KEY (classId)
        REFERENCES class (classId)
);

CREATE TABLE `subject` (
    subId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    subName VARCHAR(20) NOT NULL,
    credit VARCHAR(20) NOT NULL,
    `status` BIT
);

CREATE TABLE mark (
    markId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    subId INT NOT NULL,
    studentId INT NOT NULL,
    mark INT NOT NULL,
    examTime INT NOT NULL,
    FOREIGN KEY (subId)
        REFERENCES `subject` (subId),
    FOREIGN KEY (studentId)
        REFERENCES student (studentId)
);

INSERT INTO class
VALUES (1, 'A1', '2008-12-20', 1);
INSERT INTO class
VALUES (2, 'A2', '2008-12-22', 1);
INSERT INTO class
VALUES (3, 'B3', current_date, 0);

INSERT INTO student (studentName, address, phone, `status`, classId)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO student (studentName, address, `status`, classId)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO student (studentName, address, phone, `status`, classId)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);

INSERT INTO `subject`
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
   INSERT INTO Mark (subId, studentId, mark, examTime)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);


SELECT 
    *
FROM
    student;
SELECT 
    *
FROM
    student
WHERE
    `status` = 1;
SELECT 
    *
FROM
    `subject`
WHERE
    credit < 10;
SELECT 
    s.studentId, s.studentName, c.className
FROM
    student s
        INNER JOIN
    class c ON s.classId = c.classId
WHERE
    c.className = 'A1';

SELECT 
    s.studentId, s.studentName, m.mark, sub.subName
FROM
    student s
        INNER JOIN
    mark m ON m.studentId = s.studentId
        INNER JOIN
    `subject` sub ON m.subId = sub.subId
WHERE
    sub.subName = 'CF';

select * from student s where s.studentName regexp '^H';
select * from class c WHERE month(c.startDate) IN(12);
select* from `subject` sub where sub.credit between 3 and 5;

update student 
set classId = 2 where studentName = 'Hung';

select s.studentName, sub.subName, m.mark
from student s inner join mark m on s.studentId = m.studentId
inner join `subject` sub on sub.subId = m.subId 
order by m.mark desc, s.studentName asc;


