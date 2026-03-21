create database session15;
use session15;

create table Product (
                         product_id int primary key auto_increment,
                         product_name varchar (100) not null,
                         product_price float not null,
                         check(product_price>0),
                         product_Title varchar (200) not null,
                         product_created date not null,
                         product_catalog varchar(100) not null,
                         product_status bit default 1
);
INSERT INTO Product
(Product_Name, Product_Price, Product_Title, Product_created, Product_catalog, Product_Status)
VALUES
    ('iPhone 15', 999.99, 'Điện thoại Apple mới nhất', '2024-01-10', 'Phone', 1),
    ('Samsung Galaxy S23', 899.50, 'Flagship Samsung', '2024-01-12', 'Phone', 1),
    ('Xiaomi 13', 650.00, 'Giá tốt, cấu hình mạnh', '2024-01-15', 'Phone', 1),
    ('MacBook Air M2', 1200.00, 'Laptop mỏng nhẹ', '2024-02-01', 'Laptop', 1),
    ('Dell XPS 13', 1100.00, 'Laptop cao cấp', '2024-02-03', 'Laptop', 1),
    ('HP Pavilion', 800.00, 'Laptop tầm trung', '2024-02-05', 'Laptop', 0),
    ('iPad Pro', 950.00, 'Máy tính bảng cao cấp', '2024-03-01', 'Tablet', 1),
    ('Samsung Tab S9', 700.00, 'Tablet Android mạnh', '2024-03-02', 'Tablet', 1),
    ('AirPods Pro', 250.00, 'Tai nghe không dây', '2024-03-10', 'Accessory', 1),
    ('Sony WH-1000XM5', 300.00, 'Tai nghe chống ồn', '2024-03-12', 'Accessory', 1),
    ('Logitech MX Master 3', 120.00, 'Chuột cao cấp', '2024-03-15', 'Accessory', 1),
    ('Asus ROG Phone 7', 950.00, 'Gaming phone', '2024-01-20', 'Phone', 0),
    ('Lenovo ThinkPad X1', 1300.00, 'Laptop doanh nhân', '2024-02-10', 'Laptop', 1),
    ('Acer Nitro 5', 900.00, 'Laptop gaming', '2024-02-12', 'Laptop', 1),
    ('iPhone 14', 850.00, 'iPhone đời trước', '2023-12-20', 'Phone', 1);

-- Các thủ tục
-- Lấy thông tin sản phẩm
drop procedure if exists getAllProductsInfo;
delimiter $$
create procedure getAllProductsInfo()
begin
    select product_id ,
           product_name ,
           product_price ,
           product_Title ,
           product_created ,
           product_catalog ,
           product_status
    from Product;
end ;
delimiter $$
-- Kiểm tra sự tồn tại của danh mục
drop procedure if exists checkCatalogExistOrNot ;
delimiter $$
create procedure checkCatalogExistOrNot(in product_catalog_in varchar(100),out is_Exist boolean)
begin
    select count(*)>0 into is_Exist
    from Product where product_catalog = product_catalog_in;
end ;
delimiter $$
-- Thêm mới một sản phẩm
drop procedure if exists addNewProduct;
delimiter $$
create procedure addNewProduct(
    product_name_in varchar(100),product_price_in float,product_Title_in varchar(200),product_catalog_in varchar(100))
begin
    insert into Product(product_name,product_price,product_Title,product_created,product_catalog)
    values (
               product_name_in,
               product_price_in,
               product_Title_in,
               now(),
               product_catalog_in
           );
end ;
delimiter $$
-- Cập nhật một sản phẩm theo mã sản phẩm
delimiter $$
create procedure updateProductById(
    in productId_edit int,in product_name_new varchar(100),
    in product_price_new float,in product_Title_new varchar(200),
    in product_created_new date,in product_catalog_new varchar (100))
begin
    update Product
    set
        product_name =product_name_new,
        product_price =product_price_new,
        product_Title =product_Title_new,
        product_created = product_created_new,
        product_catalog = product_catalog_new
    where product_id = productId_edit;
end ;
delimiter $$
-- Xóa một sản phẩm theo mã sản phẩm
delimiter $$
create procedure deleteProductFromId(in product_id_delete int)
begin
    delete from Product where product_id = product_id_delete;
end ;
delimiter $$
-- Lấy thông tin sản phẩm theo mã sản phẩm
delimiter $$
create procedure getProductInforById (in product_id_find int)
begin
    select * from Product where product_id = product_id_find;
end ;
delimiter $$
-- Tìm kiếm sản phẩm theo tên sản phẩm (tương đối)
delimiter $$
create procedure getProductByName(in product_name_find varchar (100))
begin
    select * from Product
    where product_name like product_name_find;
end ;
delimiter $$
-- Thống kê số lượng sản phẩm theo danh mục
drop procedure if exists stalisticProductBy;
delimiter $$
create procedure stalisticProductBy (in product_catalog_in varchar(100), out count_product int)
begin
    select count(product_id) into count_product
    from Product where product_catalog = product_catalog_in;
end ;
delimiter $$
-- Sắp xếp sản phẩm theo giá tăng dần
delimiter $$
create procedure orderByPriceIncrease()
begin
    select * from Product
        order by product_price;
end ;
delimiter $$