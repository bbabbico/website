package project7.website.Controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import project7.website.Database.Repository.RankingItemDTO;
import project7.website.Database.Repository.RankingItemRepository;
import project7.website.Database.member.Member;
import project7.website.session.SessionConst;

@Controller
public class rankingController {
    @GetMapping("/ranking")
    public String ranking(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember , Model model) {

        RankingItemRepository repo = new RankingItemRepository();
        repo.addRankingItemDTOList(new RankingItemDTO("https://image.oliveyoung.co.kr/cfimages/cf-goods/uploads/images/thumbnails/400/10/0000/0023/A00000023633808ko.jpg?l=ko",
                "https://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000236338&dispCatNo=90000010009&trackingCd=Best_Sellingbest&t_page=%EB%9E%AD%ED%82%B9&t_click=%ED%8C%90%EB%A7%A4%EB%9E%AD%ED%82%B9_%EC%A0%84%EC%B2%B4_%EC%83%81%ED%92%88%EC%83%81%EC%84%B8&t_number=1",
                "에스트라",
                "[11월 올영픽] 에스트라 아토베리어365 크림 80ml 더블 기획(+에센스 25ML + 세라-히알 앰플 7ML)",
                "100,000,000")
        );
        repo.addRankingItemDTOList(new RankingItemDTO("https://image.oliveyoung.co.kr/cfimages/cf-goods/uploads/images/thumbnails/400/10/0000/0023/A00000023633808ko.jpg?l=ko",
                "https://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000236338&dispCatNo=90000010009&trackingCd=Best_Sellingbest&t_page=%EB%9E%AD%ED%82%B9&t_click=%ED%8C%90%EB%A7%A4%EB%9E%AD%ED%82%B9_%EC%A0%84%EC%B2%B4_%EC%83%81%ED%92%88%EC%83%81%EC%84%B8&t_number=1",
                "에스트라",
                "[11월 올영픽] 에스트라 아토베리어365 크림 80ml 더블 기획(+에센스 25ML + 세라-히알 앰플 7ML)",
                "25,000,000")
        );
        repo.addRankingItemDTOList(new RankingItemDTO("https://image.oliveyoung.co.kr/cfimages/cf-goods/uploads/images/thumbnails/400/10/0000/0023/A00000023633808ko.jpg?l=ko",
                "https://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000236338&dispCatNo=90000010009&trackingCd=Best_Sellingbest&t_page=%EB%9E%AD%ED%82%B9&t_click=%ED%8C%90%EB%A7%A4%EB%9E%AD%ED%82%B9_%EC%A0%84%EC%B2%B4_%EC%83%81%ED%92%88%EC%83%81%EC%84%B8&t_number=1",
                "에스트라",
                "[11월 올영픽] 에스트라 아토베리어365 크림 80ml 더블 기획(+에센스 25ML + 세라-히알 앰플 7ML)",
                "10,000,000")
        );
        repo.addRankingItemDTOList(new RankingItemDTO("https://image.oliveyoung.co.kr/cfimages/cf-goods/uploads/images/thumbnails/400/10/0000/0023/A00000023633808ko.jpg?l=ko",
                "https://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000236338&dispCatNo=90000010009&trackingCd=Best_Sellingbest&t_page=%EB%9E%AD%ED%82%B9&t_click=%ED%8C%90%EB%A7%A4%EB%9E%AD%ED%82%B9_%EC%A0%84%EC%B2%B4_%EC%83%81%ED%92%88%EC%83%81%EC%84%B8&t_number=1",
                "에스트라",
                "[11월 올영픽] 에스트라 아토베리어365 크림 80ml 더블 기획(+에센스 25ML + 세라-히알 앰플 7ML)",
                "7,000,000")
        );
        repo.addRankingItemDTOList(new RankingItemDTO("https://image.oliveyoung.co.kr/cfimages/cf-goods/uploads/images/thumbnails/400/10/0000/0023/A00000023633808ko.jpg?l=ko",
                "https://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000236338&dispCatNo=90000010009&trackingCd=Best_Sellingbest&t_page=%EB%9E%AD%ED%82%B9&t_click=%ED%8C%90%EB%A7%A4%EB%9E%AD%ED%82%B9_%EC%A0%84%EC%B2%B4_%EC%83%81%ED%92%88%EC%83%81%EC%84%B8&t_number=1",
                "에스트라",
                "[11월 올영픽] 에스트라 아토베리어365 크림 80ml 더블 기획(+에센스 25ML + 세라-히알 앰플 7ML)",
                "300,000")
        );
        model.addAttribute("Items", repo.getList());

        //세션에 회원 데이터가 없으면 빈 Model 전달
        if (loginMember == null) {
            return  "mainmenu/ranking";
        }

        //로그인 세션 존재하면 view 전달
        model.addAttribute("member", loginMember);
        return  "mainmenu/ranking";
    }



}
