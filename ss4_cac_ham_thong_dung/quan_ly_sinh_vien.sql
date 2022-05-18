use quanlysinhvien;
select * from `subject`where credit = (select max(credit) from `subject`);
select s.subId, s.subName, m.mark from `subject` s join mark m on s.subId = m.subId where m.mark = (select max(mark) from mark);
select s.studentId, s.studentName, count(m.mark), avg(mark) from student s join mark m on s.studentId = m.studentId group by s.studentName order by avg(m.mark) desc;
