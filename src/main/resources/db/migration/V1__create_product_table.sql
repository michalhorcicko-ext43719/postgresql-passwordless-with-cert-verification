CREATE SEQUENCE product_seq START 1 INCREMENT 50;
CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
