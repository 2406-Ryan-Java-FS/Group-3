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
CREATE TABLE orders (
    id serial primary key,
    user_id int not null,
    status varchar(50) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp,
    foreign key (user_id) references users(user_id)
);



-- Create the orders_item table
CREATE TABLE order_item (
    id serial PRIMARY KEY,
    order_id int NOT NULL,
    product_id int NOT NULL,
    quantity int NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);




-- Create the carts table
CREATE TABLE carts (
    cart_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);


-----INSERT INTO USERS
INSERT INTO users (token_expires_on, token_issued_on, name, password, role, token_id, token_password)
VALUES 
('2024-12-31', '2024-01-01', 'ola', 'ola123password', 'admin', 'token123', 'tokenpass123'),
('2024-12-31', '2024-01-02', 'Bob', 'bob456password', 'user', 'token124', 'tokenpass124'),
('2024-12-31', '2024-01-03', 'jeet', 'jeet789password', 'user', 'token125', 'tokenpass125'),
('2024-12-31', '2024-01-04', 'Diana', 'diana012password', 'user', 'token126', 'tokenpass126'),
('2024-12-31', '2024-01-05', 'Eve', 'eve345password', 'admin', 'token127', 'tokenpass127'),
('2024-12-31', '2024-01-06', 'Eric', 'eric678password', 'user', 'token128', 'tokenpass128'),
('2024-12-31', '2024-01-07', 'Grace', 'grace901password', 'user', 'token129', 'tokenpass129'),
('2024-12-31', '2024-01-08', 'Heidi', 'heidi234password', 'user', 'token130', 'tokenpass130'),
('2024-12-31', '2024-01-09', 'Ivan', 'ivan567password', 'admin', 'token131', 'tokenpass131'),
('2024-12-31', '2024-01-10', 'Judy', 'judy890password', 'user', 'token132', 'tokenpass132');


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


-----INSERT INTO orders
INSERT INTO orders (user_id, status, created_at, updated_at) VALUES
(1, 'Pending', current_timestamp, current_timestamp),
(2, 'Shipped', current_timestamp, current_timestamp),
(3, 'Delivered', current_timestamp, current_timestamp),
(4, 'Cancelled', current_timestamp, current_timestamp),
(5, 'Processing', current_timestamp, current_timestamp),
(6, 'Pending', current_timestamp, current_timestamp),
(7, 'Shipped', current_timestamp, current_timestamp),
(8, 'Delivered', current_timestamp, current_timestamp),
(9, 'Returned', current_timestamp, current_timestamp),
(10, 'Pending', current_timestamp, current_timestamp);





-----INSERT INTO order_item
INSERT INTO order_item (order_id, product_id, quantity) VALUES
(1, 1, 2),
(2, 2, 1),
(3, 3, 5),
(4, 4, 3),
(5, 5, 4),
(6, 1, 1),
(7, 2, 2),
(8, 3, 3),
(9, 4, 4),
(10, 5, 5);




INSERT INTO carts (user_id, product_id, quantity) VALUES
(1, 1, 2),  -- User 1, Product 1 (Laptop), Quantity 2
(1, 2, 1),  -- User 1, Product 2 (Smartphone), Quantity 1
(1, 3, 5),  -- User 1, Product 3 (Novel), Quantity 5
(2, 2, 3),  -- User 2, Product 2 (Smartphone), Quantity 3
(2, 4, 4),  -- User 2, Product 4 (T-Shirt), Quantity 4
(2, 1, 1),  -- User 2, Product 1 (Laptop), Quantity 1
(3, 3, 2),  -- User 3, Product 3 (Novel), Quantity 2
(3, 4, 6),  -- User 3, Product 4 (T-Shirt), Quantity 6
(3, 2, 7),  -- User 3, Product 2 (Smartphone), Quantity 7
(3, 1, 3);  -- User 3, Product 1 (Laptop), Quantity 3
ALTER TABLE orders
ADD COLUMN updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP;


-- Select statements
select * from users;
select * from products;
select * from categories;
select * from orders;
select * from order_item;

---Drop Statements
DROP TABLE IF EXISTS users,  products,categories, orders,order_item,carts;

SELECT * FROM project1.users WHERE user_id = 5;
ALTER TABLE orders
ADD COLUMN updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP;



ALTER TABLE orders ADD COLUMN total_amount DECIMAL(10, 2);
