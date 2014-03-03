CREATE TABLE IF NOT EXISTS `car` (
  `id` int(11) NOT NULL,
  `company` varchar(45) NOT NULL,
  `model` varchar(45) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `user` (
  `userid` int(10) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `category` (
  `categoryId` int(11) NOT NULL,
  `categoryName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `categorydetail` (
  `catDetailId` int(11) NOT NULL,
  `categoryId` int(11) DEFAULT NULL,
  `rssUrl` varchar(150) DEFAULT NULL,
  `companyUrl` varchar(150) DEFAULT NULL,
  `company` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`catDetailId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
