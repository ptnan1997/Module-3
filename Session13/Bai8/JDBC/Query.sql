use java_connector;

create table Product
(
    id    int primary key auto_increment,
    name  varchar(100)   not null,
    price decimal(10, 2) not null
);
create table Customer
(
    customer_id    int primary key auto_increment,
    customer_name  varchar(100),
    customer_email varchar(100)
);
create table Orders
(
    order_id     int primary key auto_increment,
    customer_id  int,
    foreign key (customer_id) references Customer (customer_id),
    order_date   date           not null,
    total_amount decimal(10, 2) not null
);
select * from Product;
INSERT INTO Product(name, price)
VALUES ('Laptop Dell XPS 13', 1200.00),
       ('MacBook Pro M2', 1800.00),
       ('iPhone 14', 999.00),
       ('Samsung Galaxy S23', 950.00),
       ('iPad Air', 750.00),
       ('Sony Headphones WH-1000XM5', 400.00),
       ('Logitech MX Master 3S Mouse', 120.00),
       ('Mechanical Keyboard Keychron K8', 150.00);
INSERT INTO Customer(customer_name, customer_email)
VALUES ('Nguyen Van A', 'vana@gmail.com'),
       ('Tran Thi B', 'thib@gmail.com'),
       ('Le Van C', 'vanc@gmail.com'),
       ('Pham Thi D', 'thid@gmail.com'),
       ('Hoang Van E', 'vane@gmail.com');
INSERT INTO Orders(customer_id, order_date, total_amount)
VALUES (1, '2026-03-10', 1200.00),
       (2, '2026-03-10', 1998.00),
       (3, '2026-03-11', 950.00),
       (1, '2026-03-12', 1500.00),
       (4, '2026-03-13', 750.00),
       (5, '2026-03-14', 400.00);

-- Thêm sản phẩm mới
delimiter $$
create procedure add_product(name_in varchar(100), price_in decimal(10, 2))
begin
    insert into Product (name, price)
    VALUES (name_in,
            price_in);
end;
delimiter $$
-- Cập nhật thông tin khách hàng
delimiter $$
create procedure update_Customer(customer_id_update int, customer_name_update varchar(100),
                                 customer_email_update varchar(100))
begin
    update Customer
    set customer_name  = customer_name_update,
        customer_email = customer_email_update
    where customer_id = customer_id_update;
end;
delimiter $$
-- Tạo đơn hàng mới
drop procedure if exists create_Order;
delimiter $$
create procedure create_Order(customer_id_new int, total_amout_new decimal(10, 2))
begin
    insert into Orders(customer_id, order_date, total_amount)
    VALUES (customer_id_new,
            now(),
            total_amout_new);
end;
delimiter $$
-- Hiển thị danh sách đơn hàng
drop procedure if exists listAllOrder;
delimiter $$
create procedure listAllOrders()
begin
    select c.customer_name,
           o.order_date,
           o.total_amount
    from Orders o
             join Customer c on o.customer_id = c.customer_id;
end;
delimiter $$
-- Tìm kiếm đơn hàng theo tên khách hàng
drop procedure if exists getOrdersByCustomer;

delimiter $$
create procedure getOrdersByCustomer(customerId_find int)
begin
    select *
    from Orders
    where customer_id = customerId_find;
end;
delimiter $$
