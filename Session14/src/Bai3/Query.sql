use session14;

-- Tạo thủ tục xóa tất cả sinh viên nào có độ tuổi nhỏ hơn số tuổi người dùng nhập vào
delimiter $$
create procedure delete_student_by_age(acceptAge int)
begin
    delete from students where age < acceptAge;
end ;
delimiter $$

select * from students;
