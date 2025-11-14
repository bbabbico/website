package project7.website.ranking;

import lombok.Getter;
import project7.website.Database.Repository.RankingItemRepository;


public class RankingService {

    public RankingItemRepository Item =  new RankingItemRepository();

    public RankingService() {
    }
}
