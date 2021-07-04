USE testdb;

CREATE TABLE Worker (
	WORKER_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	FIRST_NAME CHAR(25),
	LAST_NAME CHAR(25),
	SALARY INT(15),
	JOINING_DATE DATETIME,
	DEPARTMENT CHAR(25)
);

INSERT INTO Worker 
	(WORKER_ID, FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT) VALUES
		(001, 'Monika', 'Arora', 100000, '14-02-20 09.00.00', 'HR'),
		(002, 'Niharika', 'Verma', 80000, '14-06-11 09.00.00', 'Admin'),
		(003, 'Vishal', 'Singhal', 300000, '14-02-20 09.00.00', 'HR'),
		(004, 'Amitabh', 'Singh', 500000, '14-02-20 09.00.00', 'Admin'),
		(005, 'Vivek', 'Bhati', 500000, '14-06-11 09.00.00', 'Admin'),
		(006, 'Vipul', 'Diwan', 200000, '14-06-11 09.00.00', 'Account'),
		(007, 'Satish', 'Kumar', 75000, '14-01-20 09.00.00', 'Account'),
		(008, 'Geetika', 'Chauhan', 90000, '14-04-11 09.00.00', 'Admin');

CREATE TABLE Bonus (
	WORKER_REF_ID INT,
	BONUS_AMOUNT INT(10),
	BONUS_DATE DATETIME,
	FOREIGN KEY (WORKER_REF_ID)
		REFERENCES Worker(WORKER_ID)
        ON DELETE CASCADE
);

INSERT INTO Bonus 
	(WORKER_REF_ID, BONUS_AMOUNT, BONUS_DATE) VALUES
		(001, 5000, '16-02-20'),
		(002, 3000, '16-06-11'),
		(003, 4000, '16-02-20'),
		(001, 4500, '16-02-20'),
		(002, 3500, '16-06-11');
        
CREATE TABLE Title (
	WORKER_REF_ID INT,
	WORKER_TITLE CHAR(25),
	AFFECTED_FROM DATETIME,
	FOREIGN KEY (WORKER_REF_ID)
		REFERENCES Worker(WORKER_ID)
        ON DELETE CASCADE
);

INSERT INTO Title 
	(WORKER_REF_ID, WORKER_TITLE, AFFECTED_FROM) VALUES
 (001, 'Manager', '2016-02-20 00:00:00'),
 (002, 'Executive', '2016-06-11 00:00:00'),
 (008, 'Executive', '2016-06-11 00:00:00'),
 (005, 'Manager', '2016-06-11 00:00:00'),
 (004, 'Asst. Manager', '2016-06-11 00:00:00'),
 (007, 'Executive', '2016-06-11 00:00:00'),
 (006, 'Lead', '2016-06-11 00:00:00'),
 (003, 'Lead', '2016-06-11 00:00:00');

Select FIRST_NAME AS WORKER_NAME from Worker;
Select upper(FIRST_NAME)  from Worker;
Select distinct DEPARTMENT from Worker;
Select substring(FIRST_NAME,1,3) from Worker;
Select INSTR(FIRST_NAME, BINARY'a') from Worker where FIRST_NAME = 'Amitabh';
Select INSTR(FIRST_NAME, BINARY'A') from Worker where FIRST_NAME = 'Amitabh';
Select RTRIM(FIRST_NAME) from Worker;
Select LTRIM(FIRST_NAME) from Worker;
Select distinct length(DEPARTMENT) from Worker;
Select REPLACE(FIRST_NAME,'a','A') from Worker;
Select CONCAT(FIRST_NAME, ' ', LAST_NAME) AS 'COMPLETE_NAME' from Worker;
Select CONCAT_WS( ' ', FIRST_NAME,LAST_NAME) AS 'COMPLETE_NAME' from Worker;
Select * from Worker order by FIRST_NAME asc;
Select * from Worker order by DEPARTMENT desc,FIRST_NAME asc;
Select * from Worker where FIRST_NAME in ('Vipul','Satish');
Select * from Worker where FIRST_NAME not in ('Vipul','Satish');
Select * from Worker where DEPARTMENT like 'Admin%';
Select * from Worker where FIRST_NAME like '_____h';
Select * from Worker where SALARY between 100000 and 500000;
#who have joined in Feb’2014.
Select * from Worker where year(JOINING_DATE) = 2014 and month(JOINING_DATE) = 2;
#count of employees working in the department ‘Admin’.
SELECT COUNT(*) FROM worker WHERE DEPARTMENT = 'Admin';

