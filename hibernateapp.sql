use mydb;

create table EMPLOYEE (
   id INT NOT NULL auto_increment,
   first_name VARCHAR(20) default NULL,
   last_name  VARCHAR(20) default NULL,
   salary     INT  default NULL,
   PRIMARY KEY (id)
);
-- delete row for id=4
/*delete row
	for id=4*/
delete from EMPLOYEE where id=4 ;
select * from EMPLOYEE;

create table Laptop (
   lid INT NOT NULL,
   lname VARCHAR(20) default NULL
);

select * from Laptop;
