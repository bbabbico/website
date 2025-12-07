package project7.website.Database.Repository.RankingItem;

/**
 * 랭킹 페이지 상품
 * 구현체 : {@link RankingItemRepository}
 * <p>
 * 판매 플랫폼 번호
 * <p>
 * 0 : 올리브영
 * <p>
 * 1 : 큐텐
 * <p>
 * 2 : 쿠팡
 * <p>
 * 3 : 아마존
 *
 * @param platform 판매 플랫폼 번호
 * @param img 이미지 URL
 * @param url 올라인 몰 URL
 * @param name 상품 이름
 * @param brand 브랜드
 * @param price 가격
 */
public record RankingItemDTO(int platform ,String img, String url,String name, String brand, String price) {
}
