CREATE DATABASE case_study1;
use case_study1;
CREATE TABLE bo_phan (
    ma_bo_phan INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    ten_bo_phan VARCHAR(45)
);
insert into bo_phan(ten_bo_phan) values 
		('Sale-Marketing'),
       ('Hành chính'),
       ('Phục vụ'),
       ('Quản lý');
create table trinh_do
(
    ma_trinh_do int primary key auto_increment not null,
    ten_trinh_do varchar(45)
);
insert into trinh_do(ten_trinh_do)
values 
('Trung cấp'),
('Cao đẳng'),
('Đại học'),
('Sau đại học');
create table vi_tri
(
    ma_vi_tri   int primary key auto_increment not null,
    ten_vi_tri varchar(45)
);
insert into vi_tri (ten_vi_tri)
values ('Quản lý'),
       ('Nhân viên');
create table nhan_vien
(
    ma_nhan_vien      int not null primary key auto_increment,
    ho_ten    varchar(45) not null,
	ngay_sinh      date not null,
    so_cmnd varchar(45) not null,
    luong double not null,
    so_dien_thoai  varchar(45) not null,
	email         varchar(45),
    dia_chi       varchar(45),
    ma_vi_tri   int,
    ma_trinh_do      int,
    ma_bo_phan       int,
    foreign key (ma_vi_tri) references vi_tri (ma_vi_tri),
    foreign key (ma_trinh_do) references trinh_do (ma_trinh_do),
    foreign key (ma_bo_phan) references bo_phan (ma_bo_phan)
);

insert into nhan_vien(ho_ten, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, ma_vi_tri, ma_trinh_do, ma_bo_phan)
values ('Nguyễn Văn An','1970-11-07','456231786','10000000','0901234121','annguyen@gmail.com','295 Nguyễn Tất Thành,Đà Nẵng',1,3,1), 
		('Lê Văn Bình',	'1997-04-09','654231234','7000000',	'0934212314','binhlv@gmail.com','22 Yên Bái, Đà Nẵng',1,2,2),
        ('Hồ Thị Yến','1995-12-12','999231723','14000000','0412352315','thiyen@gmail.com','K234/11 Điện Biên Phủ, Gia Lai',1,3,2),
        ('Võ Công Toản','1980-04-04','123231365','17000000','0374443232','toan0404@gmail.com','77 Hoàng Diệu, Quảng Trị',1,4,4),
        ('Nguyễn Bỉnh Phát','1999-12-09','454363232','6000000','0902341231','phatphat@gmail.com','43 Yên Bái, Đà Nẵng',2,1,1),
        ('Khúc Nguyễn An Nghi','2000-11-08','964542311','7000000','0978653213','annghi20@gmail.com','294 Nguyễn Tất Thành, Đà Nẵng',2,2,3),
        ('Nguyễn Hữu Hà','1993-01-01','534323231','8000000','0941234553','nhh0101@gmail.com','4 Nguyễn Chí Thanh, Huế',2,3,2),
        ('Nguyễn Hà Đông','1989-09-03','234414123','9000000','0642123111','donghanguyen@gmail.com','111 Hùng Vương, Hà Nội',2,4,4),
        ('Tòng Hoang','1982-09-03','256781231','6000000','0245144444','hoangtong@gmail.com','213 Hàm Nghi, Đà Nẵng',2,4,4),
        ('Nguyễn Công Đạo','1994-01-08','755434343','8000000','0988767111','nguyencongdao12@gmail.com','6 Hoà Khánh, Đồng Nai',2,3,2);
create table loai_khach(
ma_loai_khach int not null primary key auto_increment,
ten_loai_khach varchar(45)
);
insert into loai_khach (ten_loai_khach)
values ('Diamond'),
       ('VIP'),
       ('Normal'),
       ('Gold'),
       ('Silver');
