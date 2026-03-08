use java_connector;

create table Movies
(
    movie_id int primary key auto_increment,
    title    varchar(100),
    director varchar(100),
    year     int
);

INSERT INTO Movies (title, director, year)
VALUES ('Inception', 'Christopher Nolan', 2010),
       ('Titanic', 'James Cameron', 1997),
       ('Avatar', 'James Cameron', 2009),
       ('The Dark Knight', 'Christopher Nolan', 2008),
       ('Interstellar', 'Christopher Nolan', 2014),
       ('Jurassic Park', 'Steven Spielberg', 1993),
       ('The Matrix', 'Lana Wachowski & Lilly Wachowski', 1999),
       ('Gladiator', 'Ridley Scott', 2000),
       ('The Shawshank Redemption', 'Frank Darabont', 1994),
       ('Parasite', 'Bong Joon-ho', 2019);
-- Chức năng Thêm Phim
delimiter $$
create procedure add_movie(title_in varchar(100), director_in varchar(100), year_in int)
begin
    insert into Movies (title, director, year)
    values (title_in, director_in, year_in);
end;
delimiter $$
-- Chức năng Liệt kê phim ( Hiển thị danh sách phim)
delimiter $$
create procedure list_movies()
begin
    select movie_id,
           title,
           director,
           year
    from Movies;
end;
delimiter $$
drop procedure list_movies;
-- Sửa phim
delimiter $$
create procedure update_movie(movie_id_in int, title_in varchar(100), director_in varchar(100), year_in int)
begin
    update Movies
    set title    = title_in,
        director = director_in,
        year     = year_in
    where movie_id = movie_id_in;
end;
delimiter $$
-- Xóa phim
delimiter $$
create procedure delete_movie(movie_id_in int)
begin
    delete
    from Movies
    where movie_id = movie_id_in;
end;
delimiter $$