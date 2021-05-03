-- INSERT INTO users (username, password, enabled) VALUES ('user', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
-- INSERT INTO users (username, password, enabled) VALUES ('admin', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
-- INSERT INTO users (username, password, enabled) VALUES ('peter', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);

-- INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
-- INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
-- INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
-- INSERT INTO authorities (username, authority) VALUES ('peter', 'ROLE_USER');

-- insert into book (title) values ('Harry Potter');
-- insert into book (title) values ('Swiebertje');
-- insert into book (title) values ('Kill Bill');
insert into customer(first_name, last_name, email_adress, area_code, enabled, user_role, city, guild)
values ('Stephan', 'Elshot', 'selshot@gmail.com', '1946AL',TRUE, 'GUILDER', 'Beverwijk', 'Baker');
insert into customer(first_name, last_name, email_adress, area_code, enabled, user_role, city )
values ('Susanne', 'Bijwaard', 'susannebijwaard@yahoo.com', '1946AL',TRUE, 'CUSTOMER', 'Beverwijk');
insert into items(name, price, description, number,count, item_type)
values ('Music lesson 01', 1200, 'Beginnner music lesson', 03,1, 'SERVICE');
insert into items(name, price, description, number,count, item_type)
values ('Music performance', 2300, 'Musical performance for 30 minutes', 04,1, 'SERVICE');

insert into orders( customer_id)
values ( '1');
--
-- insert into orders(customer_id)
-- values ( '1');
--
-- insert into orders( customer_id)
-- values ( '2');

-- insert into ordered_items(orders_id,items_id)
-- values ( '1','1');



--
-- insert into customer(first_name, last_name, email_adress, area_code, password, enabled, user_role, city, guild)
-- values ('Bill', 'Withers', 'whatisheandwhoishetoyou@gmail.com', '1946AL',
--         '$2y$12$wk21e6ujREi09GvzYHO98OMVS2lmS0fiynwgJu2hVi7p54pGDWXgu',
--         TRUE, 'GUILDER', 'Beverwijk', 'Music');



-- CUSTOMERS CLASS
-- guilders
-- insert into customer(first_name, last_name, email_adress, area_code, password, enabled, user_role, city, guild)
-- values ('Stephan', 'Elshot', 'selshot@gmail.com', '1946AL',
--         '$2y$12$wk21e6ujREi09GvzYHO98OMVS2lmS0fiynwgJu2hVi7p54pGDWXgu',
--         TRUE, 'GUILDER', 'Beverwijk', 'Baker');
--
-- insert into customer(first_name, last_name, email_adress, area_code, password, enabled, user_role, city, guild)
-- values ('Bill', 'Withers', 'whatisheandwhoishetoyou@gmail.com', '1946AL',
--         '$2y$12$wk21e6ujREi09GvzYHO98OMVS2lmS0fiynwgJu2hVi7p54pGDWXgu',
--         TRUE, 'GUILDER', 'Beverwijk', 'Music');

-- customers
-- insert into customer(first_name, last_name, email_adress, area_code, password, enabled, user_role, city)
-- values ('Susanne', 'Bijwaard', 'sbijwaard@yahoo.com', '1946AL',
--         '$2y$12$wk21e6ujREi09GvzYHO98OMVS2lmS0fiynwgJu2hVi7p54pGDWXgu', TRUE, 'CUSTOMER', 'Beverwijk');
--
-- insert into customer(first_name, last_name, email_adress, area_code, password, enabled, user_role, city)
-- values ('Michel', 'Lalmohamed', 'michelAmin@hotmail.com', '1946AL',
--         '$2y$12$wk21e6ujREi09GvzYHO98OMVS2lmS0fiynwgJu2hVi7p54pGDWXgu', TRUE, 'CUSTOMER', 'Beverwijk');
--
-- insert into customer(first_name, last_name, email_adress, area_code, password, enabled, user_role, city)
-- values ('James', 'Brown', 'paidthecost@hotmail.com', '1946AL',
--         '$2y$12$wk21e6ujREi09GvzYHO98OMVS2lmS0fiynwgJu2hVi7p54pGDWXgu', TRUE, 'CUSTOMER', 'Beverwijk');
--
-- insert into customer(first_name, last_name, email_adress, area_code, password, enabled, user_role, city)
-- values ('Otis', 'Redding', 'ivegotdreams@hotmail.com', '1946AL',
--         '$2y$12$wk21e6ujREi09GvzYHO98OMVS2lmS0fiynwgJu2hVi7p54pGDWXgu', TRUE, 'CUSTOMER', 'Beverwijk');



-- PRODUCT
--product
insert into items(name, price, description, number, count, item_type, customer_id)
values ('Rega Planar 1', 1200, 'Record player - A device to play records', 01, 2, 'PRODUCT', '2');

insert into items(name, price, description, number, count, item_type, customer_id)
values ('Shure SM57', 2300, 'Microphone - superb quality', 02, 10, 'PRODUCT', '2');

-- service

insert into items(name, price, description, number,count, item_type, customer_id)
values ('Music lesson 01', 1200, 'Beginnner music lesson', 03,5, 'SERVICE', '2');

insert into items(name, price, description, number,count, item_type, customer_id)
values ('Music performance', 2300, 'Musical performance for 30 minutes', 04,51, 'SERVICE', '2');


--OVERVIEW
-- insert into overview(category,area_code,city)
-- values ('Music','1946AL','Beverwijk');
--
-- insert into overview(category,area_code,city)
-- values ('Bakers','1946AL','Beverwijk');
--
-- insert into overview(category,area_code,city)
-- values ('Electrician','1946AL','Beverwijk');
--
-- insert into overview(category,area_code,city)
-- values ('Architects','1946AL','Beverwijk');
--
-- insert into overview(category,area_code,city)
-- values ('Plasterers','1946AL','Beverwijk');
--
-- insert into overview(category,area_code,city)
-- values ('Macrame','1946AL','Beverwijk');
--
-- insert into overview(category,area_code,city)
-- values ('Plumming','1946AL','Beverwijk');

--ORDERS
--
-- insert into orders( customer_id)
-- values ( '1');
--
-- insert into orders(customer_id)
-- values ( '1');
--
-- insert into orders( customer_id)
-- values ( '1');
--
-- insert into ordered_items(orders_id,items_id)
-- values ( '1','1');



--
--
--
-- INSERT INTO authority (username, authority) VALUES ('user', 'ROLE_USER');
-- INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_USER');
-- INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_ADMIN');
-- INSERT INTO authority (username, authority) VALUES ('peter', 'ROLE_USER');
-- INSERT INTO authority (username, authority) VALUES ('peter', 'ROLE_ADMIN');
-- INSERT INTO authority (username, authority) VALUES ('jack', 'ROLE_USER');
--
--
