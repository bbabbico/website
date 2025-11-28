package project7.website.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import project7.website.Database.Repository.RankingItemDTO;
import project7.website.Database.Repository.SavedItemRepository;
import project7.website.Database.Repository.SavedItemService;
import project7.website.Database.member.Member;
import project7.website.session.SessionConst;


@Slf4j
@RestController
@RequiredArgsConstructor
public class WatchListController {
    //랭킹 사이트 API
    //장바구니 사이트 API
    private final SavedItemRepository savedItemRepository;
    private final SavedItemService savedItemService;

    @ResponseBody
    @PostMapping("/ranking/wl")
    public RankingItemDTO addWatchList(HttpServletRequest request ,@RequestBody RankingItemDTO rankingItemDTO) {
        RankingItemDTO result = rankingItemDTO;
        HttpSession session = request.getSession(false);
        if (session == null) {
            result = null;
        } else {
            Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER); //회원 고유 식별 ID 조회
            log.info(savedItemService.saveItem(member.getId(),result));
        }

        return result;
    }
}
