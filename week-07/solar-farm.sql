-- solar farm database

-- entities

-- panels








drop database if exists solar_farm;

create database solar_farm;

use solar_farm;

create table panels(

panel_id int primary key auto_increment,

section varchar(50) not null,

`row` int not null,

`column` int not null,

`year` date not null,

material varchar(70) not null,

isTracking boolean not null


);