package project7.website.Database.Repository;

import java.util.LinkedList;

public class RankingItemRepository {

    private static final LinkedList<RankingItemDTO> rankingItemDTOList = new LinkedList<>();

    public LinkedList<RankingItemDTO> addRankingItemDTOList(String img, String name, String brand, String price) {
        rankingItemDTOList.add(new RankingItemDTO(img, name, brand, price));
        return rankingItemDTOList;
    }

    /**
     *
     * @return LinkedList의 첫번째 요소 - RankingItemDTO
     */
    public RankingItemDTO popRankingItemDTOList() {
        return rankingItemDTOList.removeFirst();
    }

    /**
     * LinkedList 비우기
     */
    public static void clearRankingItemDTOList() {
        rankingItemDTOList.clear();
    }
}
