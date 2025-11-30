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
insert into rankingitem values(
                                  null,
                                  0,
                                  "https://image.oliveyoung.co.kr/cfimages/cf-goods/uploads/images/thumbnails/400/10/0000/0023/A00000023633808ko.jpg?l=ko",
                                  "https://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000236338&dispCatNo=90000010009&trackingCd=Best_Sellingbest&t_page=%EB%9E%AD%ED%82%B9&t_click=%ED%8C%90%EB%A7%A4%EB%9E%AD%ED%82%B9_%EC%A0%84%EC%B2%B4_%EC%83%81%ED%92%88%EC%83%81%EC%84%B8&t_number=1",
                                  "[11월 올영픽] 에스트라 아토베리어365 크림 80ml 더블 기획(+에센스 25ML + 세라-히알 앰플 7ML)",
                                  "에스트라1",
                                  "100,000,000"
                              );
insert into rankingitem values(
                                  null,
                                  0,
                                  "https://image.oliveyoung.co.kr/cfimages/cf-goods/uploads/images/thumbnails/400/10/0000/0023/A00000023633808ko.jpg?l=ko",
                                  "https://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000236338&dispCatNo=90000010009&trackingCd=Best_Sellingbest&t_page=%EB%9E%AD%ED%82%B9&t_click=%ED%8C%90%EB%A7%A4%EB%9E%AD%ED%82%B9_%EC%A0%84%EC%B2%B4_%EC%83%81%ED%92%88%EC%83%81%EC%84%B8&t_number=1",
                                  "[11월 올영픽] 에스트라 아토베리어365 크림 80ml 더블 기획(+에센스 25ML + 세라-히알 앰플 7ML)",
                                  "에스트라2",
                                  "100,000,000"
                              );
insert into rankingitem values(
                                  null,
                                  0,
                                  "https://image.oliveyoung.co.kr/cfimages/cf-goods/uploads/images/thumbnails/400/10/0000/0023/A00000023633808ko.jpg?l=ko",
                                  "https://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000236338&dispCatNo=90000010009&trackingCd=Best_Sellingbest&t_page=%EB%9E%AD%ED%82%B9&t_click=%ED%8C%90%EB%A7%A4%EB%9E%AD%ED%82%B9_%EC%A0%84%EC%B2%B4_%EC%83%81%ED%92%88%EC%83%81%EC%84%B8&t_number=1",
                                  "[11월 올영픽] 에스트라 아토베리어365 크림 80ml 더블 기획(+에센스 25ML + 세라-히알 앰플 7ML)",
                                  "에스트라3",
                                  "100,000,000"
                              );
insert into rankingitem values(
                                  null,
                                  0,
                                  "https://image.oliveyoung.co.kr/cfimages/cf-goods/uploads/images/thumbnails/400/10/0000/0023/A00000023633808ko.jpg?l=ko",
                                  "https://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000236338&dispCatNo=90000010009&trackingCd=Best_Sellingbest&t_page=%EB%9E%AD%ED%82%B9&t_click=%ED%8C%90%EB%A7%A4%EB%9E%AD%ED%82%B9_%EC%A0%84%EC%B2%B4_%EC%83%81%ED%92%88%EC%83%81%EC%84%B8&t_number=1",
                                  "[11월 올영픽] 에스트라 아토베리어365 크림 80ml 더블 기획(+에센스 25ML + 세라-히알 앰플 7ML)",
                                  "에스트라4",
                                  "100,000,000"
                              );

insert into rankingitem values(
                                  null,
                                  1,
                                  "https://image.oliveyoung.co.kr/cfimages/cf-goods/uploads/images/thumbnails/400/10/0000/0023/A00000023633808ko.jpg?l=ko",
                                  "https://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000236338&dispCatNo=90000010009&trackingCd=Best_Sellingbest&t_page=%EB%9E%AD%ED%82%B9&t_click=%ED%8C%90%EB%A7%A4%EB%9E%AD%ED%82%B9_%EC%A0%84%EC%B2%B4_%EC%83%81%ED%92%88%EC%83%81%EC%84%B8&t_number=1",
                                  "[11월 올영픽] 에스트라 아토베리어365 크림 80ml 더블 기획(+에센스 25ML + 세라-히알 앰플 7ML)",
                                  "에스트라12",
                                  "100,000,000"
                              );
