create database session14;
use session14;

create table students (
                          student_id int primary key auto_increment,
                          student_name varchar (50),
                          age int
);

delimiter $$
create procedure add_student(student_name_in varchar(50),age_in int)
begin
    insert into students (student_name, age)
    VALUES (student_name_in,age_in);
end ;
delimiter $$