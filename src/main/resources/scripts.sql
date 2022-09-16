select *
from student
where age between 23 and 26;

select student.name
from student;



select *
from student
where name like '%o%';

select *
from student
where age < student.id;

select *
from student
order by age;


SELECT count (name) as count FROM student;


SELECT avg (age) as avg FROM student;

SELECT count(id) as id
From student;




SELECT * from student order by id desc limit 5;




