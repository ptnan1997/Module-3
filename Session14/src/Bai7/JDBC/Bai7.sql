use session14;

create table Room (
    room_id int primary key auto_increment,
    room_number varchar (10) not null,
    type varchar(50) not null,
    price decimal (10,2) not null,
    is_booked boolean default (false)
);
create table Booking (
    booking_id int primary key auto_increment,
    room_id int,
    foreign key (room_id) references Room(room_id),
    customer_name varchar(255) not null,
    start_date date not null,
    end_date date not null
);
INSERT INTO Room (room_number, type, price, is_booked) VALUES
                                                           ('A101', 'Single', 500000, false),
                                                           ('A102', 'Double', 800000, false),
                                                           ('A103', 'VIP', 1500000, true),
                                                           ('B201', 'Single', 550000, false),
                                                           ('B202', 'Double', 900000, true),
                                                           ('B203', 'VIP', 2000000, false);
INSERT INTO Booking (room_id, customer_name, start_date, end_date) VALUES
                                                                       (3, 'Nguyen Van A', '2026-03-10', '2026-03-15'),
                                                                       (5, 'Tran Thi B', '2026-03-12', '2026-03-18');

--
delimiter $$
create procedure listAvailableRooms()
begin
    select * from Room where is_booked = false;
end ;
delimiter $$
--
delimiter $$
create procedure cancleBooking( in booking_id_cancle int)
begin
    delete from Booking where booking_id = booking_id_cancle;
end ;
delimiter $$
--
drop procedure if exists bookRoom;
delimiter $$
create procedure bookRoom (in roomId_in int,in customerName_in varchar(255),in start_date_in date,in end_date_in date)
begin
    insert into Booking (room_id,customer_name,start_date,end_date)
        values (
                   roomId_in,customerName_in,start_date_in,end_date_in
               );
    update Room
        set is_booked = true
    where room_id = roomId_in;
end ;
delimiter $$