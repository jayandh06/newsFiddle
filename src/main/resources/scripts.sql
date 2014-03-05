CREATE TABLE IF NOT EXISTS `car` (
  `id` int(11) NOT NULL,
  `company` varchar(45) NOT NULL,	am
  `model` varchar(45) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `active` bit(1) NOT NULL,
  PRIMARY KEY (`userId`)
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

