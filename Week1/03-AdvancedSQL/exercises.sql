-- Advanced SQL — Exercises

-- ============ SCHEMA ============
DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
    name        VARCHAR(50),
    city        VARCHAR(50)
);

CREATE TABLE employees (
    emp_id      INT PRIMARY KEY,
    name        VARCHAR(50),
    manager_id  INT,               -- self-reference for hierarchy queries
    department  VARCHAR(50),
    salary      DECIMAL(10,2)
);

CREATE TABLE products (
    product_id  INT PRIMARY KEY,
    name        VARCHAR(50),
    price       DECIMAL(10,2),
    category    VARCHAR(50)
);

CREATE TABLE orders (
    order_id     INT PRIMARY KEY,
    customer_id  INT,
    order_date   DATE,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

CREATE TABLE order_items (
    order_item_id INT PRIMARY KEY,
    order_id      INT,
    product_id    INT,
    quantity      INT,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- ============ SEED DATA ============
INSERT INTO customers VALUES
 (1,'Aarav','Pune'),(2,'Priya','Mumbai'),(3,'Rohan','Pune'),
 (4,'Sneha','Nagpur'),(5,'Kabir','Mumbai');

INSERT INTO employees VALUES
 (1,'Anita',NULL,'Executive',150000),
 (2,'Vikram',1,'Engineering',95000),
 (3,'Meera',1,'Sales',80000),
 (4,'Arjun',2,'Engineering',70000),
 (5,'Divya',2,'Engineering',72000),
 (6,'Sanjay',3,'Sales',60000);

INSERT INTO products VALUES
 (1,'Laptop',55000,'Electronics'),
 (2,'Mouse',500,'Electronics'),
 (3,'Desk',8000,'Furniture'),
 (4,'Chair',4500,'Furniture'),
 (5,'Monitor',12000,'Electronics');

INSERT INTO orders VALUES
 (1,1,'2026-01-05'),(2,1,'2026-02-10'),(3,2,'2026-01-20'),
 (4,3,'2026-03-01'),(5,4,'2026-03-15'),(6,2,'2026-04-02');

INSERT INTO order_items VALUES
 (1,1,1,1),(2,1,2,2),(3,2,5,1),(4,3,3,1),
 (5,3,4,4),(6,4,2,3),(7,5,1,1),(8,6,5,2);