insert into rankingitem values(
                                  null,
                                  1,
                                  "https://image.oliveyoung.co.kr/cfimages/cf-goods/uploads/images/thumbnails/400/10/0000/0023/A00000023633808ko.jpg?l=ko",
                                  "https://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000236338&dispCatNo=90000010009&trackingCd=Best_Sellingbest&t_page=%EB%9E%AD%ED%82%B9&t_click=%ED%8C%90%EB%A7%A4%EB%9E%AD%ED%82%B9_%EC%A0%84%EC%B2%B4_%EC%83%81%ED%92%88%EC%83%81%EC%84%B8&t_number=1",
                                  "[11월 올영픽] 에스트라 아토베리어365 크림 80ml 더블 기획(+에센스 25ML + 세라-히알 앰플 7ML)",
                                  "에스트라22",
                                  "100,000,000"
                              );
insert into rankingitem values(
                                  null,
                                  1,
                                  "https://image.oliveyoung.co.kr/cfimages/cf-goods/uploads/images/thumbnails/400/10/0000/0023/A00000023633808ko.jpg?l=ko",
                                  "https://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000236338&dispCatNo=90000010009&trackingCd=Best_Sellingbest&t_page=%EB%9E%AD%ED%82%B9&t_click=%ED%8C%90%EB%A7%A4%EB%9E%AD%ED%82%B9_%EC%A0%84%EC%B2%B4_%EC%83%81%ED%92%88%EC%83%81%EC%84%B8&t_number=1",
                                  "[11월 올영픽] 에스트라 아토베리어365 크림 80ml 더블 기획(+에센스 25ML + 세라-히알 앰플 7ML)",
                                  "에스트라32",
                                  "100,000,000"
                              );
insert into rankingitem values(
                                  null,
                                  1,
                                  "https://image.oliveyoung.co.kr/cfimages/cf-goods/uploads/images/thumbnails/400/10/0000/0023/A00000023633808ko.jpg?l=ko",
                                  "https://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000236338&dispCatNo=90000010009&trackingCd=Best_Sellingbest&t_page=%EB%9E%AD%ED%82%B9&t_click=%ED%8C%90%EB%A7%A4%EB%9E%AD%ED%82%B9_%EC%A0%84%EC%B2%B4_%EC%83%81%ED%92%88%EC%83%81%EC%84%B8&t_number=1",
                                  "[11월 올영픽] 에스트라 아토베리어365 크림 80ml 더블 기획(+에센스 25ML + 세라-히알 앰플 7ML)",
                                  "에스트라42",
                                  "100,000,000"
                              );

insert into rankingitem values(
                                  null,
                                  2,
                                  "https://image.oliveyoung.co.kr/cfimages/cf-goods/uploads/images/thumbnails/400/10/0000/0023/A00000023633808ko.jpg?l=ko",
                                  "https://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000236338&dispCatNo=90000010009&trackingCd=Best_Sellingbest&t_page=%EB%9E%AD%ED%82%B9&t_click=%ED%8C%90%EB%A7%A4%EB%9E%AD%ED%82%B9_%EC%A0%84%EC%B2%B4_%EC%83%81%ED%92%88%EC%83%81%EC%84%B8&t_number=1",
                                  "[11월 올영픽] 에스트라 아토베리어365 크림 80ml 더블 기획(+에센스 25ML + 세라-히알 앰플 7ML)",
                                  "에스트라13",
                                  "100,000,000"
                              );
insert into rankingitem values(
                                  null,
                                  2,
                                  "https://image.oliveyoung.co.kr/cfimages/cf-goods/uploads/images/thumbnails/400/10/0000/0023/A00000023633808ko.jpg?l=ko",
                                  "https://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000236338&dispCatNo=90000010009&trackingCd=Best_Sellingbest&t_page=%EB%9E%AD%ED%82%B9&t_click=%ED%8C%90%EB%A7%A4%EB%9E%AD%ED%82%B9_%EC%A0%84%EC%B2%B4_%EC%83%81%ED%92%88%EC%83%81%EC%84%B8&t_number=1",
                                  "[11월 올영픽] 에스트라 아토베리어365 크림 80ml 더블 기획(+에센스 25ML + 세라-히알 앰플 7ML)",
                                  "에스트라23",
                                  "100,000,000"
                              );
insert into rankingitem values(
                                  null,
                                  2,
                                  "https://image.oliveyoung.co.kr/cfimages/cf-goods/uploads/images/thumbnails/400/10/0000/0023/A00000023633808ko.jpg?l=ko",
                                  "https://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000236338&dispCatNo=90000010009&trackingCd=Best_Sellingbest&t_page=%EB%9E%AD%ED%82%B9&t_click=%ED%8C%90%EB%A7%A4%EB%9E%AD%ED%82%B9_%EC%A0%84%EC%B2%B4_%EC%83%81%ED%92%88%EC%83%81%EC%84%B8&t_number=1",
                                  "[11월 올영픽] 에스트라 아토베리어365 크림 80ml 더블 기획(+에센스 25ML + 세라-히알 앰플 7ML)",
                                  "에스트라33",
                                  "100,000,000"
                              );