create table khach_hang
(
    ma_khach_hang           int primary key auto_increment not null,
    ma_loai_khach      int,
    ho_ten         varchar(45) not null,
    ngay_sinh     date not null,
    gioi_tinh bit,
    so_cmnd varchar(45) not null,
    so_dien_thoai varchar(45) not null,
    email        varchar(45),
    dia_chi      varchar(45),
    foreign key (ma_loai_khach) references loai_khach (ma_loai_khach)
);

insert into khach_hang(ma_loai_khach, ho_ten, ngay_sinh, gioi_tinh, so_cmnd, so_dien_thoai, email, dia_chi) values 
(5,'Nguyễn Thị Hào','1970-11-07',0,'643431213','0945423362','thihao07@gmail.com','23 Nguyễn Hoàng, Đà Nẵng'),
(3,'Phạm Xuân Diệu','1992-08-08',1,'865342123','0954333333','xuandieu92@gmail.com','K77/22 Thái Phiên, Quảng Trị'),
(1,'Trương Đình Nghệ','1990-02-27',1,'488645199','0373213122','nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh'),
(1,'Dương Văn Quan','1981-07-08',1,'543432111','0490039241','duongquan@gmail.com','K453/12 Lê Lợi, Đà Nẵng'),
(4,'Hoàng Trần Nhi Nhi','1995-12-09',0	,'795453345','0312345678','nhinhi123@gmail.com','224 Lý Thái Tổ, Gia Lai'),
(4,'Tôn Nữ Mộc Châu','2005-12-06',0,'732434215','0988888844','tonnuchau@gmail.com','37 Yên Thế, Đà Nẵng'),
(1,'Nguyễn Mỹ Kim','1984-04-08',0,'856453123','0912345698','kimcuong84@gmail.com','K123/45 Lê Lợi, Hồ Chí Minh'),
(3,	'Nguyễn Thị Hào','1999-04-08',0,'965656433','0763212345','haohao99@gmail.com','55 Nguyễn Văn Linh, Kon Tum'),
(1,'Trần Đại Danh','1994-07-01'	,1,'432341235','0643343433','danhhai99@gmail.com','24 Lý Thường Kiệt, Quảng Ngãi'),
(2,'Nguyễn Tâm Đắc','1989-07-01',1,'344343432','0987654321','dactam@gmail.com','22 Ngô Quyền, Đà Nẵng');

create table kieu_thue
(
    ma_kieu_thue   int primary key not null auto_increment,
    ten_kieu_thue varchar(45)
);
insert into kieu_thue (ten_kieu_thue)
values ('theo giờ'),
       ('theo ngày'),
       ('theo tháng'),
       ('theo năm');
create table loai_dich_vu
(
    ma_loai_dich_vu   int primary key not null auto_increment,
    ten_loai_dich_vu varchar(45)
);
insert into loai_dich_vu (ten_loai_dich_vu)
values ('Villa '),
       ('House'),
       ('Room');
create table dich_vu
(
    ma_dich_vu      int primary key not null auto_increment,
    ten_dich_vu    varchar(45) not null,
    dien_tich            int,
	chi_phi_thue    varchar(45)not null,
	so_nguoi_toi_da      int,
	ma_kieu_thue  int,
    ma_loai_dich_vu int,
    tieu_chuan_phong varchar(45),
    mo_ta_tien_nghi_khac varchar(45),
    dien_tich_ho_boi double,
    so_tang          int,
    foreign key (ma_kieu_thue) references kieu_thue (ma_kieu_thue),
    foreign key (ma_loai_dich_vu) references loai_dich_vu (ma_loai_dich_vu)
);
insert into dich_vu(ten_dich_vu, dien_tich, chi_phi_thue, so_nguoi_toi_da, ma_kieu_thue, ma_loai_dich_vu,
 tieu_chuan_phong, mo_ta_tien_nghi_khac, dien_tich_ho_boi, so_tang) values
 ('Villa Beach Front',	25000,'10000000',10,3,1,'vip','Có hồ bơi',500,4),
 ('House Princess 01',14000,'5000000',7,2,2,'vip','Có thêm bếp nướng',	null,3),
 ('Room Twin 01',5000,'1000000',2,4,3,'normal','Có tivi',null,null), 
 ('Villa No Beach Front',22000,'9000000',8,3,1,'normal','Có hồ bơi',300,3),
 ('House Princess 02',10000,'4000000',5,3,2,'normal','Có thêm bếp nướng',null,2), 
 ('Room Twin 02',3000,'900000',2,4,3,'normal','Có tivi',null,null);

