create table authority (
id int AUTO_INCREMENT primary key,
name varchar(50));

create table users (
id int AUTO_INCREMENT primary key,
first_name varchar(50),
family_name varchar(50),
e_mail varchar(50),
phone varchar(50),
language char(2),
id_picture int,
login varchar(50) NOT NULL UNIQUE,
password varchar(50),
birth_date Date,
enabled boolean);

create table users_authority (
id int AUTO_INCREMENT primary key,
id_user BIGINT,
id_authority BIGINT);

create table token (
series varchar(50) primary key,
value varchar(50),
date timestamp,
ip_address varchar(50),
user_agent varchar(200),
user_login varchar(50));

-- drop table authority;
-- drop table users;
-- drop table users_authority;
-- drop table token;