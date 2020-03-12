drop database if exists first_project;
create database first_project char set utf8;
use first_project;

create table users(
	id int primary key auto_increment,
    first_name varchar(30) not null,
    second_name varchar(30) not null,
    age int not null,
    email varchar(45) not null,
    password varchar(20) not null unique
);

select * from users;