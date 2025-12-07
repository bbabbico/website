package project7.website.Database.Repository.RankingItem;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RankingItemRepository extends JpaRepository<RankingItem,Long> {
    List<RankingItem> findByPlatform(int platform);
    // 플랫폼 + url 조회
    Optional<RankingItem> findByNameAndBrand(String name, String brand);
}
