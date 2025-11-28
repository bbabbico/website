package project7.website.Database.Repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project7.website.Database.member.Member;
import project7.website.Database.member.MemberRepository;
import project7.website.Database.member.SavedItem;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SavedItemService {

    private final MemberRepository memberRepository;
    private final RankingItemRepository rankingItemRepository;
    private final SavedItemRepository savedItemRepository;

    public String saveItem(Long memberId, RankingItemDTO dto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원"));

        // 상품이름 + 브랜드명으로 기존 RankingItem을 재사용
        Optional<RankingItem> rankingItem = rankingItemRepository
                .findByNameAndBrand(dto.name(), dto.brand()); //제품의 이름과 브랜드명으로 검색함. 한개만 나와야함
        if (rankingItem.isEmpty()) {
            return "상품 명과 상품 브랜드로 찾을 수 없거나 중복 값이 있다.";
        }

        // 이미 저장된 상품인지 체크 (중복 방지)
        boolean alreadySaved = savedItemRepository
                .findByMemberIdAndRankingItemPlatformAndRankingItemId(
                        memberId,
                        rankingItem.get().getPlatform(),
                        rankingItem.get().getId()
                ).isPresent();

        if (!alreadySaved) {
            SavedItem savedItem = new SavedItem(member, rankingItem.get());
            savedItemRepository.save(savedItem);
            return "됬다";
        }
        return "이미 저장된 상품";
    }
}