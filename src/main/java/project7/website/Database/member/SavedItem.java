package project7.website.Database.member;

import lombok.Getter;
import project7.website.Database.Repository.RankingItemDTO;
import project7.website.Database.Repository.SavedItemRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 상품 저장목록 객체
 * <p>
 * 구현체 : {@link SavedItemRepository}
 */
public class SavedItem {
    @Getter //타임리프 조회용
    private final Long id;
    @Getter //타임리프 조회용
    private final RankingItemDTO rankingItemDTO;

    @Getter
    private final Map<String, RankingItemDTO> saveditemMap = new HashMap<>();

    public SavedItem(Long id, RankingItemDTO rankingItemDTO) {
        this.id = id;
        this.rankingItemDTO = rankingItemDTO;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (SavedItem) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.rankingItemDTO, that.rankingItemDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rankingItemDTO);
    }

    @Override
    public String toString() {
        return "WatchList[" +
                "id=" + id + ", " +
                "rankingItemDTO=" + rankingItemDTO + ']';
    }


}
