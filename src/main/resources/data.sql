/*select * from dual;
ID	EMAIL_ADDRESS	FIRST_NAME	LAST_NAME	ROLE	SSN	USER_NAME*/

INSERT INTO person (id, address, email, first_name, last_name, role, ssn, username)
VALUES (101,'california','litu@ranjan.com', 'litu', 'jena', 'admin', 'ssn101', 'liran');

INSERT INTO person (id, address, email, first_name, last_name, role, ssn, username)
VALUES (102,'new york','syam@ranjan.com', 'syam','wiser','admin','ssn102','syran');

INSERT INTO person (id, address, email, first_name, last_name, role, ssn, username)
VALUES (103,'new jersy','bela@ranjan.com', 'bela','david','admin','ssn103','beran');

insert into orders values (2001,'order11',101);
insert into orders values (2002,'order12',101);
insert into orders values (2003,'order13',101);
insert into orders values (2004,'order21',102);
insert into orders values (2005,'order22',102);
insert into orders values (2006,'order31',103);