use java_connector;

create table if not exists Students  (
    student_id int primary key auto_increment,
    full_name varchar (100) not null unique ,
    date_of_birth date not null,
    email varchar (100) not null unique

);

insert into Students(full_name, date_of_birth, email)
values
        ('hungtx','20020504', 'hungtx@gmail.com'),
        ('nhungtx','20020407', 'nhungtx@gmail.com');
-- add_student
delimiter $$
create procedure add_student(full_name_in varchar (100), date_of_birth_in date, email_in varchar (100))
begin
    insert into Students(full_name, date_of_birth, email) values (full_name_in,date_of_birth_in, email_in);
end $$
delimiter ;
-- get_all_students
delimiter $$
create procedure get_all_students ()
begin
    select * from Students;
end $$
delimiter ;
-- update_student
delimiter $$
create procedure update_student (in_id int,in_full_name varchar(100),in_date_of_birth date,in_email varchar(100))
begin
    update Students
    set
        full_name = in_full_name,
        date_of_birth= in_date_of_birth,
        email = in_email
    where student_id = in_id;
end $$
delimiter ;
drop procedure update_student;
-- find_student_by_ìd
delimiter $$
create procedure find_student_by_id( in_id int)
begin
    select * from Students where student_id= in_id;
end ;
delimiter $$
-- delete_student
delimiter $$
create procedure delete_student (in_id int)
begin
    delete from Students
        where student_id = in_id;
end ;
delimiter $$
