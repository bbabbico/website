package project7.website.Database.Repository.Company;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "company")
@Getter
@Setter
@NoArgsConstructor  // 기본 생성자 자동 생성
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 순위
    @Column(nullable = false)
    private Integer rank_no;

    // 이미지 URL
    @Column(nullable = false, length = 1000)
    private String img;

    // 기업명
    @Column(nullable = false, length = 500)
    private String name;

    // 시가총액
    @Column(nullable = false)
    private Long mrktTotAmt;

    // 세계 순위
    @Column(nullable = false)
    private Integer globalrank;

    // 현재 주가
    @Column(nullable = false)
    private Long clpr;

    // 전일 대비 (문자 그대로 저장)
    @Column(nullable = false)
    private String vs;

}
