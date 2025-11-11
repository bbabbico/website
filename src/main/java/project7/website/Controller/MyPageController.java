package project7.website.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project7.website.session.SessionConst;

@Slf4j
@Controller
public class MyPageController {

    @GetMapping("mypage")
    public String MyPage(HttpServletRequest request , Model model) {
        HttpSession session = request.getSession(false);
        if(session.getId() != null){
            model.addAttribute("member",session.getAttribute(SessionConst.LOGIN_MEMBER));
            return "mypage";
        }
        return "redirect:/";
    }
}
