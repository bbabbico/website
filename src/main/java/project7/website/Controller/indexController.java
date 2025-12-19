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
public class indexController {
    /**
     * @SessionAttribute 는 세션을 확인하는 에너테이션이며, 세션이 없으면 새로 생성하지않음.
     * 기본적으로 세션 ID를 URL에 저장하여 유지함
     * 또한 해당 컨트롤러 밖에서 만들어진 세션도 접근가능
     *
     * @SessionAttributes 는 해당 컨트롤러 안에서만 작동함.
     *
     * application.properties 에 server.servlet.session.tracking-modes=cookie 추가하면 세션 ID를 쿠키에담음.
     * URL에 jsessionid 포함하지 않음.
     */
    @GetMapping("/")
    public String index(@AuthenticationPrincipal Jwt jwt , Model model) {
        if (jwt != null) { //로그인 세션 존재하면 view 전달
            String name = jwt.getClaimAsString("name");
            model.addAttribute("name", name);
        } else {
            return "/index"; //세션에 회원 데이터가 없으면 빈 Model 전달
        }


        return "index";
    }



}
