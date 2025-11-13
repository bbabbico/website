package project7.website.Controller.index;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class rankingController {
    @GetMapping("/ranking")
    public String ranking(HttpServletRequest request , Model model) {
        return  "mainmenu/ranking";
    }
}
