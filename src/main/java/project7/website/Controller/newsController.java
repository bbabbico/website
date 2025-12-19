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
public class newsController {

    private final AuthenticatedUserService authenticatedUserService;

    @GetMapping("/news")
    public String news(@AuthenticationPrincipal Jwt jwt , Model model) {
        authenticatedUserService.addUserName(jwt, model);
        return  "mainmenu/newsindex";

    }
}
