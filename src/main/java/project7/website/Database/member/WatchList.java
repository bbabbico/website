package project7.website.Database.member;

import project7.website.Database.Repository.RankingItemDTO;

import java.util.Objects;

public final class WatchList {
    private final Long id;
    private final RankingItemDTO rankingItemDTO;

    public WatchList(Long id, RankingItemDTO rankingItemDTO) {
        this.id = id;
        this.rankingItemDTO = rankingItemDTO;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (WatchList) obj;
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
