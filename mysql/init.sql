SET NAMES utf8mb4; -- 한글 지원 --

CREATE TABLE `company` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `clpr` bigint NOT NULL,
    `globalrank` int NOT NULL,
    `img` varchar(1000) NOT NULL,
    `mrkt_tot_amt` bigint NOT NULL,
    `name` varchar(500) NOT NULL,
    `rank_no` int NOT NULL,
    `vs` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
)

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
  `img` varchar(1000) NOT NULL,
  `url` varchar(1000) NOT NULL,
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

-- 테스트용 데이터 --
INSERT INTO `company` VALUES (3,254500,5,'https://images.unsplash.com/photo-1655568561429-2da330af5442?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w3Nzg4Nzd8MHwxfHNlYXJjaHwxfHxiZWF1dHklMjBwcm9kdWN0JTIwcGFja2FnaW5nfGVufDF8fHx8MTc2NTA3NTAxOXww&ixlib=rb-4.1.0&q=80&w=1080',9530000000000,'APR',1,'+2.83%'),
                             (4,254500,5,'https://images.unsplash.com/photo-1655568561429-2da330af5442?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w3Nzg4Nzd8MHwxfHNlYXJjaHwxfHxiZWF1dHklMjBwcm9kdWN0JTIwcGFja2FnaW5nfGVufDF8fHx8MTc2NTA3NTAxOXww&ixlib=rb-4.1.0&q=80&w=1080',9530000000000,'APR',2,'-2.83%'),
                             (5,254500,5,'https://images.unsplash.com/photo-1655568561429-2da330af5442?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w3Nzg4Nzd8MHwxfHNlYXJjaHwxfHxiZWF1dHklMjBwcm9kdWN0JTIwcGFja2FnaW5nfGVufDF8fHx8MTc2NTA3NTAxOXww&ixlib=rb-4.1.0&q=80&w=1080',9530000000000,'APR',3,'0111');


INSERT INTO `member` VALUES (1,'ppoow@naer.com','qweeee','erqwe','rqwetrt'),(2,'wonehgus1234@naver.com','qweqwe','qweqwe','qweqwe');

INSERT INTO `saved_item` VALUES (1,2,1);