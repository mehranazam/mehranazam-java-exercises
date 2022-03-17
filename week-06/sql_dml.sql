-- drop database if exists sustainable_foraging;

-- create database sustainable_foraging;

use sustainable_foraging;

-- foragers

create table forager(

forager_id char(36) primary key,

first_name varchar(30) not null,

last_name varchar(30) not null,

state char(2) not null

);



-- forages

create table outing(

	outing_id char(36) primary key,
    
    weight_kg double not null,
    
    forager_id char(36) not null,
    
    item_id int not null,
    
    outing_date date not null,
    
    constraint uni_outing unique(outing_date, forager_id, outing_id)

);

-- items

create table item(

item_id int primary key auto_increment,

`name` varchar(50) not null,

price decimal(6, 2) not null,

category_id int,

constraint fk_item_category foreign key (category_id) references category(category_id)

);


-- categories

create table category(

category_id int primary key auto_increment,

`name` varchar(10) not null,

constraint uni_forager_name unique(first_name, last_name)
);

insert into category(`name`)
values ('EDIBLE'), ('MEDICINAL'), ('INEDIBLE'), ('POISONOUS');


insert into item(`name`, price, category_id)
values ('Ramps', '5', (select category_id from category where `name` = 'EDIBLE')),
('Ramps', '5', (select category_id from category where `name` = 'EDIBLE')),
('Purslane', '5', (select category_id from category where `name` = 'EDIBLE')),
('Cattail', '5', (select category_id from category where `name` = 'EDIBLE')),
('Chicory', '5', (select category_id from category where `name` = 'EDIBLE')),
('Field Garlic', '5', (select category_id from category where `name` = 'EDIBLE')),
('Papaw', '5', (select category_id from category where `name` = 'EDIBLE'));



insert into forager()

;
SELECT * FROM category;

select * from item inner join category on item.category_id = category.category_id;