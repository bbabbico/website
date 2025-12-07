package project7.website.Database.Repository.SavedItem;

import jakarta.persistence.*;
import lombok.*;
import project7.website.Database.Repository.RankingItem.RankingItem;
import project7.website.Database.Repository.member.Member;

@Entity
@Table(
        name = "saved_item",
        uniqueConstraints = {
                @UniqueConstraint( //저장 한거 또 저장하면 안됨
                        name = "uk_saved_item_member_ranking_item",
                        columnNames = {"member_id", "ranking_item_id"}
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SavedItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // SavedItem 자체 PK

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rankingitem_id")
    private RankingItem rankingItem; // 여기 안에 platform, name, url 등 모두 들어있음

    // 편의 생성자
    public SavedItem(Member member, RankingItem rankingItem) {
        this.member = member;
        this.rankingItem = rankingItem;
    }
}