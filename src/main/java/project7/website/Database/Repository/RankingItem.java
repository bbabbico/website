package project7.website.Database.Repository;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rankingitem")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class RankingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;          // 내부 PK

    @Column(nullable = false)
    /*
     * 판매 플랫폼 번호
     * 1 : 올리브영
     * 2 : 큐텐
     * 3 : 쿠팡
     * 4 : 아마존
     */
    private int platform;

    @Column(nullable = false, length = 500)
    private String img;

    @Column(nullable = false, length = 500)
    private String url;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String brand;

    @Column(nullable = false, length = 40)
    private String price;

    // 변환
    public RankingItemDTO toDto() {
        return new RankingItemDTO(platform, img, url, name, brand, price);
    }
}