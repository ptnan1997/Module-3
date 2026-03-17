use session14;

-- thủ tục cập nhật thông tin sinh viên
drop procedure if exists update_student;
delimiter $$
create procedure update_student(student_id_update int,student_name_update varchar(100), student_age int)
begin
    update students
        set
            student_name = student_name_update,
            age = student_age
    where student_id = student_id_update;
end ;
delimiter $$

insert into students (student_name, age)
VALUES  ('Nguyễn Văn A',28),
        ('Trần Thị B',27),
        ('Võ Như Mai',26),
        ('Trần Văn Lợi',30);

select * from students;

