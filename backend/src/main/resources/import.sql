INSERT INTO tb_category (name, created_at) VALUES ('Computing', now());
INSERT INTO tb_category (name, created_at) VALUES ('Office', now());

INSERT INTO tb_product (name, price) VALUES ('Computer', 2000.0);
INSERT INTO tb_product (name, price) VALUES ('Printer', 800.0);
INSERT INTO tb_product (name, price) VALUES ('Mouse', 80.0);

INSERT INTO tb_product_category (product_id, category_id) VALUES (1, 1);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 1);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (3, 1);

INSERT INTO tb_state (name) VALUES ('Ceará');
INSERT INTO tb_state (name) VALUES ('Minas Gerais');
INSERT INTO tb_state (name) VALUES ('São Paulo');

INSERT INTO tb_city (name, state_id) VALUES ('Fortaleza', 1);
INSERT INTO tb_city (name, state_id) VALUES ('Uberlândia', 2);
INSERT INTO tb_city (name, state_id) VALUES ('São Paulo', 3);
INSERT INTO tb_city (name, state_id) VALUES ('Campinhas', 3);

INSERT INTO tb_client (name, email, cpf_or_cnpj, client_type) VALUES ('Alisson Youssf', 'youssfbr@gmail.com', '39379812377', 1);
INSERT INTO tb_phone (phones, client_id) VALUES ('(85)987654321', 1);
INSERT INTO tb_phone (phones, client_id) VALUES ('(85)98763434521', 1);

INSERT INTO tb_client (name, email, cpf_or_cnpj, client_type) VALUES ('Maria Silva', 'maria@gmail.com', '36378912377', 1);
INSERT INTO tb_phone (phones, client_id) VALUES ('27363323', 2);
INSERT INTO tb_phone (phones, client_id) VALUES ('93838393', 2);

INSERT INTO tb_address (patio, number, complement, district, cep, city_id, client_id) VALUES ('Rua das Oliveiras', '846', 'Perto de algo', 'Centro', '12345678', 1, 1);
INSERT INTO tb_address (patio, number, complement, district, cep, city_id, client_id) VALUES ('Rua das Flores', '300', 'Apto 303', 'Jardim', '38220834', 2, 2);
INSERT INTO tb_address (patio, number, complement, district, cep, city_id, client_id) VALUES ('Avenida Matos', '105', 'Sala 800', 'Centro', '38777012', 3, 2);

INSERT INTO tb_order (moment, client_id, delivery_address_id) VALUES ('2017-09-30T13:32:00Z', 2, 2);
INSERT INTO tb_order (moment, client_id, delivery_address_id) VALUES ('2017-10-10T22:35:00Z', 2, 3);

INSERT INTO tb_payment (order_id, state_payment) VALUES (1, 2);
INSERT INTO tb_payment (order_id, state_payment) VALUES (2, 1);

INSERT INTO tb_card_payment (order_id, number_payments) VALUES (1, 6);

INSERT INTO tb_ticket_payment (order_id, expiration_date) VALUES (2, '2017-10-20');

INSERT INTO tb_order_item (discount, price, quantity, product_id, order_id) VALUES (0.00, 2000.0, 1, 1, 1);
INSERT INTO tb_order_item (discount, price, quantity, product_id, order_id) VALUES (0.00, 80.0, 2, 3, 1);
INSERT INTO tb_order_item (discount, price, quantity, product_id, order_id) VALUES (100.00, 800.0, 1, 2, 2);
