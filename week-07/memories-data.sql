-- memories database

-- entities

-- memories

drop database if exists memories;

create database memories;

use memories;

create table `memory`(

memory_id int primary key auto_increment,

content varchar(50) not null,

`from` varchar(100) not null,

isShareable boolean not null


);
