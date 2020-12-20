CREATE TABLE IF NOT EXISTS product
(
    product_id bigserial PRIMARY KEY,
    product_name varchar(128) NOT NULL UNIQUE,
    product_info text NOT NULL
);


