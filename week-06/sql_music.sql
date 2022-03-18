-- drop database if exists music;

-- create database music;

use music;

create table artist(

artist_id int primary key auto_increment,

stage_name varchar(50) not null,

real_name varchar(50) not null,

musical_act varchar(20) not null

);

create table artist_album(

artist_id int not null,

album_id int not null,

identifier varchar(50) not null,

constraint pk_artist_album
primary key(artist_id, album_id),

constraint fk_artist_album_artist_id
foreign key(artist_id)
references artist(artist_id),

constraint fk_artist_album_album_id
foreign key(album_id)
references album(album_id),

constraint uq_artist_album_identifier_artist_id
unique(identifier, artist_id)




);


create table album(

album_id int primary key not null,

release_date date not null,

title varchar(50) not null,

`name` varchar(50) not null,

identifier varchar(50) not null,

artist_id int not null,

constraint fk_album_artist_id
foreign key(artist_id)
references artist(artist_id),

constraint uq_album_identifier_artist_id
unique(identifier, artist_id)


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
references track(track_id),

constraint uq_album_track_identifier_album_id
unique(identifier, album_id)

);



create table track(

track_id int primary key not null,

`name` varchar(40) not null,

track_order int not null,

track_length_in_min int not null,

identifier varchar(50) not null,

album_id int not null,

featured_artist varchar(50),

writer varchar(50),

length varchar(10),


constraint fk_album_track_album_id
foreign key(album_id)
references album(album_id),

constraint uq_album_track_identifier_album_id
unique(identifier, album_id)

);


insert into artist(stage_name)
values('Beyoncé');

insert into album(title, release_date)
values('Beyoncé', '2013-12-13');

insert into track(title, featured_artist, length, writer, writer, writer, writer, writer, writer, writer, writer)
values('Pretty Hurts', null, '4:17', 'Beyoncé Knowles', 'Joshua Coleman', 'Sia Furler'),
('Drunk in Love', 'Jay-Z', '5:23', 'Knowles', 'Brian Soko', 'Jerome Harmon', 'Shawn Carter', 'Andre Eric Proctor', 'Rasool Díaz', 'Timothy Mosley', 'Noel Fisher'),
('Super-Power', 'Frank Ocean', '4:36', 'Knowles', 'Pharrell Williams', 'Frank Ocean');


insert into artist(stage_name)
values('Beyoncé');

insert into album(title, release_date)
values('Lemonade', '2016-08-23');

insert into track(title, featured_artist, length, writer, writer, writer, writer, writer)
values("Don't Hurt Yourself", 'Jack White', '3:53', 'Beyoncé', 'Jack White', 'Diana Gordon'),
('Sorry', null, '3:52', 'Beyoncé', 'Gordon', 'Rhoden'),
('Freedom', 'Kendrick Lamar', '5:53', 'Beyoncé', 'Jonathan Coffer', 'Carla Williams', 'Arrow Benjamin', 'Kendrick Duckworth');


insert into artist(stage_name)
values('Frank Ocean');

insert into album(title, release_date)
values('Blonde', '2016-08-20');

insert into track(title, length, writer, writer, writer)
values('Nike', '5:14', 'Christopher Breaux'),
('White Ferrari', '4:08', 'Breaux', 'Kanye West', 'Malay Ho'),
('Godspeed', '2:57', 'Breaux', 'Ho');






