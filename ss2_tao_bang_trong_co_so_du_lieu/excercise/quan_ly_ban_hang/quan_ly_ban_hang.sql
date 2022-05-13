create database quanlybanhang;
use quanlybanhang;
create table customer(
	customer_id int auto_increment primary key,
    customer_name varchar(50) not null,
    customer_age tinyint not null check (customer_age > 0)
);

create table `order`(
	order_id int auto_increment primary key,
    order_date datetime not null,
    order_total_price int not null check(order_total_price > 0),
    customer_id int,
    foreign key (customer_id) references customer(customer_id)
);

create table product(
	product_id int auto_increment primary key,
    product_name varchar(50) not null,
    product_price int not null check(product_price > 0)
);

create table order_detail(
	order_id int,
    product_id int,
    order_detail_quantity int,
    primary key(order_id, product_id),
    foreign key(order_id) references `order`(order_id),
    foreign key(product_id) references product(product_id)
);