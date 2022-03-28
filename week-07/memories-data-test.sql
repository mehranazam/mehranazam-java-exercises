drop database if exists memories_test;

create database memories_test;

use memories_test;

create table `memory`(

memory_id int primary key auto_increment,

content varchar(50) not null,

`from` varchar(100) not null,

isShareable boolean not null


);


set delimiter //

create procedure set_known_good_state()
begin

truncate table `memory`;

insert into `memory`(`from`, content, isShareable)
values
('Thomas', 'I had fun, Martha', true),
('Layla', 'This was the perfect day', false),
('Mark', 'Are you finished', false);

end //

set delimiter ;

call set_known_good_state();

