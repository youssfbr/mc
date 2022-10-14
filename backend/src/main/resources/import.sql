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

INSERT INTO client (name, email, cpf_or_cnpj, client_type) VALUES ('Alisson Youssf', 'youssfbr@gmail.com', '39379812377', 1);
INSERT INTO phone (phones, client_id) VALUES ('(85)987654321', 1);
INSERT INTO phone (phones, client_id) VALUES ('(85)98763434521', 1);

INSERT INTO client (name, email, cpf_or_cnpj, client_type) VALUES ('Maria Silva', 'maria@gmail.com', '36378912377', 1);
INSERT INTO phone (phones, client_id) VALUES ('27363323', 2);
INSERT INTO phone (phones, client_id) VALUES ('93838393', 2);

INSERT INTO address (patio, number, complement, district, cep, city_id, client_id) VALUES ('Rua das Oliveiras', '846', 'Perto de algo', 'Centro', '12345678', 1, 1);
INSERT INTO address (patio, number, complement, district, cep, city_id, client_id) VALUES ('Rua das Flores', '300', 'Apto 303', 'Jardim', '38220834', 2, 2);
INSERT INTO address (patio, number, complement, district, cep, city_id, client_id) VALUES ('Avenida Matos', '105', 'Sala 800', 'Centro', '38777012', 3, 2);


