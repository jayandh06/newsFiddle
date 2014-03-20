
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `active` bit(1) DEFAULT NULL,
  `fbId` varchar(45) DEFAULT NULL,
  `adminUser` bit(1) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

CREATE TABLE `userprofile` (
  `userid` int(11) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `middleName` varchar(45) DEFAULT NULL,
  `emailId` varchar(45) DEFAULT NULL,
  `countryId` int(11) DEFAULT NULL,
  `zipCode` int(11) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `emailId_UNIQUE` (`emailId`),
  KEY `FK_COUNTRY_idx` (`countryId`),
  CONSTRAINT `FK_USER` FOREIGN KEY (`userid`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `category` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(45) NOT NULL,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `categorydetail` (
  `catDetailId` int(11) NOT NULL AUTO_INCREMENT,
  `rssUrl` varchar(200) NOT NULL,
  `company` varchar(45) NOT NULL,
  `companyUrl` varchar(45) DEFAULT NULL,
  `categoryId` int(11) DEFAULT NULL,
  PRIMARY KEY (`catDetailId`),
  KEY `FK_CAT_ID_idx` (`categoryId`),
  CONSTRAINT `FK_CAT_ID` FOREIGN KEY (`categoryId`) REFERENCES `category` (`categoryId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `country` (
  `countryId` int(11) NOT NULL AUTO_INCREMENT,
  `countryName` varchar(100) NOT NULL,
  PRIMARY KEY (`countryId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `news`.`category`(`categoryId`,`categoryName`)VALUES(1,'Business');
INSERT INTO `news`.`category`(`categoryId`,`categoryName`)VALUES(2,'Entertainment');
INSERT INTO `news`.`category`(`categoryId`,`categoryName`)VALUES(3,'Politics');
INSERT INTO `news`.`category`(`categoryId`,`categoryName`)VALUES(4,'Sports');
INSERT INTO `news`.`category`(`categoryId`,`categoryName`)VALUES(5,'Health');
INSERT INTO `news`.`category`(`categoryId`,`categoryName`)VALUES(6,'Local News');


