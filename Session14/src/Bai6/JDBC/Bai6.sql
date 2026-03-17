use session14;

create table employees
(
    employ_id   int primary key auto_increment,
    employ_name varchar(50)
);
create table projects
(
    project_id   int primary key auto_increment,
    project_name varchar(50)
);
create table assignment
(
    employ_id  int,
    project_id int,
    foreign key (employ_id) references employees (employ_id),
    foreign key (project_id) references projects (project_id),
    primary key (employ_id, project_id)
);

INSERT INTO employees(employ_name)
VALUES ('Nguyen Van A'),
       ('Tran Thi B'),
       ('Le Van C'),
       ('Pham Thi D'),
       ('Hoang Van E');
INSERT INTO projects(project_name)
VALUES ('Website E-commerce'),
       ('Mobile Banking App'),
       ('AI Chatbot'),
       ('Inventory Management System'),
       ('Online Learning Platform');
-- Thủ tục gán nhân viên vào dự án
delimiter $$
create procedure assign_employee_to_project(in project_id_in int, in employ_id_in int)
begin
    insert into assignment (employ_id, project_id)
    VALUES (employ_id_in, project_id_in);
end;
delimiter $$

select * from employees;
select * from projects;
select * from assignment;