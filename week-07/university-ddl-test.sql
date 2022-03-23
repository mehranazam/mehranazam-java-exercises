-- university mastery database

-- entities

-- students
-- instructors
-- grades
-- courses


drop database if exists university_mastery;

create database university_mastery;

use university_mastery;

create table students(

student_id int primary key auto_increment,

first_name varchar(25)not null,

last_name varchar(25)not null





);


create table instructors(

instructor_id int primary key auto_increment,

first_name varchar(25)not null,

last_name varchar(25)not null

);



create table courses(

course_id int primary key auto_increment,

instructor_id int not null,

`name` varchar(100),

constraint fk_courses_instructors foreign key(instructor_id) references instructors(instructor_id)



);

create table grades(

grade_id int primary key auto_increment,

student_id int not null,

instructor_id int not null,

course_id int not null,

grade_date date not null,

letter_grade varchar(15),

constraint fk_grades_students foreign key(student_id) references students(student_id),

constraint fk_grades_instructors foreign key(instructor_id) references instructors(instructor_id),

constraint fk_grades_courses foreign key(course_id) references courses(course_id)

);


create table course_students(

course_id int not null,

student_id int not null,

constraint pk_course_students primary key(course_id, student_id),

constraint fk_course_students_courses foreign key(course_id) references courses(course_id),

constraint fk_course_students_students foreign key(student_id) references students(student_id)


);


set delimiter //

create procedure set_known_good_state()
begin

set FOREIGN_KEY_CHECKS = 0;
delete from course_students;
truncate grades;
truncate courses;
truncate instructors;
truncate students;
set FOREIGN_KEY_CHECKS = 1;

insert into students(first_name, last_name)
values
('Alice', 'Adams'),
('Bob', 'Brown'),
('Charles', 'Crawford');

insert into instructors(first_name, last_name)
values
('Xavier', 'Xanderson'),
('York', 'McYork'),
('Zelda', 'Link');

insert into courses(instructor_id, `name`)
values
('1', 'Underwater Basketweaving'),
('2', 'Remedial Theoretical Physics'),
('3', 'Ocarina 101');

insert into grades(student_id, instructor_id, course_id, grade_date, letter_grade)
values
(1, 1, 1, '2020-04-01', 'A+'),
(2, 1, 1, '2020-04-01', 'C'),
(3, 1, 1, '2020-04-01', 'D'),
(1, 2, 2, '2020-03-14', 'B-'),
(3, 2, 2, '2020-03-14', 'F'),
(2, 3, 3, '1998-11-21', 'pass'),
(3, 3, 3, '1998-11-21', 'fail');



end //

set delimiter ;

call set_known_good_state();

delete from grades;

/*
select * from grades g
inner join instructors i on g.instructor_id = i.instructor_id
inner join students s on s.student_id = g.student_id
inner join courses c on c.course_id = g.course_id;
*/