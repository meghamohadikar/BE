CREATE DATABASE `employeetest` ;

DROP TABLE IF EXISTS `employee`.`employee`;
CREATE TABLE  `employee`.`employee` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL DEFAULT '',
  `Designation` varchar(45) NOT NULL DEFAULT '',
  `Place` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


