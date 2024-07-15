-- Create the user table
create table users (
        token_expires_on date,
        token_issued_on date,
        user_id serial,
        name varchar(255),
        password varchar(255),
        role varchar(255),
        secret_information varchar(255),
        token_id varchar(255),
        token_password varchar(255),
        money int,
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

    -- Create the addresses table
    create table addresses (
    	address_id serial primary key,
    	address varchar(250) not null,
	    user_id int not null,
	    foreign key (user_id) references users(user_id)
    );

-- Create the orders table
create table orders (
	id serial primary key,
	user_id int not null,
	status varchar(50) not null,
	address_id int not null,
	create_at timestamp default current_timestamp,
	foreign key (user_id) references users(user_id),
	foreign key (address_id) references addresses(address_id)
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








-----INSERT INTO USERS
INSERT INTO users (token_expires_on, token_issued_on, name, password, role, secret_information, token_id, token_password, money)
VALUES
('2024-12-31', '2024-01-01', 'ola', 'ola123password', 'admin', 'test', 'token123', 'tokenpass123', 10000),
('2024-12-31', '2024-01-02', 'Bob', 'bob456password', 'user', 'test','token124', 'tokenpass124', 13),
('2024-12-31', '2024-01-03', 'jeet', 'jeet789password', 'user', 'test','token125', 'tokenpass125', 166),
('2024-12-31', '2024-01-04', 'Diana', 'diana012password', 'user', 'test','token126', 'tokenpass126', 389),
('2024-12-31', '2024-01-05', 'Eve', 'eve345password', 'admin', 'test','token127', 'tokenpass127', 8098),
('2024-12-31', '2024-01-06', 'Eric', 'eric678password', 'user', 'test','token128', 'tokenpass128', 2),
('2024-12-31', '2024-01-07', 'Grace', 'grace901password', 'user', 'test','token129', 'tokenpass129', 3999),
('2024-12-31', '2024-01-08', 'Heidi', 'heidi234password', 'user', 'test','token130', 'tokenpass130', 2000),
('2024-12-31', '2024-01-09', 'Ivan', 'ivan567password', 'admin', 'test','token131', 'tokenpass131', 3000),
('2024-12-31', '2024-01-10', 'Judy', 'judy890password', 'user', 'test','token132', 'tokenpass132', 4000);


-----INSERT INTO categories
INSERT INTO categories (name)
VALUES
('Electronics'),
('Books'),
('Clothing'),
('Home & Kitchen'),
('Sports & Outdoors'),
('Health & Personal Care'),
('Toys & Games'),
('Automotive'),
('Beauty'),
('Grocery');


-----INSERT INTO products
INSERT INTO products (name, description, price, category_id)
VALUES
('Smartphone', 'Latest model smartphone with advanced features', 699.99, 1),
('Novel', 'A bestselling fiction novel', 15.99, 2),
('T-Shirt', 'Comfortable cotton t-shirt in various sizes', 9.99, 3),
('Blender', 'High-speed blender for smoothies and shakes', 49.99, 4),
('Yoga Mat', 'Non-slip yoga mat for all types of exercises', 19.99, 5),
('Vitamins', 'Multivitamins for daily health', 12.99, 6),
('Board Game', 'Fun and engaging board game for all ages', 29.99, 7),
('Car Battery', 'Long-lasting car battery with high performance', 89.99, 8),
('Lipstick', 'Matte finish lipstick in various shades', 14.99, 9),
('Organic Apples', 'Fresh organic apples from local farms', 3.99, 10);

-----INSERT INTO addresses
INSERT INTO addresses (address, user_id)
VALUES
('1234 best way', 1),
('1235 best st', 2),
('1212 north way', 1),
('1231 best way', 4),
('12 east way', 1),
('13 best way', 3);


-----INSERT INTO orders
INSERT INTO orders (user_id, status, address_id)
VALUES
(1, 'pending', 2),
(2, 'shipped', 1),
(3, 'delivered', 5),
(4, 'pending', 2),
(5, 'canceled', 4),
(6, 'shipped', 2),
(7, 'delivered', 1),
(8, 'returned', 3),
(9, 'pending', 2),
(10, 'shipped', 2);



-----INSERT INTO order_item
INSERT INTO order_item (order_id, product_id, quantity)
VALUES
(1, 1, 2),
(1, 2, 1),
(2, 3, 1),
(2, 4, 3),
(3, 5, 1),
(4, 6, 2),
(5, 7, 1),
(6, 8, 1),
(7, 9, 2),
(8, 10, 5);


-- Select statements
select * from users;
select * from products;
select * from categories;
select * from orders;
select * from order_item;
select * from addresses;


---Drop Statements
DROP TABLE IF EXISTS users, products, categories, addresses, orders,order_item;
