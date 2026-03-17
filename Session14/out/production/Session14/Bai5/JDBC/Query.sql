use session14;

create table Orders
(
    id           int primary key auto_increment,
    customer_id  int,
    total_amount decimal,
    product_id   int,
    foreign key (product_id) references Products (id),
    quantity     int
);
create table Products
(
    id           int primary key auto_increment,
    product_name varchar(50),
    stock        int
);

INSERT INTO products(product_name, stock)
VALUES ('Iphone 15', 20),
       ('Samsung S24', 15),
       ('Macbook Pro', 10),
       ('Airpods Pro', 30),
       ('Ipad Air', 12);
-- thủ tục tạo đơn hàng mới
delimiter $$
create procedure place_order(customer_id_in int, total_Amount_in decimal, product_id_in int, quantity_in int)
begin
    insert into Orders (customer_id, total_amount, product_id, quantity)
    VALUES (customer_id_in,
            total_amount_in,
            product_id_in,
            quantity_in);
end;
delimiter $$
-- Lấy về sản phẩm theo id
delimiter $$
create procedure get_product_by_id(in_id int)
begin
    select *
    from Products
    where id = in_id;
end;
delimiter $$
-- Cập nhật số lượng kho của sản phẩm
delimiter $$
create procedure save_Stock_Product(in_product_id int, in_stock int)
begin
    update Products
    set stock = in_stock
    where id = in_product_id;
end;
delimiter $$

select * from Products;
select * from Orders;