insert into rankingitem values(
                                  null,
                                  2,
                                  "https://image.oliveyoung.co.kr/cfimages/cf-goods/uploads/images/thumbnails/400/10/0000/0023/A00000023633808ko.jpg?l=ko",
                                  "https://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000236338&dispCatNo=90000010009&trackingCd=Best_Sellingbest&t_page=%EB%9E%AD%ED%82%B9&t_click=%ED%8C%90%EB%A7%A4%EB%9E%AD%ED%82%B9_%EC%A0%84%EC%B2%B4_%EC%83%81%ED%92%88%EC%83%81%EC%84%B8&t_number=1",
                                  "[11월 올영픽] 에스트라 아토베리어365 크림 80ml 더블 기획(+에센스 25ML + 세라-히알 앰플 7ML)",
                                  "에스트라43",
                                  "100,000,000"
                              );

insert into rankingitem values(
                                  null,
                                  3,
                                  "https://image.oliveyoung.co.kr/cfimages/cf-goods/uploads/images/thumbnails/400/10/0000/0023/A00000023633808ko.jpg?l=ko",
                                  "https://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000236338&dispCatNo=90000010009&trackingCd=Best_Sellingbest&t_page=%EB%9E%AD%ED%82%B9&t_click=%ED%8C%90%EB%A7%A4%EB%9E%AD%ED%82%B9_%EC%A0%84%EC%B2%B4_%EC%83%81%ED%92%88%EC%83%81%EC%84%B8&t_number=1",
                                  "[11월 올영픽] 에스트라 아토베리어365 크림 80ml 더블 기획(+에센스 25ML + 세라-히알 앰플 7ML)",
                                  "에스트라14",
                                  "100,000,000"
                              );
insert into rankingitem values(
                                  null,
                                  3,
                                  "https://image.oliveyoung.co.kr/cfimages/cf-goods/uploads/images/thumbnails/400/10/0000/0023/A00000023633808ko.jpg?l=ko",
                                  "https://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000236338&dispCatNo=90000010009&trackingCd=Best_Sellingbest&t_page=%EB%9E%AD%ED%82%B9&t_click=%ED%8C%90%EB%A7%A4%EB%9E%AD%ED%82%B9_%EC%A0%84%EC%B2%B4_%EC%83%81%ED%92%88%EC%83%81%EC%84%B8&t_number=1",
                                  "[11월 올영픽] 에스트라 아토베리어365 크림 80ml 더블 기획(+에센스 25ML + 세라-히알 앰플 7ML)",
                                  "에스트라24",
                                  "100,000,000"
                              );
insert into rankingitem values(
                                  null,
                                  3,
                                  "https://image.oliveyoung.co.kr/cfimages/cf-goods/uploads/images/thumbnails/400/10/0000/0023/A00000023633808ko.jpg?l=ko",
                                  "https://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000236338&dispCatNo=90000010009&trackingCd=Best_Sellingbest&t_page=%EB%9E%AD%ED%82%B9&t_click=%ED%8C%90%EB%A7%A4%EB%9E%AD%ED%82%B9_%EC%A0%84%EC%B2%B4_%EC%83%81%ED%92%88%EC%83%81%EC%84%B8&t_number=1",
                                  "[11월 올영픽] 에스트라 아토베리어365 크림 80ml 더블 기획(+에센스 25ML + 세라-히알 앰플 7ML)",
                                  "에스트라34",
                                  "100,000,000"
                              );
insert into rankingitem values(
                                  null,
                                  3,
                                  "https://image.oliveyoung.co.kr/cfimages/cf-goods/uploads/images/thumbnails/400/10/0000/0023/A00000023633808ko.jpg?l=ko",
                                  "https://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000236338&dispCatNo=90000010009&trackingCd=Best_Sellingbest&t_page=%EB%9E%AD%ED%82%B9&t_click=%ED%8C%90%EB%A7%A4%EB%9E%AD%ED%82%B9_%EC%A0%84%EC%B2%B4_%EC%83%81%ED%92%88%EC%83%81%EC%84%B8&t_number=1",
                                  "[11월 올영픽] 에스트라 아토베리어365 크림 80ml 더블 기획(+에센스 25ML + 세라-히알 앰플 7ML)",
                                  "에스트라44",
                                  "100,000,000"
                              );


INSERT INTO `saved_item` VALUES (1,2,1);