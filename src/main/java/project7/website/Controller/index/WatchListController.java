package project7.website.Controller.index;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project7.website.Database.Repository.RankingItemDTO;

@RestController
public class WatchListController {
    //랭킹 사이트 API
    //장바구니 사이트 API


    @PostMapping("/ranking/wl")
    public String addWatchList(@RequestBody RankingItemDTO rankingItemDTO) {

        return null;
    }
}
