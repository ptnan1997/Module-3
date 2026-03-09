use java_connector;

create table Book
(
    id             int primary key auto_increment,
    title          varchar(255)   not null,
    author         varchar(255)   not null,
    published_year year           not null,
    price          decimal(10, 2) not null
);

INSERT INTO Book (title, author, published_year, price)
VALUES ('Clean Code', 'Robert C. Martin', 2008, 35.50),
       ('Effective Java', 'Joshua Bloch', 2018, 45.00),
       ('Design Patterns', 'Erich Gamma', 1994, 50.75),
       ('Refactoring', 'Martin Fowler', 1999, 47.20),
       ('The Pragmatic Programmer', 'Andrew Hunt', 1999, 40.00),
       ('Head First Java', 'Kathy Sierra', 2005, 38.90),
       ('Java Concurrency in Practice', 'Brian Goetz', 2006, 42.60),
       ('Introduction to Algorithms', 'Thomas H. Cormen', 2009, 55.30),
       ('Spring in Action', 'Craig Walls', 2018, 44.80),
       ('Effective Python', 'Brett Slatkin', 2015, 37.45);
-- Thêm sách
delimiter $$
create procedure add_book(title_in varchar(255), author_in varchar(255), published_year_in year, price_in decimal)
begin
    insert into Book(title, author, published_year, price)
    values (title_in, author_in, published_year_in, price_in);
end;
delimiter $$
-- Cập nhật thông tin sách
delimiter $$
create procedure update_book(id_update int, title_in varchar(255), author_in varchar(255), published_year_in year,
                             price_in decimal)
begin
    update Book
    set title          = title_in,
        author         = author_in,
        published_year = published_year_in,
        price          = price_in
    where id = id_update;
end;
delimiter $$
-- Xóa sách
delimiter $$
create procedure delete_book(id_delete int)
begin
    delete from Book where id = id_delete;
end;
delimiter $$
-- Tìm kiếm sách
delimiter $$
create procedure find_book_by_author(author_find varchar(255))
begin
    select *
    from Book
    where author = author_find;
end;
delimiter $$
-- Hiển thị danh sách tất cả sách
delimiter $$
create procedure list_All_book()
begin
    select * from Book;
end;
delimiter $$