package project7.website.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project7.website.Security.AuthenticatedUserService;

@Controller
@RequiredArgsConstructor
public class indexController {

    private final AuthenticatedUserService authenticatedUserService;
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
        authenticatedUserService.addUserName(jwt, model);
        return "index";
    }



}
