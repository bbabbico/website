package project7.website.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project7.website.Database.Repository.SavedItem.SavedItemRepository;
import project7.website.Database.Repository.member.Member;
import project7.website.Database.Repository.member.MemberRepository;
import project7.website.session.SessionConst;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MyPageController {

    private final SavedItemRepository savedItemRepository;
    private final MemberRepository memberRepository;

    @GetMapping("mypage")
    public String MyPage(@AuthenticationPrincipal Jwt jwt , Model model) {
        String loginId = jwt.getSubject();
        Member member = memberRepository.findByLoginId(loginId).orElseThrow();
        if(member.getId() != null){ //로그인 ID로 조회
            model.addAttribute("member",member);
            model.addAttribute("name",member.getName());
            return "mypage/mypage";
        }
        return "redirect:/";
    }

    @GetMapping("mypage/saved")
    public String saved(@AuthenticationPrincipal Jwt jwt , Model model) {
        String loginId = jwt.getSubject();
        Member member = memberRepository.findByLoginId(loginId).orElseThrow();
        if(member.getId() != null){
            model.addAttribute("savedList", savedItemRepository.findByMemberId(member.getId()));
            model.addAttribute("member",member);
            model.addAttribute("name",member.getName());
            return "mypage/saved";
        }
        return "redirect:/";
    }

}
