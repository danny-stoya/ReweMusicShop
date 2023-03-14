use music_company;

insert into clients (name) values ('Ratke and Sons');
insert into clients (name) values ('Borer, Emard and Blick');

insert into clients (name, dob) values ('Codee', '2002-08-26');
insert into clients (name, dob) values ('Des', '2020-01-11');
insert into clients (name, dob) values ('Lila', '2014-10-27');

insert into studios (price_per_hour, min_price, daily_hour_limit, music_company_id) values (115, 50, 15, 1);
insert into studios (price_per_hour, min_price, daily_hour_limit, music_company_id) values (102, 50, 19, 1);
insert into studios (price_per_hour, min_price, daily_hour_limit, music_company_id) values (81, 50, 15, 1);
insert into studios (price_per_hour, min_price, daily_hour_limit, music_company_id) values (92, 50, 14, 1);
insert into studios (price_per_hour, min_price, daily_hour_limit, music_company_id) values (150, 50, 10, 1);