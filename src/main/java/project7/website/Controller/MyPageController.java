package project7.website.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project7.website.Database.Repository.SavedItem.SavedItemRepository;
import project7.website.Database.Repository.member.Member;
import project7.website.Security.AuthenticatedUserService;

import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MyPageController {

    private final SavedItemRepository savedItemRepository;
    private final AuthenticatedUserService authenticatedUserService;

    @GetMapping("mypage")
    public String MyPage(@AuthenticationPrincipal Jwt jwt , Model model) {
        Optional<Member> member = authenticatedUserService.findMember(jwt);
        if(member.isEmpty()){
            return "redirect:/";
        }
        model.addAttribute("member",member.get());
        authenticatedUserService.addUserName(jwt, model);
        return "mypage/mypage";
    }

    @GetMapping("mypage/saved")
    public String saved(@AuthenticationPrincipal Jwt jwt , Model model) {
        Optional<Member> member = authenticatedUserService.findMember(jwt);
        if(member.isEmpty()){
            return "redirect:/";
        }
        model.addAttribute("savedList", savedItemRepository.findByMemberId(member.get().getId()));
        model.addAttribute("member",member.get());
        authenticatedUserService.addUserName(jwt, model);
        return "mypage/saved";
    }

}
