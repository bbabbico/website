package project7.website.Controller.index;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class newsController {

    @GetMapping("/news")
    public String news(HttpServletRequest request , Model model) {
        return  "mainmenu/news";
    }
}
