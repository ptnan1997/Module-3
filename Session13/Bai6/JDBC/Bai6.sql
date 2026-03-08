use java_connector;
drop table if exists tasks;
create table tasks
(
    task_id   int primary key auto_increment,
    task_name varchar(100),
    status    enum ('UNFINISHED','FINISHED')
);
INSERT INTO tasks (task_name, status)
VALUES ('Complete Java assignment', 'UNFINISHED'),
       ('Review SQL queries', 'FINISHED'),
       ('Prepare presentation slides', 'UNFINISHED'),
       ('Fix login bug in project', 'FINISHED'),
       ('Write documentation', 'FINISHED'),
       ('Test application features', 'UNFINISHED'),
       ('Update project dependencies', 'FINISHED'),
       ('Design database schema', 'UNFINISHED'),
       ('Refactor old code modules', 'UNFINISHED'),
       ('Deploy application to server', 'FINISHED');
-- Thêm công việc
drop procedure if exists add_task;
delimiter $$
create procedure add_task(task_name_in varchar(100), status_in enum ('UNFINISHED','FINISHED') )
begin
    insert into tasks (task_name, status)
        values (task_name_in,status_in);
end;
delimiter $$
-- Liệt kê công việc
drop procedure if exists list_tasks;
delimiter $$
create procedure list_tasks()
begin
    select * from tasks;
end;
delimiter $$
-- Cập nhật trạng thái công việc
drop procedure if exists update_task_status;
delimiter $$
create procedure update_task_status(task_id_update int, status_update enum ('UNFINISHED','FINISHED'))
begin
        update tasks
        set
            status = status_update
        where task_id = task_id_update;
end;
delimiter $$
-- Xóa công việc
drop procedure if exists delete_task;
delimiter $$
create procedure delete_task(task_id_delete int)
begin
    delete from tasks where task_id = task_id_delete;
end;
delimiter $$
-- Tìm kiếm công việc
drop procedure if exists search_task_by_name;
delimiter $$
create procedure search_task_by_name(task_name_find varchar(100))
begin
    select * from tasks where task_name = task_name_find;
end;
delimiter $$
-- Thống kê công việc
drop procedure if exists task_statistics;
delimiter $$
create procedure task_statistics(status_in enum ('UNFINISHED','FINISHED'))
begin
    select * from tasks where status = status_in;
end;
delimiter $$