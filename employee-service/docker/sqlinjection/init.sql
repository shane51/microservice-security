CREATE USER 'globalaccess_user'@'%' IDENTIFIED BY '789as8asjk';
GRANT ALL ON *.* TO 'globalaccess_user'@'%';

CREATE USER 'empdb_user'@'%' IDENTIFIED BY '87a98asjhas8';
GRANT ALL ON employees.* TO 'empdb_user'@'%';

CREATE DATABASE employees;
USE employees;

CREATE TABLE `employee` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `organizationId` bigint DEFAULT NULL,
  `departmentId` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
);

insert into employee values ( 1111,34,1,"John Smith",1,"pass","STAFF");
insert into employee values ( 1112,37,1,"Darren Hamilton",1,"pass","MANAGER");
insert into employee values ( 1113,26,1,"Anna London",1,"pass","STAFF");
insert into employee values ( 1114,39,1,"Patrick Dempsey", 2,"pass", "STAFF");
insert into employee values ( 1115,27,1,"Kevin Price", 1,"pass", "STAFF");
DELIMITER $$
CREATE PROCEDURE `filterByUsernameStoredProcedureUnSafe` (in p_name varchar(1000))
begin
SET @SQLString = CONCAT("Select * from employee where name = '", p_name, "'");
PREPARE test FROM @SQLString;
EXECUTE test;
end $$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE `filterByUsernameStoredProcedureSafe`(in p_name varchar(1000))
begin
SELECT * from employee WHERE name = p_name;
end $$
DELIMITER ;


CREATE DATABASE management;
USE management;

CREATE TABLE `employee_review` (
  `id` bigint NOT NULL,
  `employee_id` bigint NOT NULL,
  `review` varchar(2148) NOT NULL,
  `rating` enum ('1','2','3','4','5') NOT NULL,
  PRIMARY KEY (`id`)
);

insert into employee_review values (1,1111,"Good performance", 5);
insert into employee_review values (2,1113,"okay performance", 3);