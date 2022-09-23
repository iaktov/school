select *
from student
where age between 23 and 26;

select student.name
from student;



SELECT *
FROM student
WHERE name LIKE '%o%';

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




