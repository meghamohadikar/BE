USE testDB;

CREATE TABLE members (
    member_id INT AUTO_INCREMENT,
    name VARCHAR(100),
    PRIMARY KEY (member_id)
);

CREATE TABLE committees (
    committee_id INT AUTO_INCREMENT,
    name VARCHAR(100),
    PRIMARY KEY (committee_id)
);

DESC members;
DESC committees;

INSERT INTO members(name)
VALUES('John'),('Jane'),('Mary'),('David'),('Amelia');

INSERT INTO committees(name)
VALUES('John'),('Mary'),('Amelia'),('Joe');

SELECT * FROM members;
SELECT * FROM committees;

#inner join
SELECT m.member_id, m.name member, c.committee_id, c.name committee
FROM members m INNER JOIN committees c ON c.name = m.name;
#as name is the same column name
SELECT m.member_id, m.name member, c.committee_id, c.name committee
FROM members m INNER JOIN committees c USING(name);

#left join
SELECT m.member_id, m.name member, c.committee_id, c.name committee
FROM members m LEFT JOIN committees c USING(name);
#rows present in left table except common rows
SELECT m.member_id, m.name member, c.committee_id, c.name committee
FROM members m LEFT JOIN committees c ON c.name = m.name WHERE c.committee_id IS NULL;

#RIGHT join
#rows present in right table except common rows
SELECT m.member_id, m.name member, c.committee_id, c.name committee
FROM members m RIGHT JOIN committees c ON c.name = m.name WHERE m.member_id IS NULL;
SELECT m.member_id, m.name member, c.committee_id, c.name committee
FROM members m RIGHT JOIN committees c USING(name);

#Full join, MySQL doesn't support this
SELECT m.member_id, m.name member, c.committee_id, c.name committee
FROM members m FULL OUTER JOIN committees c ON c.name = m.name;

SELECT m.member_id, m.name member, c.committee_id, c.name committee
FROM members m LEFT OUTER JOIN committees c ON c.name = m.name
UNION ALL
SELECT m.member_id, m.name member, c.committee_id, c.name committee
FROM members m RIGHT OUTER JOIN committees c ON c.name = m.name;

#self join 
SELECT m.name AS member1,m1.name AS member2
FROM members m,members m1 WHERE m.name = m1.name;

#cross join
SELECT * FROM members m CROSS JOIN committees c;