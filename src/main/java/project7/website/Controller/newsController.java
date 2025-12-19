package project7.website.Controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import project7.website.Database.Repository.member.Member;
import project7.website.session.SessionConst;

@Controller
public class newsController {

    @GetMapping("/news")
    public String news(@AuthenticationPrincipal Jwt jwt , Model model) {
        if (jwt != null) { //로그인 세션 존재하면 view 전달
            String name = jwt.getClaimAsString("name");
            model.addAttribute("name", name);
        } else {
            return "mainmenu/newsindex"; //세션에 회원 데이터가 없으면 빈 Model 전달
        }
        return  "mainmenu/newsindex";

    }
}
