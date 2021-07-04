use mydb;

CREATE TABLE user 
(
ID INT NOT NULL ,
username VARCHAR(20),
password VARCHAR(100)
);

insert into user values(101,'spiderman','web'),(102,'superman','fly');
insert into user values(103,'megha','$2a$10$ZYoKRJTm.Q32ih5Pl1E7UeADyqBsC7aIy4sbbUuDcvYn.inuVAmgO') ;//pwd:1234
insert into user values(104,'anagha','$2a$10$FKgRpHDW4xtwwr.c30IZveNPYWcxyVaTLHiLNPTdZarZBD44Qorzu'); //pwd:abcd
select * from user;