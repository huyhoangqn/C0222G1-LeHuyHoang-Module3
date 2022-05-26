CREATE DATABASE case_study;
use case_study;
CREATE TABLE part (
    id_part INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name_part VARCHAR(45)
);
insert into part(name_part)
values ('kế toán'),
       ('thiết kế'),
       ('hồ sơ');
create table level
(
    id_level int primary key auto_increment not null,
    level    varchar(45)
);
insert into level(level)
values ('đại học'),
       ('cao đẳng'),
       ('trung cấp');
create table position
(
    id_position   int primary key auto_increment not null,
    name_position varchar(45)
);

insert into position (name_position)
values ('trưởng phòng'),
       ('phó phòng'),
       ('nhân viên');

create table staff
(
    id_staff      int not null primary key auto_increment,
    name_staff    varchar(45),
    id_position   int,
    id_level      int,
    id_part       int,
    birthday      date,
    identity_card varchar(45),
    salary        varchar(45),
    number_phone  varchar(45),
    email         varchar(45),
    address       varchar(45),
    foreign key (id_part) references part (id_part),
    foreign key (id_level) references level (id_level),
    foreign key (id_position) references position (id_position)
);
insert into staff (name_staff, id_position, id_level, id_part, birthday, identity_card, salary, number_phone, email,
                   address)
values ('Hồ Thanh Thanh', 1, 1, 1, '1997-01-01', '2128204682', '20.000.000', '036252126', 'thanh@gmail.com',
        'Đà Nẵng'),
       ('Lương Ngọc Đình', 2, 3, 3, '1998-01-11', '212556589', '14000000', '0985445444', 'dinh@gmail.com', 'Quảng Trị'),
       ('Võ Văn Dương', 3, 2, 1, '1991-6-14', '211466555', 10000000, '0954664333', 'duong@gmail.com', 'Quảng Ngãi');
create table type_customer
(
    id_type_customer   int primary key auto_increment not null,
    name_type_customer varchar(45)
);
insert into type_customer (name_type_customer)
values ('Diamond'),
       ('VIP'),
       ('Normal');
create table customer
(
    id_customer           int primary key auto_increment not null,
    id_type_customer      int,
    name_customer         varchar(45),
    birthday_customer     date,
    identity_cardCustomer varchar(45),
    number_phone_customer varchar(45),
    email_customer        varchar(45),
    address_customer      varchar(45),
    foreign key (id_type_customer) references type_customer (id_type_customer)
);
insert into customer(id_type_customer, name_customer, birthday_customer, identity_cardCustomer, number_phone_customer,
                     email_customer, address_customer)
values (1, 'Nguyễn Thị Chung', '1997-07-11', '212 486 009', '036 252 1226', 'chung@gmail.com', 'Đà Nẵng'),
       (3, 'Thu Hiền', '1993-2-23', '216 333 666', '095 5654 235', 'thuhien@gmail.com', 'Đà Nẵng'),
       (2, 'Văn Thanh', '1996-8-2', '216 456 756', '095 6563 111', 'vanthanh@gmail.com', 'Đà Nẵng');
create table type_rental
(
    id_type_rental   int primary key not null auto_increment,
    name_type_rental varchar(45),
    price            int
);
insert into type_rental (name_type_rental, price)
values ('theo giờ', 80000),
       ('theo ngày', 200000),
       ('theo tháng', 20000000);
create table type_service
(
    id_type_service   int primary key not null auto_increment,
    name_type_service varchar(45)
);
insert into type_service (name_type_service)
values ('hồ bơi'),
       ('spa'),
       ('casino');
create table services
(
    id_service      int primary key not null auto_increment,
    name_service    varchar(45),
    area            int,
    floors          int,
    max_people      varchar(45),
    rental_costs    varchar(45),
    id_type_rental  int,
    id_type_service int,
    status          varchar(45),
    foreign key (id_type_rental) references type_rental (id_type_rental),
    foreign key (id_type_service) references type_service (id_type_service)
);
insert into services(name_service, area, floors, max_people, rental_costs, id_type_rental, id_type_service, status)
values ('villa', 100, 2, '10', '15000000', 1, 1, 'đang hoạt động'),
       ('house', 50, 2, '6', '10000000', 3, 2, 'đang hoạt động'),
       ('room', 30, 1, 2, 5000000, 2, 1, 'đang hoạt động');
create table Service_extra
(
    id_service_extra    int primary key not null auto_increment,
    name_service_extra  varchar(45),
    price               int,
    unit                int,
    status_availability varchar(45)
);
insert into Service_extra (name_service_extra, price, unit, status_availability)
values ('massage', 200000, 2, 'đang hoạt động'),
       ('gym', 100000, 1, 'đang hoạt động'),
       ('ăn sáng', 150000, 4, 'đang hoạt động');
