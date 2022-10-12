INSERT INTO category (name, created_at) VALUES ('Computing', now());
INSERT INTO category (name, created_at) VALUES ('Office', now());

INSERT INTO product (name, price) VALUES ('Computer', 2000.0);
INSERT INTO product (name, price) VALUES ('Printer', 800.0);
INSERT INTO product (name, price) VALUES ('Mouse', 80.0);

INSERT INTO product_category (product_id, category_id) VALUES (1, 1);
INSERT INTO product_category (product_id, category_id) VALUES (2, 1);
INSERT INTO product_category (product_id, category_id) VALUES (2, 2);
INSERT INTO product_category (product_id, category_id) VALUES (3, 1);

INSERT INTO state (name) VALUES ('Ceará');
INSERT INTO state (name) VALUES ('Minas Gerais');
INSERT INTO state (name) VALUES ('São Paulo');

INSERT INTO city (name, state_id) VALUES ('Fortaleza', 1);
INSERT INTO city (name, state_id) VALUES ('Uberlândia', 2);
INSERT INTO city (name, state_id) VALUES ('São Paulo', 3);
INSERT INTO city (name, state_id) VALUES ('Campinhas', 3);