create table dich_vu_di_kem
(
    ma_dich_vu_di_kem    int primary key not null auto_increment,
    ten_dich_vu_di_kem  varchar(45) not null,
    gia               double not null,
    don_vi                varchar(10) not null,
    trang_thai varchar(45)
);

insert into dich_vu_di_kem(ten_dich_vu_di_kem, gia, don_vi, trang_thai) values 
('Karaoke',10000,'giờ','tiện nghi, hiện tại'),
('Thuê xe máy',10000,'chiếc','hỏng 1 xe'), 
('Thuê xe đạp',20000,'chiếc','tốt'),
('Buffet buổi sáng',15000,'suất','đầy đủ đồ ăn, tráng miệng'),
('Buffet buổi trưa',90000,'suất','đầy đủ đồ ăn, tráng miệng'),
('Buffet buổi tối',16000,'suất','đầy đủ đồ ăn, tráng miệng');

create table hop_dong
(
    ma_hop_dong int primary key auto_increment not null,
    ngay_lam_hop_dong    datetime not null,
    ngay_ket_thuc datetime not null,
    tien_dat_coc  double not null,
    ma_nhan_vien  int,
    ma_khach_hang    int,
    ma_dich_vu    int,
    foreign key (ma_nhan_vien) references nhan_vien (ma_nhan_vien),
    foreign key (ma_khach_hang) references khach_hang (ma_khach_hang),
    foreign key (ma_dich_vu) references dich_vu (ma_dich_vu)
);
insert into hop_dong(ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu) values 
('2020-12-08','2020-12-08',0,3,1,3),
('2020-07-14','2020-07-21',200000,2,3,1),
('2021-03-15','2021-03-17',50000,3,4,2),
('2021-01-14','2021-01-18',100000,7,5,5),
('2021-07-14','2021-07-15',0,7,2,6),
('2021-06-01','2021-06-03',0,7,7,6),
('2021-09-02','2021-09-05',100000,7,4,4),
('2021-06-17','2021-06-18',150000,3,4,1),
('2020-11-19','2020-11-19',0,3,4,3),
('2021-04-12','2021-04-14',0,10,3,5),
('2021-04-25','2021-04-25',0,2,2,1),
('2021-05-25','2021-05-27',0,7,10,1);
create table hop_dong_chi_tiet
(
    ma_hop_dong_chi_tiet int primary key not null auto_increment,
    ma_hop_dong        int,
    ma_dich_vu_di_kem   int,
    so_luong             int not null,
    foreign key (ma_hop_dong) references hop_dong (ma_hop_dong),
    foreign key (ma_dich_vu_di_kem) references dich_vu_di_kem (ma_dich_vu_di_kem)
);
insert into hop_dong_chi_tiet(ma_hop_dong, ma_dich_vu_di_kem, so_luong) values
(2,4,5),
(2,5,8),
(2,6,15),
(3,1,1),
(3,2,11),
(1,3,1),
(1,2,2),
(12,2,2);
# 2. -- Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select *
from nhan_vien
where ((substring_index(ho_ten,' ',-1)) like 'T%' or'H%' or'K%'  ) and LENGTH(ho_ten) <= 50;

# 3. -- Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select *
from khach_hang
where (year(curdate()) - year(ngay_sinh) >= 18
    and year(curdate()) - year(ngay_sinh) <= 50)
    and (dia_chi like '%Đà Nẵng%'
   or dia_chi like '%Quảng Trị%');

# 4. -- Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần
select khach_hang.ho_ten, loai_khach.ten_loai_khach, count(khach_hang.ma_khach_hang)
from khach_hang
		join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
		join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
