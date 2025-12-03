SET NAMES utf8mb4;

CREATE TABLE `member` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `login_id` varchar(30) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `rankingitem` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `platform` int NOT NULL,
  `img` varchar(700) NOT NULL,
  `url` varchar(700) NOT NULL,
  `name` varchar(300) NOT NULL,
  `brand` varchar(200) NOT NULL,
  `price` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `saved_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `member_id` bigint NOT NULL,
  `rankingitem_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_saved_item_member_ranking_item` (`member_id`),
  KEY `FK_SAVED_ITEM_ON_RANKINGITEM` (`rankingitem_id`),
  CONSTRAINT `FK_SAVED_ITEM_ON_MEMBER` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`),
  CONSTRAINT `FK_SAVED_ITEM_ON_RANKINGITEM` FOREIGN KEY (`rankingitem_id`) REFERENCES `rankingitem` (`id`)
);


INSERT INTO `member` VALUES (1,'ppoow@naer.com','qweeee','erqwe','rqwetrt'),(2,'wonehgus1234@naver.com','qweqwe','qweqwe','qweqwe');

INSERT INTO `saved_item` VALUES (1,2,1);