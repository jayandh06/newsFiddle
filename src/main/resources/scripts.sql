
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

INSERT INTO `categorydetail` (`catDetailId`,`rssUrl`,`company`,`companyUrl`,`categoryId`) VALUES (1,'http://www.forbes.com/business/feed/','Forbes','www.forbes.com',1);
INSERT INTO `categorydetail` (`catDetailId`,`rssUrl`,`company`,`companyUrl`,`categoryId`) VALUES (2,'http://rss.cnn.com/rss/cnn_showbiz.rss','CNN','www.cnn.com',2);
INSERT INTO `categorydetail` (`catDetailId`,`rssUrl`,`company`,`companyUrl`,`categoryId`) VALUES (3,'http://www.npr.org/rss/rss.php?id=1014','NPR News','www.npr.org',1);
INSERT INTO `categorydetail` (`catDetailId`,`rssUrl`,`company`,`companyUrl`,`categoryId`) VALUES (4,'http://feeds.foxsports.com/feedout/syndicatedContent?categoryId=0','Fox Sports','http://msn.foxsports.com/',4);
INSERT INTO `categorydetail` (`catDetailId`,`rssUrl`,`company`,`companyUrl`,`categoryId`) VALUES (5,'http://www.health.com/health/healthy-happy/feed','Health','www.health.com',5);
INSERT INTO `categorydetail` (`catDetailId`,`rssUrl`,`company`,`companyUrl`,`categoryId`) VALUES (6,'http://timesofindia.feedsportal.com/c/33039/f/533916/index.rss','Times of India','www.timesofindia.com',1);
INSERT INTO `categorydetail` (`catDetailId`,`rssUrl`,`company`,`companyUrl`,`categoryId`) VALUES (7,'http://feeds.reuters.com/reuters/lifestyle','Reuters','www.reuters.com',2);
INSERT INTO `categorydetail` (`catDetailId`,`rssUrl`,`company`,`companyUrl`,`categoryId`) VALUES (8,'http://feeds.feedburner.com/Ielts-blog','IELTS Blog','http://www.ielts-blog.com/',6);
INSERT INTO `categorydetail` (`catDetailId`,`rssUrl`,`company`,`companyUrl`,`categoryId`) VALUES (9,'http://feeds.feedburner.com/dinamalar/Front_page_news','Dinamalar','www.dinamalar.com',6);
INSERT INTO `categorydetail` (`catDetailId`,`rssUrl`,`company`,`companyUrl`,`categoryId`) VALUES (10,'http://www.dinakaran.com/rss_news.asp?id=10','Dinakaran','www.dinakaran.com',6);

INSERT INTO 'country' ('countryId','countryName') VALUES(1,'United States');
INSERT INTO 'country' ('countryId','countryName') VALUES(2,'United Kingdom');
INSERT INTO 'country' ('countryId','countryName') VALUES(3,'India');
INSERT INTO 'country' ('countryId','countryName') VALUES(4,'Singapore');
INSERT INTO 'country' ('countryId','countryName') VALUES(5,'Malaysia');
INSERT INTO 'country' ('countryId','countryName') VALUES(6,'Canada');
