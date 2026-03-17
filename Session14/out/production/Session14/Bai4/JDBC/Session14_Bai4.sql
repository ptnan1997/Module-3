use session14;

create table accounts(
    account_id int primary key auto_increment,
    balance decimal(10,2)
);
insert into accounts (balance)
    values (10000),
        (10000);
-- Thủ tục chuyển tiền
delimiter $$
create procedure transfer_funds (from_account_id int, to_account_id int, amount decimal(10,2))
begin
    -- Trừ tiền tài khoản người nhận
    update accounts
    set
        balance = balance - amount
    where account_id = from_account_id;
    -- Cộng tiền tài khoản người gửi
    update accounts
    set
        balance = balance + amount
    where account_id = to_account_id;
end ;
delimiter $$
select * from accounts;