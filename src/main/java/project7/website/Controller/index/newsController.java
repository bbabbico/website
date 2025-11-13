package project7.website.Controller.index;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import project7.website.Database.member.Member;
import project7.website.session.SessionConst;

@Controller
public class newsController {

    @GetMapping("/news")
    public String news(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember , Model model) {
        //세션에 회원 데이터가 없으면 빈 Model 전달
        if (loginMember == null) {
            return  "mainmenu/news";
        }

        //로그인 세션 존재하면 view 전달
        model.addAttribute("member", loginMember);
        return  "mainmenu/news";

    }
}
