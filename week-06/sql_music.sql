create database music;

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

album_id int not null

);