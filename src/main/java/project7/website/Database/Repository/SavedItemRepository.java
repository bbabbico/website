package project7.website.Database.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project7.website.Database.member.Member;
import project7.website.Database.member.SavedItem;
import java.util.List;
import java.util.Optional;

public interface SavedItemRepository extends JpaRepository<SavedItem, Long> {
    // 1. Member id 하나로 해당 사용자가 저장한 모든 상품
    List<SavedItem> findByMemberId(Long memberId);
    // == SELECT * FROM saved_item WHERE member_id = ?


    // 2. Member id + platform 으로 조회
    //    platform은 RankingItem 엔티티 안에 있으므로, 경로: member.id + rankingItem.platform
    List<SavedItem> findByMemberIdAndRankingItemPlatform(Long memberId, int platform);
    // == SELECT * FROM saved_item s
    //      JOIN ranking_item r ON s.ranking_item_id = r.id
    //      WHERE s.member_id = ? AND r.platform = ?


    // 3. Member id + platform + rankingItem id 로 한 가지 상품 조회
    Optional<SavedItem> findByMemberIdAndRankingItemPlatformAndRankingItemId(
            Long memberId,
            int platform,
            Long rankingItemId
    );
}
