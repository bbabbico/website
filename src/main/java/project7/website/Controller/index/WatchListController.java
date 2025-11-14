package project7.website.Controller.index;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WatchListController {

    @PostMapping("/ranking/wl")
    public String addWatchList(String url ,String img ,String name ,String brand ,String price){

        return url;
    }
}
