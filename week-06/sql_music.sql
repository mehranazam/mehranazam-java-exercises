




-- consider pair-wise entity relationships
-- 1, 2
-- 			is there a direct relationship[ at all?				yes
-- 			can a track be associated with multiple albums? 	no (but really yes)
-- 			can an album be associated with multiple tracks?	yes
-- 1, 3
-- 			is there a direct relationship at all?				yes (maybe no?)
-- 			can an album be associated with multiple albums?	yes
-- 			can an artist be associated with multiple albums?   yes
-- 2, 3
-- 			is there a direct relationship at all?				no (maybe yes?)

-- 1, 4
-- 			is there a direct relationship at all?				yes
-- 			can a label be associated with multiple albums		yes
-- 			can an album be associated with multiple labels		no(???)

-- 2, 4		
-- 			is there a direct relationship at all?				no

-- 3, 4		
-- 			is there a direct relationship at all?				no(?)


-- artists have albums which have tracks

-- album	1 -> many		tracks
-- album	many -> many	artists
-- album	many -> 1		labels
-- aliases  many -> 1		artists



drop database if exists music;

create database music;

use music;

create table label(
    
    label_id int primary key auto_increment

);

create table album(

album_id int primary key auto_increment,

release_date date not null,

title varchar(50) not null,


label_id	int,

-- identifier varchar(50) not null,

artist_id int not null,

/*
constraint fk_album_artist_id
foreign key(artist_id)
references artist(artist_id)
*/


/*
constraint uq_album_identifier_artist_id
unique(identifier, artist_id)
*/

constraint fk_album_label foreign key (label_id) references label(label_id)

);


create table artist(

artist_id int primary key auto_increment,

-- stage_name varchar(50) not null,

`name` varchar(50) not null



);

create table alias(
	alias_id int primary key auto_increment,
    
    `name` varchar(100) not null,
    
    artist_id int not null,
    
    constraint fk_artist_alias foreign key (artist_id) references artist( artist_id )


);











create table track(

track_id int primary key auto_increment,

`name` varchar(40) not null,

track_order int not null,

track_length_in_min int not null,

-- identifier varchar(50) not null,

album_id int not null,

featured_artist varchar(50),

writer varchar(50),

length varchar(10),


/*
constraint fk_track_album 
foreign key(album_id)
references album(album_id),
*/

/*
constraint fk_album_track_album_id
foreign key(album_id)
references album(album_id)
*/

/*
constraint uq_album_track_identifier_album_id
unique(identifier, album_id)
*/

constraint fk_track_album foreign key (album_id) references album(album_id)


);

-- this will have foreign keys to both artist and album
create table artist_album(

alias_id int,

album_id int,

album_role varchar(50) not null,

-- identifier varchar(50) not null,

constraint pk_alias_album
primary key(alias_id, album_id, album_role),

constraint fk_alias_album_artist_id
foreign key(alias_id)
references alias(alias_id),

constraint fk_alias_album_album_id
foreign key(album_id)
references album(album_id)

/*
constraint uq_artist_album_identifier_artist_id
unique(identifier, artist_id)
*/



);

create table album_track(

album_id int not null,
track_id int not null,
identifier varchar(50) not null,

constraint pk_album_track
primary key(album_id, track_id),

constraint fk_album_track_album_id
foreign key(album_id)
references album(album_id),

constraint fk_album_track_track_id
foreign key(track_id)
references track(track_id)


/*
constraint uq_album_track_identifier_album_id
unique(identifier, album_id)
*/

);

					   
insert into artist(`name`)
values('Beyoncé'), ('Frank Ocean');


insert into album(title, release_date)
values('Beyoncé', '2013-12-13'), ('Lemonade', '2016-08-23'), ('Blonde', '2016-08-20');

insert into artist_album(artist_id, album_id)
values(1, 1), (1, 2), (2, 3);

/*
insert into track(title, featured_artist, length, writer, writer, writer, writer, writer, writer, writer, writer)
values('Pretty Hurts', null, '4:17', 'Beyoncé Knowles', 'Joshua Coleman', 'Sia Furler'),
('Drunk in Love', 'Jay-Z', '5:23', 'Knowles', 'Brian Soko', 'Jerome Harmon', 'Shawn Carter', 'Andre Eric Proctor', 'Rasool Díaz', 'Timothy Mosley', 'Noel Fisher'),
('Super-Power', 'Frank Ocean', '4:36', 'Knowles', 'Pharrell Williams', 'Frank Ocean');
*/

/*
insert into artist(`name`)
values('Beyoncé');
*/



/*
insert into track(title, featured_artist, length, writer, writer, writer, writer, writer)
values("Don't Hurt Yourself", 'Jack White', '3:53', 'Beyoncé', 'Jack White', 'Diana Gordon'),
('Sorry', null, '3:52', 'Beyoncé', 'Gordon', 'Rhoden'),
('Freedom', 'Kendrick Lamar', '5:53', 'Beyoncé', 'Jonathan Coffer', 'Carla Williams', 'Arrow Benjamin', 'Kendrick Duckworth');
*/



/*
insert into track(title, length, writer, writer, writer)
values('Nike', '5:14', 'Christopher Breaux'),
('White Ferrari', '4:08', 'Breaux', 'Kanye West', 'Malay Ho'),
('Godspeed', '2:57', 'Breaux', 'Ho');
*/

select *
from artist ar
inner join artist_album aa on ar.artist_id = aa.artist_id
inner join album al on al.album_id = aa.album_id;



