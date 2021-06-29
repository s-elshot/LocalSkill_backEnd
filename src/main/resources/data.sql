-- INSERT INTO users (username, password, enabled) VALUES ('user', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
-- INSERT INTO users (username, password, enabled) VALUES ('admin', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
-- INSERT INTO users (username, password, enabled) VALUES ('peter', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);



insert into customer(first_name, last_name, email, area_code, user_role, enabled,  city, customer_guild)
values ('Stephan', 'Elshot', 'selshot@gmail.com', '1946AL','GUILDER',TRUE,'Beverwijk','SALES');
insert into customer(first_name, last_name, email, area_code, enabled, user_role, city, guild, customer_guild )
values ('Susanne', 'Bijwaard', 'susannebijwaard@yahoo.com', '1946AL',TRUE, 'GUILDER', 'Beverwijk','Baker','SALES');

insert into invoice(description)
values ( 'first test');
insert into invoice(description)
values ( 'first test');

insert into invoice(customer_id ,description)
values ( '2', 'second test - customer with items');

insert into invoice(customer_id ,description)
values ( '2', 'second test - customer with items');

insert into customer(first_name, last_name, email, area_code, enabled,user_role,  city)
values ('Michel', 'Lalmohamed', 'mlalmohamed@gmail.com', '1946AL',TRUE,'CUSTOMER','Beverwijk');
insert into customer(first_name, last_name, email, area_code, enabled, user_role, city, guild, customer_guild )
values ('Zhara', 'Lalmohamed', 'susannebijwaard@yahoo.com', '1946AL',TRUE, 'GUILDER', 'Beverwijk','Baker', 'FOOD');

insert into customer(first_name, last_name, email, area_code, enabled,user_role,  city,customer_guild)
values ('Giel', 'Bijwaard', 'giel@gmail.com', '1946AL',TRUE,'GUILDER','Beverwijk','FINANCE');
insert into customer(first_name, last_name, email, area_code, enabled, user_role, city, customer_guild )
values ('Miquel', 'Elshot', 'miquelio@yahoo.com', '1066SP',TRUE, 'GUILDER', 'Amsterdam', 'CONSTRUCTION');
insert into customer(first_name, last_name, email, area_code, enabled, user_role, city, customer_guild )
values ('Guno', 'Elshot', 'guno@yahoo.com', '1066SP',TRUE, 'GUILDER', 'Amsterdam', 'LEISURE');
insert into customer(first_name, last_name, email, area_code, enabled, user_role, city, customer_guild )
values ('Miles', 'Elshot', 'Miles@yahoo.com', '1946AL',TRUE, 'GUILDER', 'Amsterdam', 'SPORT');
insert into customer(first_name, last_name, email, area_code, enabled, user_role, city, customer_guild )
values ('Julian', 'Elshot', 'julian@yahoo.com', '1946AL',TRUE, 'GUILDER', 'Beverwijk', 'CREATIVE_DESIGN');
insert into customer(first_name, last_name, email, area_code, enabled, user_role, city, customer_guild )
values ('Doris', 'Komproe', 'Doris@yahoo.com', '1066SP',TRUE, 'GUILDER', 'Amsterdam', 'HEALTHCARE');
insert into customer(first_name, last_name, email, area_code, enabled, user_role, city, customer_guild )
values ('Atie', 'Bijwaard', 'atie@yahoo.com', '1946AL',TRUE, 'GUILDER', 'Amsterdam', 'SECURITY');





insert into items(name, price, description, number,count, item_type)
values ('Music lesson 01', 1200, 'Beginnner music lesson', 03,1, 'SERVICE');
insert into items(name, price, description, number,count, item_type)
values ('Music performance', 2300, 'Musical performance for 30 minutes', 04,1, 'SERVICE');

-- insert into order( customer_id)
-- values ( '1');
--
-- insert into order( customer_id)
-- values ( '1');
--
-- insert into order( customer_id)
-- values ( '2');
--
-- insert into orders(customer_id)
-- values ( '1');
--
-- insert into orders( customer_id)
-- values ( '2');

insert into invoice_items(invoice_id,items_id)
values ( '3','1');


insert into invoice_items(invoice_id,items_id)
values ( '4','2');

insert into invoice_items(invoice_id,items_id)
values ( '3','2');

-- insert into invoice_items(invoice_id,items_id)
-- values ( '4','7');
--
-- insert into invoice_items(invoice_id,items_id)
-- values ( '4','8');

-- TESTKLASSE
-- insert into test_klasse( id, invoice_id)
-- values ( 1,6);


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


-- PRODUCT
insert into items(name, price, description, number, count, item_type, customer_id)
values ('Air Jordan I High Strap Just Don BHM - 2015', 10000, 'The shoes featured the 2015 edition of Nike’s Black History Month graphic print with black lining and gold tipped laces and gold buckle on the ankle strap.', 01, 2, 'PRODUCT', '1');

insert into items(name, price, description, number, count, item_type, customer_id)
values ('Air Jordan XI 25th Anniversary with Jumpman', 11000, 'To celebrate the 25th anniversary of the first Air Jordan released in 1985, Nike released a special edition of the Air Jordan XI', 02, 10, 'PRODUCT', '2');

insert into items(name, price, description, number, count, item_type, customer_id)
values ('Nike x MSCHF Air Max 97 Jesus Shoes –  Walk On Water', 4000, 't turns out walking on water is indeed possible.', 01, 2, 'PRODUCT', '1');

insert into items(name, price, description, number, count, item_type, customer_id)
values ('Nike Yeezy 2 Red October', 7500, 'Before Kanye West signed to adidas, the legendary Yeezy shoes used to be released under Nike.', 02, 10, 'PRODUCT', 2);

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
values ('Music lesson 01', 1200, 'Beginnner music lesson', 03,5, 'SERVICE', 1);

insert into items(name, price, description, number,count, item_type, customer_id)
values ('Music performance', 2300, 'Musical performance for 30 minutes', 04,51, 'SERVICE', '2');

-- messages
insert into messages(title, body_text,customer_id,invoice_id)
values ('Did it Work?','A check of this relationship is modeled correctly',1,1);
insert into messages(title, body_text,customer_id)
values ('Yes it worked!','A confirmation of this relationship is modeled correctly',1);
-- images
-- insert into images(name,type,items_id)
-- values ('Sneaker01','jpg','4');
--
-- --ORDERS
-- --

-- Newly created items
insert into items(name, price, description, number, count, item_type, customer_id)
values ('Millionaire shortbread', 15, 'Flat cake (30x30 cm) - containing dough, chocolate and caramel', 1, 1, 'PRODUCT',4);

insert into items(name, price, description, number, count, item_type, customer_id)
values ('Red velvet cake', 20, 'Cake (30x30 cm) - containing cream cheese, whipped cream and icing', 1, 1, 'PRODUCT',4);

insert into items(name, price, description, number, count, item_type, customer_id)
values ('Apple pie', 20, 'Pie (30x30 cm) - composed out of apples, dough, sugar and cinnamon', 1, 1, 'PRODUCT',4);


insert into items(name, price, description, number, count, item_type, customer_id)
values ('Mortgage advice', 1500, 'Giving thorough advice on mortgage matters', 1, 1, 'SERVICE',5);

insert into items(name, price, description, number, count, item_type, customer_id)
values ('Bookkeeping / Accountancy report', 900, 'Creating a full bookkeeping report for customers/companies with a yield less then 10K', 1, 1, 'SERVICE', '5');

insert into items(name, price, description, number, count, item_type, customer_id)
values ('Tax return report', 900, 'Creating a full tax return report for individual customers', 1, 1, 'SERVICE', '5');

insert into items(name, price, description, number, count, item_type, customer_id)
values ('Replace lock', 300, 'Replacing front door locks', 1, 1, 'SERVICE', '6');

insert into items(name, price, description, number, count, item_type, customer_id)
values ('Table', 900, 'Creating a custom made table - at the wishes of the customer', 1, 1, 'PRODUCT', '6');

insert into items(name, price, description, number, count, item_type, customer_id)
values ('Gutter repair', 700, 'Fixing gutter connections', 1, 1, 'SERVICE', '6');

insert into items(name, price, description, number, count, item_type, customer_id)
values ('Plumbing repair', 300, 'Fixing plumbing connections', 1, 1, 'SERVICE', '6');


insert into items(name, price, description, number, count, item_type, customer_id)
values ('Clown hire (children party)', 100, 'Party clown performance for 90 minutes', 1, 1, 'SERVICE', '7');

insert into items(name, price, description, number, count, item_type, customer_id)
values ('Event planning', 600, 'Creating a planning and invoice for a party', 1, 1, 'SERVICE', '7');


insert into items(name, price, description, number, count, item_type, customer_id)
values ('Soccer skill training', 30, 'Individual soccer skill training for 60 minutes', 1, 1, 'SERVICE', '8');

insert into items(name, price, description, number, count, item_type, customer_id)
values ('Basketball skill training', 20, 'Individual basketbal skill training for 60 minute', 1, 1, 'SERVICE', '8');

insert into items(name, price, description, number, count, item_type, customer_id)
values ('Soccer clinic', 1000, 'private soccer team-clinic 3x 60 minutes', 1, 1, 'SERVICE', '8');


insert into items(name, price, description, number, count, item_type, customer_id)
values ('Architectural sketch design', 1500, 'Analysis of programme of requirements(demands of client) and spatial representation in sketch-form', 1, 1, 'SERVICE', '9');

insert into items(name, price, description, number, count, item_type, customer_id)
values ('Architectural preliminary design', 2500, 'Advancement of the sketch-design, containing specific space-reservations', 1, 1, 'SERVICE', '9');

insert into items(name, price, description, number, count, item_type, customer_id)
values ('Architectural scale model 1:1000', 1500, 'Scale model (1:1000) of building with a max size of an A2', 1, 1, 'SERVICE', '9');

insert into items(name, price, description, number, count, item_type, customer_id)
values ('Architectural scale model 1:500', 3000, 'Scale model (1:500) of building with a max size of an A1', 1, 1, 'SERVICE', '9');

insert into items(name, price, description, number, count, item_type, customer_id)
values ('Architectural scale model 1:200', 6000, 'Scale model (1:200) of building with a max size of an A0', 1, 1, 'SERVICE', '9');


insert into items(name, price, description, number, count, item_type, customer_id)
values ('Dental cleaning', 500, 'Dental cleaning for 60 minutes (polishing included)', 1, 1, 'SERVICE', '10');

insert into items(name, price, description, number, count, item_type, customer_id)
values ('Cleaning instruction', 50, 'Dental cleaning instruction for 30 minutes', 1, 1, 'SERVICE', '10');


insert into items(name, price, description, number, count, item_type, customer_id)
values ('private security 1', 500, 'Private security protection for 24 hours', 1, 1, 'SERVICE', '11');

insert into items(name, price, description, number, count, item_type, customer_id)
values ('private security 2', 2000, 'Private security protection for one week', 1, 1, 'SERVICE', '11');

insert into items(name, price, description, number, count, item_type, customer_id)
values ('private security 3', 3000, 'Private security protection for party smaller than 100 persons', 1, 1, 'SERVICE', '11');

insert into items(name, price, description, number, count, item_type, customer_id)
values ('private security 4', 6000, 'Private security protection for party bigger than 100 persons (max 300 persons)', 1, 1, 'SERVICE', '11');
--
-- insert into orders(customer_id)
-- values ( '1');
--
-- insert into orders( customer_id)
-- values ( '1');

-- insert into ordered_items(orders_id,items_id)
-- values ( '1','1');

-- INSERT INTO authority (username, authority) VALUES ('user', 'ROLE_USER');
-- INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_USER');
-- INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_ADMIN');
-- INSERT INTO authority (username, authority) VALUES ('peter', 'ROLE_USER');
-- INSERT INTO authority (username, authority) VALUES ('peter', 'ROLE_ADMIN');
-- INSERT INTO authority (username, authority) VALUES ('jack', 'ROLE_USER');

