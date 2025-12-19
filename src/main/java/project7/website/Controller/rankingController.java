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
import project7.website.Security.AuthenticatedUserService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class rankingController {


    private final RankingItemRepository rankingItemRepository;
    private final AuthenticatedUserService authenticatedUserService;


    @GetMapping("/ranking")
    public String ranking(@AuthenticationPrincipal Jwt jwt , Model model) {
        authenticatedUserService.addUserName(jwt, model);
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
