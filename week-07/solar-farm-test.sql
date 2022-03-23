drop database if exists solar_farm_test;

create database solar_farm_test;

use solar_farm_test;

create table panels(

panel_id int primary key auto_increment,

section varchar(50) not null,

`row` int not null,

`column` int not null,

`year` date not null,

material varchar(70) not null,

isTracking boolean not null


);


set delimiter //

create procedure set_known_good_state()
begin

truncate panels;

insert into panels(section, `row`, `column`, `year`, material, isTracking)
values
('The Ridge', 2, 3, '2019', 'POLY-SI', true),
('The Hills', 3, 4, '2020', 'MONO-SI', true),
('The Narrows', 2, 1, '1998', 'A_SI', true),
('The Meadow', 6, 4, '2000', 'CIGS', false);


end //

set delimiter ;

call set_known_good_state();