where loai_khach.ten_loai_khach = 'Diamond'
group by khach_hang.ma_khach_hang
order by count(khach_hang.ma_khach_hang) asc;
# 5. -- Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
select khach_hang.ma_khach_hang,
       khach_hang.ho_ten,
       loai_khach.ten_loai_khach,
       hop_dong.ma_hop_dong,
       dich_vu.ten_dich_vu,
       hop_dong.ngay_lam_hop_dong,
       hop_dong.ngay_ket_thuc,
       sum(dich_vu.chi_phi_thue +coalesce( dich_vu_di_kem.don_vi * dich_vu_di_kem.gia ,
0)) as tong
from khach_hang 
         left join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
         left join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
         left join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
         left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
         left join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
         group by khach_hang.ma_khach_hang;
# 6.Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại
# Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
select dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
from dich_vu
         inner join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
         inner join hop_dong on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
where dich_vu.ma_dich_vu not in (select dich_vu.ma_dich_vu
                           from hop_dong 
                                    inner join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
                           where year(hop_dong.ngay_lam_hop_dong) = 2021
                             and (month(hop_dong.ngay_lam_hop_dong) = 1 or month(hop_dong.ngay_lam_hop_dong) = 2 or month(hop_dong.ngay_lam_hop_dong) = 3)
                           group by dich_vu.ma_dich_vu)
group by dich_vu.ma_dich_vu;

# 7.Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue,
# tenLoaiDichVu của tất cả các loại dịch vụ đã từng được Khách
# hàng đặt phòng trong năm 2020 nhưng chưa từng được Khách hàng đặt phòng trong năm 2021.

select dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.so_nguoi_toi_da, dich_vu.chi_phi_thue,loai_dich_vu.ten_loai_dich_vu
from dich_vu
         inner join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
         inner join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
         inner join khach_hang on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
where year(hop_dong.ngay_lam_hop_dong) = 2020
group by dich_vu.ma_dich_vu;

# 8.Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
# Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
# cach 1:
select distinct ho_ten
from khach_hang;
# cách 2:
select ho_ten
from khach_hang
group by ho_ten ;
# cách 3:
select ho_ten
from khach_hang
union
select ho_ten
from khach_hang;

# 9.Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019
# thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(hop_dong.ngay_lam_hop_dong) as 'tháng', count(distinct hop_dong.ma_khach_hang) as so_khach_thue
from hop_dong
         inner join khach_hang on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
where year(hop_dong.ngay_lam_hop_dong)=2021
group by month(hop_dong.ngay_lam_hop_dong);

# 10.Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm.
select hop_dong.ma_hop_dong, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, hop_dong.tien_dat_coc, count(hop_dong_chi_tiet.ma_hop_dong_chi_tiet) as so_luong_DV_di_kem
from hop_dong
         inner join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
         inner join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
group by hop_dong.ma_hop_dong;
  
# 11.Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có
# TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem, dich_vu_di_kem.gia, dich_vu_di_kem.don_vi, dich_vu_di_kem.trang_thai
from dich_vu_di_kem
         inner join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
         inner join hop_dong on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
         inner join khach_hang on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
         inner join loai_khach on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
where loai_khach.ten_loai_khach = 'Diamond'
  and (khach_hang.dia_chi like '%Vinh%' or khach_hang.dia_chi like '%Quảng Ngãi%');
  
  # 12.Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu,
# SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các
# dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng
# đặt vào 6 tháng đầu năm 2021.
select hop_dong.ma_hop_dong,
       nhan_vien.ho_ten,
       khach_hang.ho_ten,
       khach_hang.so_dien_thoai,
       dich_vu.ten_dich_vu,
       count(hop_dong_chi_tiet.ma_hop_dong_chi_tiet) as so_luong_DV_di_kem,
       sum(hop_dong.tien_dat_coc) as tien_dat_coc
from hop_dong
         inner join khach_hang on khach_hang.ma_khach_hang= hop_dong.ma_khach_hang
         inner join nhan_vien on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
         inner join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
         inner join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
         inner join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
