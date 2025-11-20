package project7.website.Database.Repository;

import java.util.LinkedList;
import java.util.List;

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
