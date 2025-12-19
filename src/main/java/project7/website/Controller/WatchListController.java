package project7.website.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import project7.website.Database.Repository.RankingItem.RankingItemDTO;
import project7.website.Database.Repository.SavedItem.SavedItemService;
import project7.website.Database.Repository.member.Member;
import project7.website.Database.Repository.member.MemberRepository;


@Slf4j
@RestController
@RequiredArgsConstructor
public class WatchListController {
    private final SavedItemService savedItemService;
    private final MemberRepository memberRepository;

    @ResponseBody
    @PostMapping("/ranking/wl")
    public RankingItemDTO addWatchList(@AuthenticationPrincipal Jwt jwt , @RequestBody RankingItemDTO rankingItemDTO) {
        RankingItemDTO result = rankingItemDTO;
        String loginId = jwt.getSubject();
        if (loginId == null) {
            result = null;
        } else {
            Member member = memberRepository.findByLoginId(loginId).get(); //회원 고유 식별 ID 조회
            log.info(savedItemService.saveItem(member.getId(),result));
        }

        return result;
    }
}
