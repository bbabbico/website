package project7.website.Database.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * 랭킹 페이지 상품 객체 DB 관리 클래스 (테스트용)
 *
 */
public class RankingItemRepository {

    private final LinkedList<RankingItemDTO> rankingItemDTOList = new LinkedList<>();

    public void addRankingItemDTOList(RankingItemDTO rankingItemDTO) {
        rankingItemDTOList.add(rankingItemDTO);
    }
    public List<RankingItemDTO> getList() {
        return rankingItemDTOList;
    }
    /**
     * LinkedList 비우기
     */
    public void clearRankingItemDTOList() {
        rankingItemDTOList.clear();
    }
}
