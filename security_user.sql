CREATE SCHEMA `mydb` ;
use mydb;
create table user(
	id int not null,
	username varchar(50) not null primary key,
	password varchar(50) not null,
    roles varchar(50) not null,
	active boolean not null
);

INSERT INTO user(username,password,roles,active,id)
	values('user','pass','ROLE_USER',true,0);
INSERT INTO user(username,password,roles,active,id)
	values('admin','passs','ROLE_ADMIN',true,1);
select * from USER;