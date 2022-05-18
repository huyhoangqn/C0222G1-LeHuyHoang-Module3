create database demo;
use demo;
create table products(
id int primary key auto_increment not null,
productCode varchar(50),
productName varchar(50),
productPrice float,
productAmount int,
productDescription varchar(50),
productStatus varchar(50)
);

insert into products (productCode, productName, productPrice, productAmount, productDescription, productStatus) values ('C001', 'Bánh mì',3000, 2, 'Thơm, ngon', 'Còn hàng' ),
('C002', 'Chân giò ',20000, 10, 'béo', 'hết hàng' ),('C003', 'Bún',5000, 3, 'Mềm, dẻo', 'Còn hàng' ),('C004', 'Gà ',35000, 5, 'Giòn, thơm ', 'hết hàng ' );

create unique index i_productCode on products(productCode);
create index  i_productPrice on products(productName,productPrice);

explain select productCode from products; 

create view w_products as
select productCode, productName, productPrice, productStatus from products;
select * from w_products;

update w_products set productName = 'Bánh bao ' where productName = 'Chân giò';

delete from w_products where productName='Chân giò';

delimiter $$
create procedure products()
begin
select * from products;
end $$
delimiter ;
call products();

delimiter $$
create procedure product_add(in
pCode varchar(50),
pName varchar(50),
pPrice float,
pAmount int,
pDescription varchar(50),
pStatus varchar(50))
begin
insert into products(productCode, productName, productPrice, productAmount, productDescription, productStatus) values(pCode, pName, pPrice, pAmount, pDescription,pStatus);
end$$
delimiter ;

call  product_add('C005', 'Vịt ',35000, 9, 'Giòn, thơm ', 'Còn hàng ');

delimiter $$
create procedure product_edit(in
iD int,
pCode varchar(50),
pName varchar(50),
pPrice float,
pAmount int,
pDescription varchar(50),
pStatus varchar(50)
)
begin 
update products p set p.id = iD, p.productCode =pCode , p.productName= pName, p.productPrice = pPrice, p.productAmount = pAmount, p.productDescription = pDescription, p.productStatus = pStatus
where iD = p.id; 
end $$
delimiter ;
call product_edit (4,'C004', 'Gà ',35000, 5, 'Giòn, thơm ', 'hết hàng' );

delimiter $$
create procedure product_delete(in
iD int
)
begin 
delete from products p where p.id = iD;
end $$
delimiter ;
call product_delete (4);