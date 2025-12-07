package project7.website.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project7.website.Database.Repository.SavedItem.SavedItemRepository;
import project7.website.Database.Repository.member.Member;
import project7.website.session.SessionConst;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MyPageController {

    private final SavedItemRepository savedItemRepository;

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
            Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);

            model.addAttribute("savedList", savedItemRepository.findByMemberId(member.getId()));
            model.addAttribute("member",member);
            return "mypage/saved";
        }
        return "redirect:/";
    }

}
