package project7.website.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project7.website.Database.Repository.RankingItem.RankingItem;
import project7.website.Database.Repository.RankingItem.RankingItemRepository;
import project7.website.Database.Repository.member.Member;
import project7.website.session.SessionConst;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class rankingController {


    private final RankingItemRepository rankingItemRepository;


    @GetMapping("/ranking")
    public String ranking(@AuthenticationPrincipal Jwt jwt , Model model) {
        if (jwt != null) { //로그인 세션 존재하면 view 전달
            String name = jwt.getClaimAsString("name");
            model.addAttribute("name", name);
        } else {
            return "mainmenu/ranking"; //세션에 회원 데이터가 없으면 빈 Model 전달
        }
        return  "mainmenu/ranking";
    }

    //랭킹 불러오기 API
    @ResponseBody
    @PostMapping("/ranking")
    public List<RankingItem> LoadRanking() {

        return new ArrayList<>(rankingItemRepository.findAll());
    }

    //실험용페이지
    @GetMapping("/test")
    public String PPP() {
        return "test/test";
    }



}