where (month(hop_dong.ngay_lam_hop_dong) = 10 or month(hop_dong.ngay_lam_hop_dong) = 11 or month(hop_dong.ngay_lam_hop_dong) = 12)
  and month(hop_dong.ngay_lam_hop_dong) in
      (select month(hop_dong.ngay_lam_hop_dong) from hop_dong where year(hop_dong.ngay_lam_hop_dong) = 2020)
  and month(hop_dong.ngay_lam_hop_dong) not in (select month(hop_dong.ngay_lam_hop_dong)
                                   from hop_dong
                                   where (month(hop_dong.ngay_lam_hop_dong) = 1 or month(hop_dong.ngay_lam_hop_dong) = 2 or month(hop_dong.ngay_lam_hop_dong) = 3 or month(hop_dong.ngay_lam_hop_dong) = 4 or month(hop_dong.ngay_lam_hop_dong) = 5 or month(hop_dong.ngay_lam_hop_dong) = 6)
                                   group by dich_vu.ma_dich_vu)
group by dich_vu.ma_dich_vu , khach_hang.ma_khach_hang;

# 13.Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.
select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem, dich_vu_di_kem.gia, dich_vu_di_kem.don_vi, dich_vu_di_kem.trang_thai , count(dich_vu_di_kem.ma_dich_vu_di_kem)
from dich_vu_di_kem
         inner join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
         inner join hop_dong on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
         inner join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
group by dich_vu_di_kem.ma_dich_vu_di_kem
having count(dich_vu_di_kem.ma_dich_vu_di_kem) = (select max(dich_vu_di_kem.ma_dich_vu_di_kem)
                                     from (select count(dich_vu_di_kem.ma_dich_vu_di_kem) as count
                                           from dich_vu_di_kem
                                                    inner join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
													inner join hop_dong on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
													inner join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
                                           group by dich_vu_di_kem.ma_dich_vu_di_kem)
);

# 14.Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
# Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.
select hop_dong.ma_hop_dong, loai_dich_vu.ten_loai_dich_vu, dich_vu_di_kem.ten_dich_vu_di_kem, count(hop_dong_chi_tiet.so_luong) as so_lan_su_dung
from dich_vu_di_kem
         inner join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
         inner join hop_dong on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
         inner join khach_hang on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
         inner join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
         inner join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
         inner join loai_dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
		
where dich_vu_di_kem.ma_dich_vu_di_kem in (select ma_dich_vu_di_kem from hop_dong_chi_tiet group by (ma_dich_vu_di_kem) having count(ma_dich_vu_di_kem)=1)
group by dich_vu_di_kem.ma_dich_vu_di_kem; 

# 15.Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai,
# DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
select nhan_vien.ma_nhan_vien,
       nhan_vien.ho_ten,
       trinh_do.ten_trinh_do,
       vi_tri.ten_vi_tri,
       nhan_vien.so_dien_thoai,
       nhan_vien.dia_chi,
       count(hop_dong.ma_hop_dong) as so_luong_hop_dong
from hop_dong
         inner join nhan_vien on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
         inner join trinh_do on trinh_do.ma_trinh_do = nhan_vien.ma_trinh_do
         inner join vi_tri on vi_tri.ma_vi_tri = nhan_vien.ma_vi_tri
where hop_dong.ma_nhan_vien in (select hop_dong.ma_nhan_vien
                     from hop_dong
                              inner join nhan_vien on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
                     where year(hop_dong.ngay_lam_hop_dong) >= 2020
                       and year(hop_dong.ngay_ket_thuc) <= 2021
                     group by hop_dong.ma_nhan_vien
                     having count(hop_dong.ma_hop_dong) <= 3)
group by hop_dong.ma_nhan_vien;

# 16.Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
delete
from nhan_vien
where nhan_vien.ma_nhan_vien not in (select ma_nhan_vien
                          from (select ma_nhan_vien as id
                                from hop_dong 
                                where year(hop_dong.ngay_lam_hop_dong) between 2019 and 2021
                                group by hop_dong.ma_nhan_vien) as c);

# 17.Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, chỉ cập nhật những
# khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
update khach_hang
set ma_khach_hang=(select loai_khach.ma_loai_khach
                         from loai_khach
                         where ten_loai_khach = 'Diamond')
