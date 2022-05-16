create database quanlybanhang1;
use quanlybanhang1;
create table customer(
	customer_id int auto_increment primary key,
    customer_name varchar(50) not null,
    customer_age tinyint not null check (customer_age > 0)
);

create table `order`(
	order_id int auto_increment primary key,
    order_date datetime not null,
    order_total_price int,
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


insert into customer value (1, 'Minh Quan', 10), (2, 'Ngoc Oanh', 20), (3, 'Hong Ha', 50), (4, 'Van Ty', 55); 
insert into `order`(order_id, customer_id, order_date) value (1, 1, '2006-03-21'), (2,2,'2006-03-23'), (3,1,'200-03-16');
insert into product value (1,'May Giat', 3),(2, 'Tu Lanh', 5),(3,'Dieu Hoa', 7),(4,'Quat',1),(5,'Bep Dien',2);
insert into order_detail value (1,1,3),(1,3,7),(1,4,2),(2,1,1),(3,1,8),(2,5,4),(2,3,3);


select order_id, order_date, order_total_price from `order`;

select c.customer_name, p.product_name from customer c inner join `order` o on c.customer_id = o.customer_id
inner join order_detail od on o.order_id = od.order_id
inner join product p on p.product_id = od.product_id;

select c. customer_name from customer c left join `order` o on c.customer_id = o.customer_id where o.customer_id is null;
SELECT 
    o.order_id ,
    o.order_date,
    sum(od.order_detail_quantity * p.product_price)
FROM
    `order` o
        JOIN
    order_detail od ON o.order_id = od.order_id
        JOIN
    product p ON p.product_id = od.product_id
GROUP BY o.order_id;




