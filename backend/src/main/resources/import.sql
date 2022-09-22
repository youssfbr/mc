INSERT INTO category (name) VALUES ('Computing');
INSERT INTO category (name) VALUES ('Office');

INSERT INTO product (name, price) VALUES ('Computer', 2000.0);
INSERT INTO product (name, price) VALUES ('Printer', 800.0);
INSERT INTO product (name, price) VALUES ('Mouse', 80.0);

INSERT INTO product_category (product_id, category_id) VALUES (1, 1);
INSERT INTO product_category (product_id, category_id) VALUES (2, 1);
INSERT INTO product_category (product_id, category_id) VALUES (2, 2);
INSERT INTO product_category (product_id, category_id) VALUES (3, 1);