where ma_khach_hang in (select ma_khach_hang
                         from (select hop_dong.ma_khach_hang
                               from hop_dong
                                        inner join khach_hang on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
                                        inner join loai_khach on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
                                        inner join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
                                        inner join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
                                        inner join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu 
                               where year(hop_dong.ngay_lam_hop_dong) = 2021
                                 and loai_khach.ten_loai_khach = 'Vip'
                               group by hop_dong.ma_khach_hang
                               having sum(dich_vu.chi_phi_thue + hop_dong_chi_tiet.so_luong* dich_vu_di_kem.gia)>10000000) as ct2);

# 18.Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).

SET GLOBAL FOREIGN_KEY_CHECKS=0;
     
 create view khach_hang_can_xoa as
 select ma_khach_hang
                      from (select hop_dong.ma_khach_hang
                            from hop_dong
                                     left join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
                            where year(hop_dong.ngay_lam_hop_dong) < 2021) as c2;
   -- set điều kiện cho ma_khach_hang bên hợp đồng từ not nut thành cho phép null   
   alter table hop_dong modify ma_khach_hang int;
   -- xóa foreign key cũ và tạo foreign key mới với điều kiện chuyển về null khi bị xóa
   alter table hop_dong drop foreign key hop_dong_ibfk_2;
   alter table hop_dong add constraint fk_ma_khach_hang foreign key (ma_khach_hang) references khach_hang(ma_khach_hang) on delete set null;	
   -- xóa, bên hợp đồng vẫn không mất dữ liệu hợp đồng
   delete from khach_hang where ma_khach_hang in (select ma_khach_hang from khach_hang_can_xoa);
# 19.Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
 create view v_dich_vu_di_kem as
 select ten_dich_vu_di_kem,ma_dich_vu_di_kem,gia
 from
(select dich_vu_di_kem.ten_dich_vu_di_kem, dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.gia, count(hop_dong.ma_hop_dong)as so_lan_su_dung from dich_vu_di_kem join hop_dong_chi_tiet on
 hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem join hop_dong on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong group by hop_dong.ma_hop_dong having so_lan_su_dung>2) as t;   
 update dich_vu_di_kem
 set gia = gia*2 where dich_vu_di_kem.ma_dich_vu_di_kem in (select ma_dich_vu_di_kem from v_dich_vu_di_kem);
# 20.Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, thông tin hiển thị
# bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.
select ma_nhan_vien as ma_so, ho_ten, ngay_sinh, so_dien_thoai, email, dia_chi
from nhan_vien
union
select ma_khach_hang, ho_ten, ngay_sinh, so_dien_thoai, email, dia_chi
from khach_hang;
					
# 21.Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có địa chỉ
# là “Hải Châu” và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ  với ngày lập hợp đồng là “12/12/2019”
create view v_nhan_vien as
select ma_nhan_vien, ho_ten, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, ma_vi_tri, ma_trinh_do, ma_bo_phan
from nhan_vien
where dia_chi like 'Đà Nẵng'
  and nhan_vien.ma_nhan_vien in (select hop_dong.ma_nhan_vien
                      from hop_dong
                      where hop_dong.ngay_lam_hop_dong = '2020-07-14'
                      group by hop_dong.ma_nhan_vien);
select * from v_nhan_vien;
# 22.Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các
# Nhân viên được nhìn thấy bởi khung nhìn này.
update v_nhan_vien v
set v.dia_chi='Liên Chiểu'
where v.ma_nhan_vien;
# 23.Tạo Store procedure p_xoa_khach_hang Dùng để xóa thông tin của một Khách hàng nào đó với Id Khách hàng
# được truyền vào như là 1 tham số của p_xoa_khach_hang
delimiter //
create procedure p_xoa_khach_hang(ma_khach_hang int)
begin
    delete
    from khach_hang
    where ma_khach_hang = khach_hang.ma_khach_hang;
end;
delimiter ;
set foreign_key_checks = 0;
call p_xoa_khach_hang(2);
set foreign_key_checks = 1;
