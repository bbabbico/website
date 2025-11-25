package project7.website.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project7.website.Database.Repository.RankingItemDTO;
import project7.website.Database.Repository.SavedItemRepository;
import project7.website.Database.member.SavedItem;
import project7.website.session.SessionConst;

@Slf4j
@Controller
public class MyPageController {

    @GetMapping("mypage")
    public String MyPage(HttpServletRequest request , Model model) {
        HttpSession session = request.getSession(false);
        if(session.getId() != null){
            model.addAttribute("member",session.getAttribute(SessionConst.LOGIN_MEMBER));
            return "mypage/mypage";
        }
        return "redirect:/";
    }

    @GetMapping("mypage/saved")
    public String saved(HttpServletRequest request , Model model) {
        HttpSession session = request.getSession(false);
        if(session.getId() != null){

            RankingItemDTO repo = new RankingItemDTO(1,"https://image.oliveyoung.co.kr/cfimages/cf-goods/uploads/images/thumbnails/400/10/0000/0023/A00000023633808ko.jpg?l=ko", "https://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000236338&dispCatNo=90000010009&trackingCd=Best_Sellingbest&t_page=%EB%9E%AD%ED%82%B9&t_click=%ED%8C%90%EB%A7%A4%EB%9E%AD%ED%82%B9_%EC%A0%84%EC%B2%B4_%EC%83%81%ED%92%88%EC%83%81%EC%84%B8&t_number=1", "에스트라", "[11월 올영픽] 에스트라 아토베리어365 크림 80ml 더블 기획(+에센스 25ML + 세라-히알 앰플 7ML)", "100,000,000");
            SavedItem savedItem = new SavedItem(1,repo);
            SavedItemRepository sr = new SavedItemRepository();
            sr.addSavedItemList(savedItem);
            sr.addSavedItemList(savedItem);
            sr.addSavedItemList(savedItem);
            sr.addSavedItemList(savedItem);
            sr.addSavedItemList(savedItem);
            sr.addSavedItemList(savedItem);
            sr.addSavedItemList(savedItem);

            model.addAttribute("savedList", sr.getList());
            model.addAttribute("member",session.getAttribute(SessionConst.LOGIN_MEMBER));
            return "mypage/saved";
        }
        return "redirect:/";
    }

}
