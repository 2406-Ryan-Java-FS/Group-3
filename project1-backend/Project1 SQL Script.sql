-- Create the user table
create table users (
        token_expires_on date,
        token_issued_on date,
        user_id serial,
        name varchar(255),
        password varchar(255),
        role varchar(255),
        token_id varchar(255),
        token_password varchar(255),
        primary key (user_id)
    );

    -- Create the categories table
    create table categories (
    	id serial primary key,
    	name varchar(50) not null
    );

-- Create the products table
create table products (
	id serial primary key,
	name varchar(100) not null,
	description text,
	price decimal(10,2) not null,
	category_id int,
	foreign key (category_id) references categories(id)
);

-- Create the orders table
create table orders (
	id serial primary key,
	user_id int not null,
	status varchar(50) not null,
	create_at timestamp default current_timestamp,
	foreign key (user_id) references users(id)
); 

-- Create the orders_item table
create table order_item (
	id serial primary key,
	order_id int not null,
	product_id int not null,
	quantity int not null,
	foreign key (order_id) references orders(id),
	foreign key (product_id) references products(id)
);

select * from users;
select * from products;
select * from categories;
select * from orders;
select * from order_item;