SELECT CONCAT(FIRST_NAME, ' ', LAST_NAME) As Worker_Name, Salary FROM worker 
WHERE Salary BETWEEN 50000 AND 100000;

#the no. of workers for each department in the descending order.
SELECT DEPARTMENT,COUNT(WORKER_ID) AS No_Of_Workers FROM WORKER
GROUP BY DEPARTMENT 
ORDER BY No_Of_Workers DESC;

#the no. of workers having more than 1 worker for each department in the descending order.
SELECT DEPARTMENT,COUNT(WORKER_ID) AS No_Of_Workers FROM WORKER
GROUP BY DEPARTMENT 
HAVING No_Of_Workers>2
ORDER BY No_Of_Workers DESC;

Select * from Worker;
Select * from title;

#to print details of the Workers who are also Managers.
SELECT * FROM WORKER w INNER JOIN TITLE t ON w.WORKER_ID=t.WORKER_REF_ID AND t.WORKER_TITLE ='Manager';

#nuber of records in a table
SELECT COUNT(*) FROM Title;

# to fetch duplicate records having matching data in some fields.
SELECT WORKER_TITLE, AFFECTED_FROM, COUNT(*)
FROM Title
GROUP BY WORKER_TITLE, AFFECTED_FROM
HAVING COUNT(*) > 1;

#to print odd rows i.e.worker_id%2!=0
SELECT * FROM Worker WHERE MOD (WORKER_ID, 2) <> 0;
#to print even rows
SELECT * FROM Worker WHERE MOD (WORKER_ID, 2) = 0;

#to clone the table
CREATE TABLE WorkerClone LIKE Worker;
SELECT * INTO WorkerClone FROM Worker;
#with no rows
SELECT * INTO WorkerClone FROM Worker WHERE 1 = 0;

SELECT * FROM WorkerClone;

#SQL query to show the current date.
SELECT curdate();
#SQL query to show the current date and time.
SELECT NOW();

#to show the top n (say 5) records
SELECT * FROM Worker LIMIT 5;

#Write an SQL query to determine the nth (say n=3) highest salary from a table.I.E.SKIP 2 rows and show 3rd
SELECT DISTINCT Salary FROM Worker ORDER BY Salary DESC LIMIT 2,1;
#second highest salary
Select max(Salary) from Worker where Salary not in (Select max(Salary) from Worker);

#to show one row twice in results from a table.
select * from Worker 
UNION ALL
select * from Worker ORDER BY WORKER_ID ASC;

#to fetch the first 50% records 
SELECT *
FROM WORKER
WHERE WORKER_ID <= (SELECT count(WORKER_ID)/2 from Worker);

#the last record
Select * from Worker where WORKER_ID = (SELECT max(WORKER_ID) from Worker);

#the first row
Select * from Worker where WORKER_ID = (SELECT min(WORKER_ID) from Worker);

#the name of workers who earn the highest salary.
SELECT FIRST_NAME, SALARY from Worker WHERE SALARY=(SELECT max(SALARY) from Worker);

# departments along with the total salaries paid for each of them.
 SELECT DEPARTMENT, sum(Salary) from worker group by DEPARTMENT;

#to fetch three min salaries from a table.
SELECT DISTINCT Salary from worker ORDER BY Salary ASC LIMIT 3;

#to print the name of employees having the highest salary in each department.
SELECT t.DEPARTMENT,t.FIRST_NAME,t.Salary from(SELECT max(Salary) as TotalSalary,DEPARTMENT from Worker group by DEPARTMENT) as TempNew 
Inner Join Worker t on TempNew.DEPARTMENT=t.DEPARTMENT 
 and TempNew.TotalSalary=t.Salary;
 
 #LAST 5 RECORDS
 Select * from Worker where WORKER_ID >= (SELECT max(WORKER_ID)-4 from Worker);

#to show all departments along with the number of people 
SELECT DEPARTMENT, COUNT(WORKER_ID) as 'Number of Workers' FROM Worker GROUP BY DEPARTMENT;

#to fetch the departments that have less than five people in it
SELECT DEPARTMENT, COUNT(WORKER_ID) as 'Number of Workers' FROM Worker GROUP BY DEPARTMENT HAVING COUNT(WORKER_ID) < 5;

#to fetch the list of employees with the same salary.
Select distinct W.WORKER_ID, W.FIRST_NAME, W.Salary 
from Worker W, Worker W1 
where W.Salary = W1.Salary 
and W.WORKER_ID != W1.WORKER_ID;



