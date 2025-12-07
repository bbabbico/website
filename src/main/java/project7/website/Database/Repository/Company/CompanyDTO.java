package project7.website.Database.Repository.Company;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyDTO {

    private Long id;          // PK (필요 없으면 지워도 됨)
    private Integer rank_no;     // 순위
    private String img;       // 이미지 URL
    private String name;      // 기업명
    private Long mrktTotAmt;  // 시가총액
    private Integer globalrank; // 세계순위
    private Long clpr;        // 현재 주가
    private String vs;        // 전일 대비(문자열)

    // Entity -> DTO 변환용
    public static CompanyDTO from(Company company) {
        if (company == null) return null;

        return CompanyDTO.builder()
                .id(company.getId())
                .rank_no(company.getRank_no())
                .img(company.getImg())
                .name(company.getName())
                .mrktTotAmt(company.getMrktTotAmt())
                .globalrank(company.getGlobalrank())
                .clpr(company.getClpr())
                .vs(company.getVs())
                .build();
    }
}