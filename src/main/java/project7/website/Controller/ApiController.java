package project7.website.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @PostMapping("/like")
    public String addLike(String url ,String img ,String name ,String brand ,String price){
        return "success";
    }
}
