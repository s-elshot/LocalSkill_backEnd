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
insert into customer(first_name, last_name, email_adress, area_code, user_role, enabled,  city)
values ('Stephan', 'Elshot', 'selshot@gmail.com', '1946AL','CUSTOMER',TRUE,'Beverwijk');
insert into customer(first_name, last_name, email_adress, area_code, enabled, user_role, city, guild )
values ('Susanne', 'Bijwaard', 'susannebijwaard@yahoo.com', '1946AL',TRUE, 'GUILDER', 'Beverwijk','Baker');

insert into customer(first_name, last_name, email_adress, area_code, enabled,user_role,  city)
values ('Michel', 'Lalmohamed', 'mlalmohamed@gmail.com', '1946AL',TRUE,'CUSTOMER','Beverwijk');
insert into customer(first_name, last_name, email_adress, area_code, enabled, user_role, city, guild )
values ('Zhara', 'Bijwaard', 'susannebijwaard@yahoo.com', '1946AL',TRUE, 'GUILDER', 'Beverwijk','Baker');

insert into items(name, price, description, number,count, item_type)
values ('Music lesson 01', 1200, 'Beginnner music lesson', 03,1, 'SERVICE');
insert into items(name, price, description, number,count, item_type)
values ('Music performance', 2300, 'Musical performance for 30 minutes', 04,1, 'SERVICE');

insert into orders( customer_id)
values ( '1');

insert into orders( customer_id)
values ( '1');

insert into orders( customer_id)
values ( '2');
--
-- insert into orders(customer_id)
-- values ( '1');
--
-- insert into orders( customer_id)
-- values ( '2');

insert into ordered_items(orders_id,items_id)
values ( '1','1');

insert into ordered_items(orders_id,items_id)
values ( '1','2');
--
--


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
values ('Air Jordan I High Strap Just Don BHM - 2015', 10000, 'The shoes featured the 2015 edition of Nike’s Black History Month graphic print with black lining and gold tipped laces and gold buckle on the ankle strap.', 01, 2, 'PRODUCT', '1');

insert into items(name, price, description, number, count, item_type, customer_id)
values ('Air Jordan XI 25th Anniversary with Jumpman', 11000, 'To celebrate the 25th anniversary of the first Air Jordan released in 1985, Nike released a special edition of the Air Jordan XI', 02, 10, 'PRODUCT', '2');

insert into items(name, price, description, number, count, item_type, customer_id)
values ('Nike x MSCHF Air Max 97 Jesus Shoes –  Walk On Water', 4000, 't turns out walking on water is indeed possible.', 01, 2, 'PRODUCT', '1');

insert into items(name, price, description, number, count, item_type, customer_id)
values ('Nike Yeezy 2 Red October', 7500, 'Before Kanye West signed to adidas, the legendary Yeezy shoes used to be released under Nike.', 02, 10, 'PRODUCT', '2');

insert into items(name, price, description, number, count, item_type, customer_id)
values ('Chanel x Pharrell x adidas NMD Hu', 10000, 'Most of the Pharrell x adidas NMD Human Race collaboration fetched a high resell price.', 01, 2, 'PRODUCT', '1');

insert into items(name, price, description, number, count, item_type, customer_id)
values ('DJ Khaled x Air Jordan 3 ‘Grateful', 25000, 'When DJ Khaled released his album Grateful, his collaboration with Jordan – a pair of Air Jordan 3´s called “Grateful” also came out.', 02, 10, 'PRODUCT', '2');


insert into items(name, price, description, number, count, item_type, customer_id)
values ('Macklemore x Air Jordan 6 Cactus', 25000, 'Looking for these at a thrift shop would be completely futile. Why?', 01, 2, 'PRODUCT', '1');

insert into items(name, price, description, number, count, item_type, customer_id)
values ('Nike Air Mag Back to the Future 2016', 25000, 'One of recent year´s most famous sneakers – owned by, for example, the Slovakian rapper Rytmus.', 02, 10, 'PRODUCT', '2');

-- service

insert into items(name, price, description, number,count, item_type, customer_id)
values ('Music lesson 01', 1200, 'Beginnner music lesson', 03,5, 'SERVICE', '1');

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
insert into orders(customer_id)
values ( '1');

insert into orders( customer_id)
values ( '1');

insert into ordered_items(orders_id,items_id)
values ( '1','1');



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
