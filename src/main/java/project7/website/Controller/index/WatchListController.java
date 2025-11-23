package project7.website.Controller.index;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import project7.website.Database.Repository.RankingItemDTO;
import project7.website.Database.member.Member;
import project7.website.Database.member.SavedItem;
import project7.website.session.SessionConst;

@RestController
public class WatchListController {
    //랭킹 사이트 API
    //장바구니 사이트 API

    @ResponseBody
    @PostMapping("/ranking/wl")
    public RankingItemDTO addWatchList(HttpServletRequest request ,@RequestBody RankingItemDTO rankingItemDTO) {
        RankingItemDTO result = rankingItemDTO;
        HttpSession session = request.getSession(false);
        if (session == null) {
            result = null;
        } else {
            Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER); //회원 고유 식별 ID 조회
            SavedItem Item = new SavedItem(member.getId(), rankingItemDTO);
        }

        return result;
    }
}
