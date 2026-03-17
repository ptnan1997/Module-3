create database session14_bai8;

use session14_bai8;

create table Account
(
    account_id     int primary key auto_increment,
    account_number varchar(50)    not null,
    balance        decimal(10, 2) not null
);
create table Transaction
(
    trans_id    int primary key auto_increment,
    from_acc_id int,
    foreign key (from_acc_id) references Account (account_id),
    to_acc_id   int,
    foreign key (to_acc_id) references Account (account_id),
    amount      decimal(10, 2) not null,
    trans_date  datetime       not null
);
INSERT INTO Account (account_number, balance)
VALUES ('ACC001', 5000000.00),
       ('ACC002', 3000000.00),
       ('ACC003', 1000000.00),
       ('ACC004', 7000000.00);
INSERT INTO Transaction (from_acc_id, to_acc_id, amount, trans_date)
VALUES (1, 2, 500000.00, '2026-03-15 10:00:00'),
       (2, 3, 200000.00, '2026-03-15 11:00:00'),
       (4, 1, 1000000.00, '2026-03-16 09:30:00');
-- Chuyển tiền
delimiter $$
create procedure tranfer_funds (in from_acc_id_in int,in to_acc_id_in int,in amount_in decimal(10,2))
begin
    -- Cộng tiền tài khoản người nhận

        update Account
            set
                balance = balance + amount_in
        where account_id = to_acc_id_in;

    -- Trừ tiền tài khoản người gửi

        update Account
            set
                balance = balance - amount_in
        where account_id = from_acc_id_in;
    -- Lưu vào lịch sử giao dịch

        insert into transaction (from_acc_id, to_acc_id, amount, trans_date)
            values (
                       from_acc_id_in,
                       to_acc_id_in,
                       amount_in,
                    now()
                   );
end ;
delimiter $$
-- Lấy thông tin tài khoản
delimiter $$
create procedure getAccountInfo(in accountId int)
begin
    select * from Account where account_id = accountId;
end ;
delimiter $$

-- Hiển thị lịch sử giao dịch
delimiter $$
create procedure listTransactions(in accountId int)
begin
    select * from Transaction where from_acc_id = accountId or to_acc_id = accountId;
end ;
delimiter $$