create table contract
(
    id_contract int primary key auto_increment not null,
    id_staff    int,
    id_customer int,
    id_service  int,
    date_start  date,
    date_end    date,
    deposits    int,
    total       int,
    foreign key (id_staff) references staff (id_staff),
    foreign key (id_customer) references customer (id_customer),
    foreign key (id_service) references services (id_service)
);
insert into contract(id_staff, id_customer, id_service, date_start, date_end, deposits, total)
VALUES (1, 2, 1, '2021-05-13', '2021-05-16', 5000000, 20000000),
       (3, 2, 3, '2021-01-14', '2021-01-18', 2000000, 7000000),
       (2, 3, 1, '2021-01-14', '2021-01-18', 5000000, 15000000);
create table Contract_details
(
    id_contract_detail int primary key not null auto_increment,
    id_contract        int,
    id_service_extra   int,
    amount             int,
    foreign key (id_contract) references contract (id_contract),
    foreign key (id_service_extra) references service_extra (id_service_extra)
);
insert into Contract_details(id_contract, id_service_extra, amount)
VALUES (1, 2, 2),
       (3, 2, 1),
       (2, 3, 2);
       
 select * from contract;
 select * from contract_details;
 select * from customer;
 select * from level;
 select * from part;
 select * from position;
 select * from service_extra;
 select * from services;
 select * from staff;
 select * from type_customer;
 select * from type_rental;
 select * from type_service;
       

-- Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select *
from case_study.customer
where ((substring_index(name_customer,' ',-1)) like 'H%' or'K%'or'T%' ) and LENGTH(name_customer) <= 15 ;

-- Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select *
from customer
where (year(curdate()) - year(birthday_customer) >= 18
    and year(curdate()) - year(birthday_customer) <= 50)
    and (address_customer like '%Đà Nẵng%'
   or address_customer like '%Quảng Trị%');

-- Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần
select a.name_customer, t2.name_type_customer, count(id_contract)
from customer a
         inner join type_customer t2 on a.id_type_customer = t2.id_type_customer
         inner join contract c on c.id_customer = c.id_customer
where t2.name_type_customer = 'Diamond'
group by a.id_customer
order by count(id_contract) asc;

-- Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
select a.id_customer,
       a.name_customer,
       t.name_type_customer,
       c.id_contract,
       s.name_service,
       c.date_start,
       c.date_end,
       sum(s.rental_costs + s2.unit * s2.price) as total
from customer a
         left join contract c on a.id_customer = c.id_customer
         left join contract_details cd on c.id_contract = cd.id_contract
         left join type_customer t on a.id_type_customer = t.id_type_customer
         left join services s on c.id_service = s.id_service
         left join service_extra s2 on cd.id_service_extra = s2.id_service_extra
group by (a.id_customer);

# 6.Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại
# Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
select s.id_service, s.name_service, s.area, s.rental_costs, ts.name_type_service
from services s
         inner join type_service ts on s.id_type_service = ts.id_type_service
         inner join contract c on s.id_service = c.id_service
where s.id_service not in (select s.id_service
                           from contract c
                                    inner join services s on c.id_service = s.id_service
                           where year(c.date_start) = 2021
                             and (month(c.date_start) = 1 or month(c.date_start) = 2 or month(c.date_start) = 3)
                           group by s.id_service)
group by s.id_service;

# 7.Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue,
# tenLoaiDichVu của tất cả các loại dịch vụ đã từng được Khách
# hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.
select s.id_service, s.name_service, s.area, s.max_people, s.rental_costs, ts.name_type_service
from services s
         inner join type_service ts on s.id_type_service = ts.id_type_service
         inner join contract c on s.id_service = c.id_service
         inner join customer c2 on c.id_customer = c2.id_customer
where year(c.date_start) = 2020
  and ts.id_type_service in (select ts.id_type_service
                                 from services s
                                          inner join type_service ts on s.id_type_service = ts.id_type_service
                                          inner join contract c on s.id_service = c.id_service
                                          inner join customer c3 on c.id_customer = c3.id_customer
                                 where year(c.date_start) = 2021);

# 8.Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
# Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
# cach 1:
select distinct c.name_customer
from customer c;
# cách 2:
select name_customer
from customer
group by name_customer;
# cách 3:
select c2.name_customer
from customer c2
union
select c.name_customer
from customer c;

# 9.Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019
# thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(c.date_start) as 'tháng', count(distinct c.id_customer) as doanh_thu
from contract c
         inner join customer c2 on c.id_customer = c2.id_customer
where year(c.date_start)=2021
group by month(c.date_start);

# 10.Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm.
select c.id_contract, c.date_start, c.date_end, c.deposits, count(cd.id_contract_detail) as so_luong_DV_di_kem
from contract c
         inner join contract_details cd on c.id_contract = cd.id_contract
         inner join service_extra se on cd.id_service_extra = se.id_service_extra
group by c.id_contract;

# 11.Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có
# TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
select s.id_service_extra, name_service_extra, price, unit, status_availability
from service_extra s
         inner join contract_details cd on s.id_service_extra = cd.id_service_extra
         inner join contract c on cd.id_contract = c.id_contract
         inner join customer c2 on c.id_customer = c2.id_customer
         inner join type_customer tc on c2.id_type_customer = tc.id_type_customer
where tc.name_type_customer = 'Diamond'
  and (c2.address_customer like '%Vinh%' or c2.address_customer like '%Quảng Ngãi%')
group by s.id_service_extra;

       